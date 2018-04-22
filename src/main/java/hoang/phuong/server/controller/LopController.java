package hoang.phuong.server.controller;

import hoang.phuong.server.model.Lopsv;
import hoang.phuong.server.service.LopsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LopController {
    @Autowired
    private LopsvService lopsvService;

    /*---Add new lopsv---*/
    @PostMapping("/lopsv")
    public Lopsv save(@RequestBody Lopsv lopsv) {
        return lopsvService.save(lopsv);
    }

    /*---get all maLop---*/
    @GetMapping("/lopsv/maLop-{maLop}")
    public  Lopsv get(@PathVariable("maLop") String maLop) {
        return lopsvService.getByMaLop(maLop);
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
