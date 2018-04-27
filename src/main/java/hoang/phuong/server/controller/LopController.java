package hoang.phuong.server.controller;

import hoang.phuong.server.model.Lopsv;
import hoang.phuong.server.service.LopsvService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
public class LopController {
    private LopsvService lopsvService;

    @Inject
    public LopController(LopsvService lopsvService) {
        this.lopsvService = lopsvService;
    }

    /*---Add new lopsv---*/
    @PostMapping("/lopsv")
    public Lopsv save(@RequestBody Lopsv lopsv) {
        return lopsvService.save(lopsv);
    }

    @GetMapping("/lopsv/maLop-{maLop}")
    public  Lopsv get(@PathVariable("maLop") String maLop) {
        return lopsvService.getByMaLop(maLop);
    }

    @GetMapping("/lopsv/{id}")
    public Lopsv getById(@PathVariable("id") int id) {
        return lopsvService.getbyId(id);
    }
    /*---get all lopsv---*/
    @GetMapping("/lopsv")
    public List<Lopsv> list() {
        return lopsvService.list();
    }

    /*---Update a lopsv by maLop---*/
    @PutMapping("/lopsv/maLop-{maLop}")
    public boolean update(@PathVariable("maLop") String maLop, @RequestBody Lopsv lopsv) {
        lopsv.setMaLop(maLop);
        if (lopsvService.getByMaLop(maLop) == null) {
            return false   ;
        }
        lopsvService.update(lopsv);
        return true;
    }

    /*---Delete a lopsv by maLop---*/
    @DeleteMapping("/lopsv/maLop-{maLop}")
    public boolean delete(@PathVariable("maLop") String maLop) {
        if (lopsvService.getByMaLop(maLop) == null) {
            return false;
        }
        lopsvService.delete(maLop);
        return true;
    }
}
