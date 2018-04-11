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

    /*---Add new diachi---*/
    @PostMapping("/diachi")
    public void save(@RequestBody Diachi diachi) {
         diaChiService.save(diachi);
    }

    /*---Get a diachi by id---*/
    @GetMapping("/diachi/{id}")
    public Diachi get(@PathVariable("id") int id) {
        return diaChiService.getByID(id);
    }

    /*---get all diachi---*/
    @GetMapping("/diachi")
    public  List<Diachi> list() {
        return diaChiService.list();
    }

    /*---Update a diachi by id---*/
    @PutMapping("/diachi/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Diachi diachi) {
        diachi.setId(id);
        if (diaChiService.getByID(id) == null) {
            return false;
        }
        diaChiService.update(diachi);
        return true;
    }
    /*---Delete a diachi by id---*/
    @DeleteMapping("/diachi/{id}")
    public boolean delete(@PathVariable("id") int id) {
        if (diaChiService.getByID(id) == null) {
            return true;
        }
        diaChiService.delete(id);
        return false;
    }
}
