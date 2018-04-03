package hoang.phuong.server.controller;

import hoang.phuong.server.model.Lopsv;
import hoang.phuong.server.service.LopsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LopController {
    @Autowired
    private LopsvService lopsvService;

    /*---Add new book---*/
    @PostMapping("/lopsv")
    public ResponseEntity<?> save(@RequestBody Lopsv lopsv) {
        long id = lopsvService.save(lopsv);
        return ResponseEntity.ok().body("New Lop sv has been saved with ID:" + id);
    }


    @GetMapping("/lopsv/maLop-{maLop}")
    public ResponseEntity<Lopsv> get(@PathVariable("maLop") String maLop) {
        Lopsv lopsv = lopsvService.getByMaLop(maLop);
        return ResponseEntity.ok().body(lopsv);
    }

    /*---get all books---*/
    @GetMapping("/lopsv")
    public ResponseEntity<List<Lopsv>> list() {
        List<Lopsv> lopsvs = lopsvService.list();
        return ResponseEntity.ok().body(lopsvs);
    }

    /*---Update a book by id---*/
    @PutMapping("/lopsv/maLop-{maLop}")
    public ResponseEntity<?> update(@PathVariable("maLop") String maLop, @RequestBody Lopsv lopsv) {
        lopsv.setMaLop(maLop);
        if (lopsvService.getByMaLop(maLop) == null) {
            return ResponseEntity.badRequest().body("can not find Lop sv by ma Lop");
        }
        lopsvService.update(lopsv);
        return ResponseEntity.ok().body("Lop sv has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/lopsv/maLop-{maLop}")
    public ResponseEntity<?> delete(@PathVariable("maLop") String maLop) {
        if (lopsvService.getByMaLop(maLop) == null) {
            return ResponseEntity.badRequest().body("can not find Lop sv by ma Lop");
        }
        lopsvService.delete(maLop);
        return ResponseEntity.ok().body("Lop sv has been deleted successfully.");
    }
}
