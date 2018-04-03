package hoang.phuong.server.dao;

import hoang.phuong.server.model.Diachi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiaChiDAOImpl extends AbstractDAO<Integer, Diachi> implements DiaChiDAO {
    @Override
    public int save(Diachi diachi) {
        saveDAO(diachi);
        return diachi.getId();
    }

    @Override
    public Diachi getByID(int id) {
        return getByKey(id);
    }

    @Override
    public List<Diachi> list() {
        return listDAO();
    }

    @Override
    public void update(Diachi diachi) {
        saveDAO(diachi);
    }

    @Override
    public void delete(int id) {
        deleteDAO(id);
    }
}
