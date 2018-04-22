package hoang.phuong.server.service;

import hoang.phuong.server.dao.GiayToDAO;
import hoang.phuong.server.model.Giayto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GiayToServiceImpl implements GiayToService {
    @Autowired
    private GiayToDAO giayToDAO;

    @Override
    public Giayto getById(int id) {
        return giayToDAO.getById(id);
    }

    @Override
    public Giayto save(Giayto giayto) {
        return giayToDAO.save(giayto);
    }

    @Override
    public boolean Update(Giayto giayto) {
        return giayToDAO.Update(giayto);
    }

    @Override
    public boolean delete(int id) {
        return giayToDAO.delete(id);
    }

    @Override
    public List<Giayto> list() {
        return giayToDAO.list();
    }

    @Override
    public Giayto getBymaGT(String maGT) {
        return giayToDAO.getBymaGT(maGT);
    }
}