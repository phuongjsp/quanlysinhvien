package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.ConfirmresetpasswordDAO;
import hoang.phuong.server.model.Confirmresetpassword;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class ConfirmresetpasswordDAOImpl extends AbstractDAO<Integer, Confirmresetpassword> implements ConfirmresetpasswordDAO {
    @Inject
    public ConfirmresetpasswordDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Deprecated
    @Override
    public Confirmresetpassword create(Confirmresetpassword confirmresetpassword) {
        if (getByByEmail(confirmresetpassword.getEmail()) != null) {
            deleteDAO(getByByEmail(confirmresetpassword.getEmail()));
        }
        saveDAO(confirmresetpassword);
        return confirmresetpassword;
    }

    @Deprecated
    @Override
    public boolean deleteByKeyCode(String keyCode) {
        try {
            deleteDAO(getByKeyCode(keyCode));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Deprecated
    @Override
    public Confirmresetpassword getByKeyCode(String keyCode) {
        return (Confirmresetpassword) createEntityCriteria().add(Restrictions.eq("keyCode", keyCode)).uniqueResult();
    }

    @Deprecated
    @Override
    public Confirmresetpassword getByByEmail(String Email) {
        return (Confirmresetpassword) createEntityCriteria().add(Restrictions.eq("email", Email)).uniqueResult();
    }
}
