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
    public ResponseEntity<?> save(@RequestBody Svcovb svcovb) {
        long id = svCoVbService.save(svcovb);
        return ResponseEntity.ok().body("svCoVb has been saved with ID:" + id);
    }

    /*---Get a book by id---*/
    @GetMapping("/svcovb/{id}")
    public ResponseEntity<Svcovb> get(@PathVariable("id") int id) {
        Svcovb svcovb = svCoVbService.getById(id);
        return ResponseEntity.ok().body(svcovb);
    }



    /*---get all books---*/
    @GetMapping("/svcovb")
    public ResponseEntity<List<Svcovb>> list() {
        List<Svcovb> svcovbs = svCoVbService.list();
        return ResponseEntity.ok().body(svcovbs);
    }
    @GetMapping("/svcovb/maSV-{MaSv}")
    public ResponseEntity<List<Svcovb>> listByMaSV(@PathVariable("MaSv") String MaSv) {
        List<Svcovb> svcovbs = svCoVbService.listByIdSv(thongtinsinhvienService.getByMaSV(MaSv).getId());
        return ResponseEntity.ok().body(svcovbs);
    }
    @GetMapping("/svcovb/maVB-{maVB}")
    public ResponseEntity<List<Svcovb>> listByidVB(@PathVariable("maVB") String maVB) {
        List<Svcovb> svcovbs = svCoVbService.listByLoaiVB(vanBangService.getByMaVB(maVB).getId());
        return ResponseEntity.ok().body(svcovbs);
    }
    @GetMapping("/svcovb/maSV-{MaSv}-maVB-{maVB}")
    public ResponseEntity<List<Svcovb>> listbyIdSvAndLoaiVb(
            @PathVariable("MaSv") String MaSv,
            @PathVariable("maVB") String maVB) {
        List<Svcovb> svcovbs = svCoVbService.listbyIdSvAndLoaiVb(thongtinsinhvienService.getByMaSV(MaSv).getId(),
                vanBangService.getByMaVB(maVB).getId() );
        return ResponseEntity.ok().body(svcovbs);
    }
    /*---Update a book by id---*/
    @PutMapping("/svcovb/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Svcovb svcovb) {
        svcovb.setId(id);
        if (svCoVbService.getById(id) == null) {
            return ResponseEntity.badRequest().body("can not find svcovb  by ma nganh");
        }
        svCoVbService.update(svcovb);
        return ResponseEntity.ok().body(" svcovb has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/svcovb/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (svCoVbService.getById(id) == null) {
            return ResponseEntity.badRequest().body("can not find svcovb  by ma nganh");
        }
        svCoVbService.delete(id);
        return ResponseEntity.ok().body(" svcovb has been deleted successfully.");
    }
}
