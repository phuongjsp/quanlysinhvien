package hoang.phuong.server.dao;


import hoang.phuong.server.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepository {
    User save(User user);

    boolean delete(User user);

    User update(User user);

    User updatePassword(String email, String newPassword);

    User findByEmail(String email);

    List<User> findAll();

    User getById(int id);

    boolean isEmailAlreadyExists(String email);

}
