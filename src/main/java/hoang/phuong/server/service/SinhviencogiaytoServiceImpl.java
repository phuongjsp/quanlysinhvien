package hoang.phuong.server.service;

import hoang.phuong.server.dao.SinhVienCoGiayToDAO;
import hoang.phuong.server.model.Sinhviencogiayto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
public class SinhviencogiaytoServiceImpl implements SinhviencogiaytoService {
    private SinhVienCoGiayToDAO sinhVienCoGiayToDAO;

    @Inject
    public SinhviencogiaytoServiceImpl(SinhVienCoGiayToDAO sinhVienCoGiayToDAO) {
        this.sinhVienCoGiayToDAO = sinhVienCoGiayToDAO;
    }

    @Override
    public Sinhviencogiayto getbyId(int id) {
        return sinhVienCoGiayToDAO.getbyId(id);
    }

    @Override
    public Sinhviencogiayto save(Sinhviencogiayto sinhviencogiayto) {
        return sinhVienCoGiayToDAO.save(sinhviencogiayto);
    }

    @Override
    public boolean update(Sinhviencogiayto sinhviencogiayto) {
        return sinhVienCoGiayToDAO.update(sinhviencogiayto);
    }

    @Override
    public boolean delete(int id) {
        return sinhVienCoGiayToDAO.delete(id);
    }

    @Override
    public List<Sinhviencogiayto> list() {
        return sinhVienCoGiayToDAO.list();
    }

    @Override
    public List<Sinhviencogiayto> listByIdSv(int idSv) {
        return sinhVienCoGiayToDAO.listByIdSv(idSv);
    }
}
