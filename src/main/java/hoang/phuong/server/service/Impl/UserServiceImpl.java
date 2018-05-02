package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.ActiveuserDAO;
import hoang.phuong.server.dao.ConfirmresetpasswordDAO;
import hoang.phuong.server.dao.UserRepository;
import hoang.phuong.server.exception.EntityAlreadyExistsException;
import hoang.phuong.server.exception.EntityNotFoundException;
import hoang.phuong.server.exception.ValidationException;
import hoang.phuong.server.model.Activeuser;
import hoang.phuong.server.model.Confirmresetpassword;
import hoang.phuong.server.model.Role;
import hoang.phuong.server.model.User;
import hoang.phuong.server.service.EmailService;
import hoang.phuong.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static hoang.phuong.server.model.User.EMAIL_PATTERN;
import static hoang.phuong.server.model.User.PASSWORD_PATTERN;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    private final ActiveuserDAO activeuserDAO;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmresetpasswordDAO confirmresetpasswordDAO;

    @Inject
    public UserServiceImpl(ActiveuserDAO activeuserDAO, UserRepository userRepository, EmailService emailService,
                           BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmresetpasswordDAO confirmresetpasswordDAO) {
        this.activeuserDAO = activeuserDAO;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmresetpasswordDAO = confirmresetpasswordDAO;
    }

    @Override
    public User getOne(Integer id) {
        User user = userRepository.getById(id);
        LOG.debug("Get user with id {}", user.getId());
        return user;
    }


    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        LOG.debug("Find all users");
        return userList;
    }

    @Override
    public User save(User user) {
        user.setEmail(user.getEmail().toLowerCase());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setAdmin(false);
        user.setRegistered(java.sql.Date.valueOf(LocalDate.now()));
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        User user2 = userRepository.save(user);
        emailService.sendEmail(user.getEmail(), "Welcome to QUAN LY SINH VIEN");
        LOG.debug("Registered new user with email {}", user.getEmail());
        return user2;
    }

    @Override
    public User update(int id, User updated) {
        User user = userRepository.getById(id);
        if (!Objects.equals(user.getEmail(), updated.getEmail()) &&
                userRepository.isEmailAlreadyExists(updated.getEmail())) {
            throw new EntityAlreadyExistsException(
                    String.format("Could not update user with id %d , email %s already exist",
                            id, updated.getEmail()));
        }
        user.setUserName(updated.getUserName());
        user.setUserLastName(updated.getUserLastName());
        user.setEmail(updated.getEmail().toLowerCase());
        if (updated.getEnabled() != null && updated.getAdmin() != null) {
            user.setEnabled(updated.getEnabled());
            user.setAdmin(updated.getAdmin());
        }
        if (Boolean.TRUE.equals(updated.getAdmin()) && !user.getRoles().contains(Role.ROLE_ADMIN)) {
            user.getRoles().add(Role.ROLE_ADMIN);
        } else {
            user.setRoles(Collections.singleton(Role.ROLE_USER));
        }
        LOG.debug("Update user with id {}", id);
        return userRepository.update(user);
    }

    @Override
    public boolean updatePassword(Integer id, String currentPassword, String newPassword) {
        //!PASSWORD_PATTERN.matcher(currentPassword).matches() ||
        if (
                !PASSWORD_PATTERN.matcher(newPassword).matches()) {
            throw new ValidationException(
                    String.format("Could not update password for user with id %d , invalid password", id));
        }
        User user = userRepository.getById(id);
        if (!bCryptPasswordEncoder.matches(currentPassword, user.getPassword())) {
            throw new AccessDeniedException(
                    String.format("Could not update password, user with id %d has not confirmed password", id));
        }
        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        userRepository.updatePassword(user.getEmail(), user.getPassword());

//        emailService.sendEmail(user.getEmail(), "Your password is updated in Task Manager");
        LOG.debug("User with id {} update password", id);
        return true;
    }

    @Override
    public boolean isEmail(String email) {
        try {
            User user = userRepository.findByEmail(email);
            if (user != null) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean isKeyCodeResetPassword(String keyCode) {
        if (confirmresetpasswordDAO.getByKeyCode(keyCode) != null) {
            return true;
        }
        return false;
    }
    @Override
    public User resetPassword(String keyCode, String password) {
        try {
            if (isKeyCodeResetPassword(keyCode)) {
                Confirmresetpassword confirmresetpassword = confirmresetpasswordDAO.getByKeyCode(keyCode);
                User user = userRepository.findByEmail(confirmresetpassword.getEmail());
                if (
                        !PASSWORD_PATTERN.matcher(password).matches()) {
                    throw new ValidationException(
                            String.format("Could not update password for user  %d , invalid password", user.getUserName()));
                }
                System.out.println("USER IS " + user);
                user.setPassword(bCryptPasswordEncoder.encode(password));
                userRepository.updatePassword(user.getEmail(), user.getPassword());
                return user;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    //TODO how todo?
    @Override
    public void confirmUser(Activeuser activeuser, String path) {
        if (!EMAIL_PATTERN.matcher(activeuser.getEmail()).matches()) {
            throw new ValidationException(
                    String.format("Could not reset password, invalid email %s", activeuser.getEmail()));
        }
        if (userRepository.isEmailAlreadyExists(activeuser.getEmail())) {
            throw new EntityAlreadyExistsException(
                    String.format("Could not create user, email %s already exist", activeuser.getEmail()));
        }
        if (activeuserDAO.getByEmail(activeuser.getEmail()) != null) {
            activeuserDAO.deleteActiveuser(activeuser.getEmail());
        }
        String createKey = UUID.randomUUID().toString().replace("-", "P$");
        String keyCode = createKeyCodeActive(createKey);
        activeuser.setKeyCode(keyCode);
        activeuserDAO.create(activeuser);
        //TODO can phai xem lai noi dung tin nhan
        emailService.sendEmail(activeuser.getEmail(), "HELLO please click to link have config your Account \n" +
                path + activeuser.getKeyCode());
    }

    @Override
    public boolean isKeyCodeActive(String keyCode) {
        try {
            Activeuser activeuser = activeuserDAO.getByKeyCode(keyCode);
            if (activeuser != null) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    @Override
    public void ConfirmResetPassword(String email, String path) {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ValidationException(
                    String.format("Could not reset password, invalid email %s", email));
        }
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new EntityNotFoundException(
                    String.format("Could not reset password, user with email %s not found", email));
        }
        String createKey = UUID.randomUUID().toString().replace("-", "P$");
        Confirmresetpassword confirmresetpassword = new Confirmresetpassword();
        confirmresetpassword.setEmail(email);
        confirmresetpassword.setKeyCode(createKeyCodeResetPassword(createKey));
        confirmresetpasswordDAO.create(confirmresetpassword);
        //TODO can phai xem lai noi dung tin nhan
        emailService.sendEmail(confirmresetpassword.getEmail(), "HELLO please click to link have config your Account \n" +
                path + confirmresetpassword.getKeyCode());
        LOG.debug("User with email {} reset password", email);
    }

    @Override
    public void deleteConfirmResetPassword(String email) {
        confirmresetpasswordDAO.deleteByKeyCode(confirmresetpasswordDAO.getByByEmail(email).getKeyCode());
    }

    @Override
    public void deleteActiveUser(String email) {
        activeuserDAO.deleteActiveuser(email);

    }

    @Override
    public User isActiveUser(String keyCode) {
        if (isKeyCodeActive(keyCode)) {
            User user = new User();
            Activeuser activeuser = activeuserDAO.getByKeyCode(keyCode);
            user.setUserName(activeuser.getUsername());
            user.setUserLastName(activeuser.getUserLastName());
            user.setEmail(activeuser.getEmail());
            return user;
        }
        return null;
    }


    String createKeyCodeActive(String keyCode) {
        if (activeuserDAO.getByKeyCode(keyCode) != null) {
            keyCode = UUID.randomUUID().toString().replace("-", "P$");
            createKeyCodeActive(keyCode);
        }
        return keyCode;
    }

    String createKeyCodeResetPassword(String keyCode) {
        if (confirmresetpasswordDAO.getByKeyCode(keyCode) != null) {
            keyCode = UUID.randomUUID().toString().replace("-", "P$");
            createKeyCodeResetPassword(keyCode);
        }
        return keyCode;
    }
    @Override
    public void delete(Integer id, String password) {
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new ValidationException(
                    String.format("Could not delete user with id %d, invalid password", id));
        }
        User user = userRepository.getById(id);
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new AccessDeniedException(
                    String.format("Could not delete user with id %d, incorrect password", id));
        }
        userRepository.delete(user);
        emailService.sendEmail(user.getEmail(), "Your account has been deleted in QUAN LY SINH VIEN");
        LOG.debug("Delete user with id {}", id);
    }
}