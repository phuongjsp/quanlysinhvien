package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.UserRepository;
import hoang.phuong.server.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional()
public class UserRepositoryImpl extends AbstractDAO<Integer, User> implements UserRepository {


    public UserRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    //createSQLQuery("").executeUpdate();
    @Deprecated
    @Override
    public User save(User user) {
//        System.out.println("User register is : "+user);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        int i = getSession().createNativeQuery
//                ("INSERT INTO `users` (`user_name`, `user_last_name`, `email`, `password`," +
//                        "`enabled`, `is_admin`, `registered`) " +
//                        " values ('"
//                        + user.getUserName() + "','"
//                        + user.getUserLastName() + "','"
//                        + user.getEmail() + "','"
//                        + user.getPassword() + "',"
//                        + user.getEnabled() + ","
//                        + user.getAdmin() + ",'"
//                        + sdf.format(new Date()) + "');").executeUpdate();
//        User userReturn =findByEmail(user.getEmail());
//user.getRoles().forEach(role -> {
//    System.out.println("ROLE IS :"+role);
//    getSession().createNativeQuery("INSERT INTO user_roles(user_id,role) values (" +
//            userReturn.getId()+",'" +
//            role+"');").executeUpdate();
//});
//        User  userReturn2 = findByEmail(user.getEmail());
        getSession().save(user);
        return user;
    }

    @Override
    public boolean delete(User user) {
        try {
            user = getById(user.getId());
            deleteDAO(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User update(User user) {
        User user1 = getById(user.getId());
        if (user1.getUserName() != user.getUserName()) user1.setUserName(user.getUserName());
        if (user1.getUserLastName() != user.getUserLastName()) user1.setUserLastName(user.getUserLastName());
        if (user1.getPassword() != user.getPassword()) user1.setPassword(user.getPassword());
        if (user1.getEnabled() != user.getEnabled()) user1.setEnabled(user.getEnabled());
        if (user1.getRoles() != user.getRoles()) user1.setRoles(user.getRoles());
        if (user1.getAdmin() != user.getAdmin()) user1.setAdmin(user.getAdmin());
        getSession().flush();
        return user1;
    }

    @Deprecated
    @Override
    public User findByEmail(String email) {
        return (User) createEntityCriteria().add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Deprecated
    @Override
    public List<User> findAll() {
        return createEntityCriteria().list();
    }

    @Override
    public User getById(int id) {
        return getByKey(id);
    }

    @Deprecated
    @Override
    public boolean isEmailAlreadyExists(String email) {
        User user = (User) createEntityCriteria().add(Restrictions.eq("email", email)).uniqueResult();
        return user != null;
    }
}
