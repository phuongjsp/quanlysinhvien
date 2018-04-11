package hoang.phuong.server.controller;

import hoang.phuong.server.model.Svcovb;
import hoang.phuong.server.model.Vanbang;
import hoang.phuong.server.service.SvCoVbService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import hoang.phuong.server.service.VanBangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SvCoVbController {
    @Autowired
    private SvCoVbService svCoVbService;
@Autowired
private ThongtinsinhvienService thongtinsinhvienService;
@Autowired
private VanBangService vanBangService;
    /*---Add new book---*/
    @PostMapping("/svcovb")
    public void save(@RequestBody Svcovb svcovb) {
        svCoVbService.save(svcovb);
    }

    /*---Get a book by id---*/
    @GetMapping("/svcovb/{id}")
    public  Svcovb get(@PathVariable("id") int id) {
        return svCoVbService.getById(id);
    }
    /*---get all svcovb---*/
    @GetMapping("/svcovb")
    public List<Svcovb> list() {
        return svCoVbService.list();
    }
    /*---get all svcovb by masv---*/
    @GetMapping("/svcovb/maSV-{MaSv}")
    public List<Svcovb> istByMaSV(@PathVariable("MaSv") String MaSv) {
        return svCoVbService.listByIdSv(thongtinsinhvienService.getByMaSV(MaSv).getId());
    }
    /*---get all svcovb by mavb---*/
    @GetMapping("/svcovb/maVB-{maVB}")
    public List<Svcovb> listByidVB(@PathVariable("maVB") String maVB) {
        return svCoVbService.listByLoaiVB(vanBangService.getByMaVB(maVB).getId());
    }
    /*---get all svcovb by mavb and masv---*/
    @GetMapping("/svcovb/maSV-{MaSv}-maVB-{maVB}")
    public List<Svcovb> listbyIdSvAndLoaiVb(
            @PathVariable("MaSv") String MaSv,
            @PathVariable("maVB") String maVB) {
        return svCoVbService.listbyIdSvAndLoaiVb(thongtinsinhvienService.getByMaSV(MaSv).getId(),
                vanBangService.getByMaVB(maVB).getId() );
    }
    /*---Update a book by id---*/
    @PutMapping("/svcovb/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Svcovb svcovb) {
        svcovb.setId(id);
        if (svCoVbService.getById(id) == null) {
            return true;
        }
        svCoVbService.update(svcovb);
        return false;
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/svcovb/{id}")
    public boolean dalete(@PathVariable("id") int id) {
        if (svCoVbService.getById(id) == null) {
            return true;
        }
        svCoVbService.delete(id);
        return false;
    }
}
