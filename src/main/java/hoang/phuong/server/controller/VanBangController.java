package hoang.phuong.server.controller;

import hoang.phuong.server.model.Vanbang;
import hoang.phuong.server.service.VanBangService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
@RestController
public class VanBangController {
    private VanBangService vanBangService;

    @Inject
    public VanBangController(VanBangService vanBangService) {
        this.vanBangService = vanBangService;
    }

    /*---Add new vanbang---*/
    @PostMapping("/vanbang")
    public Vanbang save(@RequestBody Vanbang vanbang) {
        return vanBangService.save(vanbang);
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
    @PutMapping("/vanbang/update")
    public boolean update( @RequestBody Vanbang vanbang) {
        if (vanBangService.getbyId(vanbang.getId()) == null) {
            return false   ;
        }
        return vanBangService.update(vanbang);

    }

    /*---Delete a vanbang by maVB---*/
    @DeleteMapping("/vanbang/maVB-{maVB}")
    public boolean delete(@PathVariable("maVB") String maVB) {
        if (vanBangService.getByMaVB(maVB) == null) {
            return false;
        }

        return vanBangService.delete(vanBangService.getByMaVB(maVB).getId());

    }
}
