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

    /*---Add new vanbang---*/
    @PostMapping("/vanbang")
    public void save(@RequestBody Vanbang vanbang) {
         vanBangService.save(vanbang);
    }

    /*---Get a vanbang by id---*/
    @GetMapping("/vanbang/{id}")
    public  Vanbang  get(@PathVariable("id") int id) {
        return vanBangService.getbyId(id);
    }
    /*---Get a vanbang by maVB---*/
    @GetMapping("/vanbang/maVB-{maVB}")
    public  Vanbang get(@PathVariable("maVB") String maVB) {
        return vanBangService.getByMaVB(maVB);
    }

    /*---get all vanbang---*/
    @GetMapping("/vanbang")
    public List<Vanbang>  list() {
        return vanBangService.list();
    }

    /*---Update a book by maVB---*/
    @PutMapping("/vanbang/maVB-{maVB}")
    public boolean update(@PathVariable("maVB") String maVB, @RequestBody Vanbang vanbang) {
        vanbang.setMaVanBang(maVB);
        if (vanBangService.getByMaVB(maVB) == null) {
            return false   ;
        }
        vanBangService.update(vanbang);
        return true;
    }

    /*---Delete a vanbang by maVB---*/
    @DeleteMapping("/vanbang/maVB-{maVB}")
    public boolean delete(@PathVariable("maVB") String maVB) {
        if (vanBangService.getByMaVB(maVB) == null) {
            return false;
        }

        vanBangService.delete(vanBangService.getByMaVB(maVB).getId());
        return true;
    }
}
