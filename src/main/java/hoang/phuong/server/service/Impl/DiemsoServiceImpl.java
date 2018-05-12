package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.DiemsoDAO;
import hoang.phuong.server.model.Diemso;
import hoang.phuong.server.service.DiemsoService;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.inject.Inject;
import java.util.List;

@Service
public class DiemsoServiceImpl implements DiemsoService {
    private DiemsoDAO diemsoDAO;

    @Inject
    public DiemsoServiceImpl(DiemsoDAO diemsoDAO) {
        this.diemsoDAO = diemsoDAO;
    }

    @Override
    public Diemso save(Diemso diemso) {
        return diemsoDAO.save(diemso);
    }

    @Override
    public Diemso update(Diemso diemso) {
        return diemsoDAO.update(diemso);
    }

    @Override
    public Diemso getbyId(int id) {
        return diemsoDAO.getbyId(id);
    }

    @Override
    public boolean delete(int id) {
        return diemsoDAO.delete(id);
    }

    @Override
    public List<Diemso> listBYMultivalue(MultiValueMap<String, Object> map) {
        return diemsoDAO.listBYMultivalue(map);
    }
}
