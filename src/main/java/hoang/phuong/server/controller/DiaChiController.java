package hoang.phuong.server.controller;

import hoang.phuong.server.model.Diachi;
import hoang.phuong.server.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiaChiController {
    @Autowired
    private DiaChiService diaChiService;

    /*---Add new book---*/
    @PostMapping("/diachi")
    public ResponseEntity<?> save(@RequestBody Diachi diachi) {
        long id = diaChiService.save(diachi);
        return ResponseEntity.ok().body("New Dia chi has been saved with ID:" + id);
    }

    /*---Get a book by id---*/
    @GetMapping("/diachi/{id}")
    public ResponseEntity<Diachi> get(@PathVariable("id") int id) {
        Diachi diachi = diaChiService.getByID(id);
        return ResponseEntity.ok().body(diachi);
    }

    /*---get all books---*/
    @GetMapping("/diachi")
    public ResponseEntity<List<Diachi>> list() {
        List<Diachi> diachis = diaChiService.list();
        return ResponseEntity.ok().body(diachis);
    }

    /*---Update a book by id---*/
    @PutMapping("/diachi/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Diachi diachi) {
        diachi.setId(id);
        if (diaChiService.getByID(id) == null) {
            return ResponseEntity.badRequest().body("can not find Dia Chi by id");
        }
        diaChiService.update(diachi);
        return ResponseEntity.ok().body("Dia Chi has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/diachi/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (diaChiService.getByID(id) == null) {
            return ResponseEntity.badRequest().body("can not find Dia Chi by id");
        }
        diaChiService.delete(id);
        return ResponseEntity.ok().body("Dia chi has been deleted successfully.");
    }
}
