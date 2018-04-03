package hoang.phuong.server.controller;

import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.model.Thongtinthem;
import hoang.phuong.server.service.ThongtinsinhvienService;
import hoang.phuong.server.service.ThongtinthemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThongtinthemController {
    @Autowired
    private ThongtinthemService thongtinthemService;

    @Autowired
    private ThongtinsinhvienService thongtinsinhvienService;

    /*---Add new book---*/
    @PostMapping("/thongtinthem")
    public ResponseEntity<?> save(@RequestBody Thongtinthem thongtinthem) {
        long id = thongtinthemService.save(thongtinthem);
        return ResponseEntity.ok().body("New thong  tin them has been saved with ID:" + id);
    }

    /*---Get a book by id---*/
    @GetMapping("/thongtinthem/{id}")
    public ResponseEntity<Thongtinthem> get(@PathVariable("id") int id) {
        Thongtinthem thongtinthem = thongtinthemService.getByID(id);
        return ResponseEntity.ok().body(thongtinthem);
    }

    @GetMapping("/thongtinthem/IDSV-{idsv}")
    public ResponseEntity<List<Thongtinthem>> get(@PathVariable("idsv") String idsv) {
        Thongtinsinhvien thongtinsinhvien = thongtinsinhvienService.getByMaSV(idsv);
        List<Thongtinthem> thongtinthemlist = thongtinthemService.listByIDSv(thongtinsinhvien.getId());
        return ResponseEntity.ok().body(thongtinthemlist);
    }

    /*---get all books---*/
    @GetMapping("/thongtinthem")
    public ResponseEntity<List<Thongtinthem>> list() {
        List<Thongtinthem> thongtinthems = thongtinthemService.list();
        return ResponseEntity.ok().body(thongtinthems);
    }

    /*---Update a book by id---*/
    @PutMapping("/thongtinthem/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Thongtinthem thongtinthem) {
        thongtinthem.setId(id);
        if (thongtinthemService.getByID(id) == null) {
            return ResponseEntity.badRequest().body("can not find thongtinthem by id");
        }
        thongtinthemService.update(thongtinthem);
        return ResponseEntity.ok().body("thongtinthem has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/thongtinthem/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (thongtinthemService.getByID(id) == null) {
            return ResponseEntity.badRequest().body("can not find thongtinthem by id");
        }
        thongtinthemService.delete(id);
        return ResponseEntity.ok().body("thongtinthem has been deleted successfully.");
    }
}
