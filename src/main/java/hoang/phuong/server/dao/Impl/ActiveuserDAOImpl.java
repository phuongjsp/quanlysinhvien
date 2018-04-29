package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.ActiveuserDAO;
import hoang.phuong.server.model.Activeuser;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ActiveuserDAOImpl extends AbstractDAO<Integer, Activeuser> implements ActiveuserDAO {
    public ActiveuserDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Activeuser create(Activeuser activeuser) {
        saveDAO(activeuser);
        return activeuser;
    }

    @Deprecated
    @Override
    public Activeuser getByEmail(String email) {
        return (Activeuser) createEntityCriteria().add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Deprecated
    @Override
    public Activeuser getByKeyCode(String keycode) {
        return (Activeuser) createEntityCriteria().add(Restrictions.eq("keyCode", keycode)).uniqueResult();
    }

    @Deprecated
    @Override
    public boolean deleteActiveuser(String email) {
        try {
            deleteDAO(getByEmail(email));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
