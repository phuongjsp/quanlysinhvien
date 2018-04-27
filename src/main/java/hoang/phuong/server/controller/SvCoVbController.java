package hoang.phuong.server.controller;

import hoang.phuong.server.model.Svcovb;
import hoang.phuong.server.service.SvCoVbService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import hoang.phuong.server.service.VanBangService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
@RestController
public class SvCoVbController {
    private SvCoVbService svCoVbService;
private ThongtinsinhvienService thongtinsinhvienService;
private VanBangService vanBangService;

    @Inject
    public SvCoVbController(SvCoVbService svCoVbService, ThongtinsinhvienService thongtinsinhvienService, VanBangService vanBangService) {
        this.svCoVbService = svCoVbService;
        this.thongtinsinhvienService = thongtinsinhvienService;
        this.vanBangService = vanBangService;
    }

    /*---Add new book---*/
    @PostMapping("/svcovb")
    public Svcovb save(@RequestBody Svcovb svcovb) {
        return svCoVbService.save(svcovb);
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
    @GetMapping("/svcovb/only/maSV-{MaSv}-maVB-{maVB}")
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
            return false;
        }
        return svCoVbService.update(svcovb);

    }

    /*---Delete a book by id---*/
    @DeleteMapping("/svcovb/{id}")
    public boolean dalete(@PathVariable("id") int id) {
        if (svCoVbService.getById(id) == null) {
            return false;
        }
        return svCoVbService.delete(id);

    }
}
