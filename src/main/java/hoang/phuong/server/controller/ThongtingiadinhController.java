package hoang.phuong.server.controller;

import hoang.phuong.server.model.Thongtingiadinh;
import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.service.ThongtingiadinhService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThongtingiadinhController {
    @Autowired
    private ThongtingiadinhService thongtingiadinhService;
    @Autowired
    private ThongtinsinhvienService thongtinsinhvienService;

    /*---Add new book---*/
    @PostMapping("/thongtingiadinh")
    public ResponseEntity<?> save(@RequestBody Thongtingiadinh thongtingiadinh) {
        long id = thongtingiadinhService.save(thongtingiadinh);
        return ResponseEntity.ok().body("New thong tin gia dinh has been saved with ID:" + id);
    }

    /*---Get a book by id---*/
    @GetMapping("/thongtingiadinh/{id}")
    public ResponseEntity<Thongtingiadinh> get(@PathVariable("id") int id) {
        Thongtingiadinh thongtingiadinh = thongtingiadinhService.getByID(id);
        return ResponseEntity.ok().body(thongtingiadinh);
    }

    @GetMapping("/thongtingiadinh/IDSV-{idsv}")
    public ResponseEntity<List<Thongtingiadinh>> get(@PathVariable("idsv") String idsv) {
        Thongtinsinhvien thongtinsinhvien = thongtinsinhvienService.getByMaSV(idsv);
        List<Thongtingiadinh> thongtingiadinhList = thongtingiadinhService.listByIDSv(thongtinsinhvien.getId());
        return ResponseEntity.ok().body(thongtingiadinhList);
    }

    /*---get all books---*/
    @GetMapping("/thongtingiadinh")
    public ResponseEntity<List<Thongtingiadinh>> list() {
        List<Thongtingiadinh> thongtingiadinhList = thongtingiadinhService.list();
        return ResponseEntity.ok().body(thongtingiadinhList);
    }

    /*---Update a book by id---*/
    @PutMapping("/thongtingiadinh/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Thongtingiadinh thongtingiadinh) {
        thongtingiadinh.setId(id);
        if (thongtingiadinhService.getByID(id) == null) {
            return ResponseEntity.badRequest().body("can not find thongtingiadinh by id");
        }
        thongtingiadinhService.update(thongtingiadinh);
        return ResponseEntity.ok().body("thongtingiadinh has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/thongtingiadinh/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (thongtingiadinhService.getByID(id) == null) {
            return ResponseEntity.badRequest().body("can not find thongtingiadinh by id");
        }
        thongtingiadinhService.delete(id);
        return ResponseEntity.ok().body("thongtingiadinh has been deleted successfully.");
    }
}
