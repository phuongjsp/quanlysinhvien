package hoang.phuong.server.service;

import hoang.phuong.server.model.Activeuser;
import hoang.phuong.server.model.User;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface UserService {
    @PreAuthorize("hasRole('ROLE_ADMIN') OR" +
            " @permissionEvaluator.hasPermissionForUser(authentication, #id)")
    User getOne(Integer id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<User> findAll();

    //ADd new User
    void confirmUser(Activeuser activeuser, String path);

    boolean isKeyCodeActive(String keyCode);

    User isActiveUser(String keyCode);

    User save(User user);

    void deleteActiveUser(String email);


    @PreAuthorize("hasRole('ROLE_ADMIN') OR" +
            " @permissionEvaluator.hasPermissionForUser(authentication, #id)")
    User update(int id, User user);

    @PreAuthorize("hasRole('ROLE_ADMIN') OR" +
            " @permissionEvaluator.hasPermissionForUser(authentication, #id)")
    boolean updatePassword(Integer id, String currentPassword, String newPassword);

    //Reset Password
    boolean isEmail(String email);

    void ConfirmResetPassword(String email, String path);

    boolean isKeyCodeResetPassword(String keyCode);

    User resetPassword(String keyCode, String password);

    void deleteConfirmResetPassword(String email);


    @PreAuthorize("hasRole('ROLE_ADMIN') OR" +
            " @permissionEvaluator.hasPermissionForUser(authentication, #id)")
    void delete(Integer id, String password);
}
