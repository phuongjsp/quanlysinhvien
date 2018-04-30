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

    User save(User user);

    @PreAuthorize("hasRole('ROLE_ADMIN') OR" +
            " @permissionEvaluator.hasPermissionForUser(authentication, #id)")
    User update(int id, User user);

    @PreAuthorize("hasRole('ROLE_ADMIN') OR" +
            " @permissionEvaluator.hasPermissionForUser(authentication, #id)")
    void updatePassword(Integer id, String currentPassword, String newPassword);

    User resetPassword(String keyCode, String password);

    void confirmUser(Activeuser activeuser);

    boolean isKeyCodeResetPassword(String keyCode);
    void ConfirmResetPassword(String email);

    void deleteConfirmResetPassword(String email);

    void deleteActiveUser(String email);
    User isActiveUser(String keyCode);
    @PreAuthorize("hasRole('ROLE_ADMIN') OR" +
            " @permissionEvaluator.hasPermissionForUser(authentication, #id)")
    void delete(Integer id, String password);
}
