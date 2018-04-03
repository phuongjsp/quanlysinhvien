package hoang.phuong.server.controller;

import hoang.phuong.server.model.Vanbang;
import hoang.phuong.server.service.VanBangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class VanBangController {
    @Autowired
    private VanBangService vanBangService;

    /*---Add new book---*/
    @PostMapping("/vanbang")
    public ResponseEntity<?> save(@RequestBody Vanbang vanbang) {
        long id = vanBangService.save(vanbang);
        return ResponseEntity.ok().body("vanBang tao has been saved with ID:" + id);
    }

    /*---Get a book by id---*/
    @GetMapping("/vanbang/{id}")
    public ResponseEntity<Vanbang> get(@PathVariable("id") int id) {
        Vanbang vanbang = vanBangService.getbyId(id);
        return ResponseEntity.ok().body(vanbang);
    }

    @GetMapping("/vanbang/maVB-{maVB}")
    public ResponseEntity<Vanbang> get(@PathVariable("maVB") String maVB) {
        Vanbang vanbang = vanBangService.getByMaVB(maVB);
        return ResponseEntity.ok().body(vanbang);
    }

    /*---get all books---*/
    @GetMapping("/vanbang")
    public ResponseEntity<List<Vanbang>> list() {
        List<Vanbang> vanbangs = vanBangService.list();
        return ResponseEntity.ok().body(vanbangs);
    }

    /*---Update a book by id---*/
    @PutMapping("/vanbang/maVB-{maVB}")
    public ResponseEntity<?> update(@PathVariable("maVB") String maVB, @RequestBody Vanbang vanbang) {
        vanbang.setMaVanBang(maVB);
        if (vanBangService.getByMaVB(maVB) == null) {
            return ResponseEntity.badRequest().body("can not find Vanbang  by ma nganh");
        }
        vanBangService.update(vanbang);
        return ResponseEntity.ok().body(" Vanbang has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/vanbang/maVB-{maVB}")
    public ResponseEntity<?> delete(@PathVariable("maVB") String maVB) {
        if (vanBangService.getByMaVB(maVB) == null) {
            return ResponseEntity.badRequest().body("can not find Vanbang  by ma nganh");
        }

        vanBangService.delete(vanBangService.getByMaVB(maVB).getId());
        return ResponseEntity.ok().body(" Vanbang has been deleted successfully.");
    }
}
