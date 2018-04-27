package hoang.phuong.server.controller;

import hoang.phuong.server.model.Giayto;
import hoang.phuong.server.model.Sinhviencogiayto;
import hoang.phuong.server.service.GiayToService;
import hoang.phuong.server.service.SinhviencogiaytoService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GiayToController {

    private ThongtinsinhvienService thongtinsinhvienService;
    private SinhviencogiaytoService sinhviencogiaytoService;
    private GiayToService giayToService;

    @Inject
    public GiayToController(ThongtinsinhvienService thongtinsinhvienService, SinhviencogiaytoService sinhviencogiaytoService, GiayToService giayToService) {
        this.thongtinsinhvienService = thongtinsinhvienService;
        this.sinhviencogiaytoService = sinhviencogiaytoService;
        this.giayToService = giayToService;
    }

    @PostMapping(path = "/giayto")
    public Giayto save(@RequestBody Giayto giayto) {
        return giayToService.save(giayto);
    }

    @GetMapping("/giayto/{id}")
    public Giayto get(@PathVariable("id") int id) {
        return giayToService.getById(id);
    }

    @GetMapping("/giayto/maGT-{maGT}")
    public Giayto getByMaGT(@PathVariable("maGT") String maGT) {
        return giayToService.getBymaGT(maGT);
    }

    @GetMapping("/giayto")
    public List<Giayto> list() {
        return giayToService.list();
    }

    //TODO xem cho thong tin van bang sinh vien
    @GetMapping("/giayto/SVisEmpty-{maSv}")
    public List<Giayto> getSvKhongCo(@PathVariable("maSv") String maSv) {
        List<Giayto> listfull = giayToService.list();
        List<Giayto> listReturn = new ArrayList<>();
        List<Sinhviencogiayto> sv = sinhviencogiaytoService.listByIdSv(thongtinsinhvienService.getByMaSV(maSv).getId());
        for (Sinhviencogiayto sinhviencogiayto : sv) {
            for (Giayto giayto : listfull) {
                if (sinhviencogiayto.getIdGiayTo() == giayto.getId()) listReturn.add(giayto);
            }
        }
        listReturn.forEach(listfull::remove);
        return listfull;
    }

    @PutMapping("/giayto")
    public boolean update(@RequestBody Giayto giayto) {
        return giayToService.Update(giayto);

    }

    @DeleteMapping("/giayto/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return giayToService.delete(id);

    }
}
