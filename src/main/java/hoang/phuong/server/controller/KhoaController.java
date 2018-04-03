package hoang.phuong.server.controller;

import hoang.phuong.server.model.Khoa;
import hoang.phuong.server.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KhoaController {
    @Autowired
    private KhoaService khoaService;

    /*---Add new book---*/
    @PostMapping("/khoa")
    public ResponseEntity<?> save(@RequestBody Khoa khoa) {
        long id = khoaService.save(khoa);
        return ResponseEntity.ok().body("New Khoa has been saved with ID:" + id);
    }

    /*---Get a book by id---*/
    @GetMapping("/khoa/{id}")
    public ResponseEntity<Khoa> get(@PathVariable("id") int id) {
        Khoa khoa = khoaService.getByID(id);
        return ResponseEntity.ok().body(khoa);
    }

    @GetMapping("/khoa/maKhoa-{maKhoa}")
    public ResponseEntity<Khoa> get(@PathVariable("maKhoa") String maKhoa) {
        Khoa khoa = khoaService.getByMaKhoa(maKhoa);
        return ResponseEntity.ok().body(khoa);
    }

    /*---get all books---*/
    @GetMapping("/khoa")
    public ResponseEntity<List<Khoa>> list() {
        List<Khoa> khoas = khoaService.list();
        return ResponseEntity.ok().body(khoas);
    }

    /*---Update a book by id---*/
    @PutMapping("/khoa/maKhoa-{maKhoa}")
    public ResponseEntity<?> update(@PathVariable("maKhoa") String maKhoa, @RequestBody Khoa khoa) {
        khoa.setMaKhoa(maKhoa);
        if (khoaService.getByMaKhoa(maKhoa) == null) {
            return ResponseEntity.badRequest().body("can not find Khoa by ma khoa");
        }
        khoaService.update(khoa);
        return ResponseEntity.ok().body("Khoa has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/khoa/maKhoa-{maKhoa}")
    public ResponseEntity<?> delete(@PathVariable("maKhoa") String maKhoa) {
        if (khoaService.getByMaKhoa(maKhoa) == null) {
            return ResponseEntity.badRequest().body("can not find Khoa by ma khoa");
        }
        khoaService.delete(maKhoa);
        return ResponseEntity.ok().body("Khoa has been deleted successfully.");
    }
}
