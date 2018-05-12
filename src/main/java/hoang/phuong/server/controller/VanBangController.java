package hoang.phuong.server.controller;

import hoang.phuong.server.model.Vanbang;
import hoang.phuong.server.service.VanBangService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/vanbang")
public class VanBangController {
    private VanBangService vanBangService;

    @Inject
    public VanBangController(VanBangService vanBangService) {
        this.vanBangService = vanBangService;
    }

    @PostMapping("")
    public Vanbang save(@RequestBody Vanbang vanbang) {
        return vanBangService.save(vanbang);
    }

    @GetMapping("/{id}")
    public Vanbang get(@PathVariable("id") int id) {
        return vanBangService.getbyId(id);
    }

    @GetMapping("/maVB-{maVB}")
    public Vanbang get(@PathVariable("maVB") String maVB) {
        return vanBangService.getByMaVB(maVB);
    }

    @GetMapping("")
    public List<Vanbang> list() {
        return vanBangService.list();
    }

    @PutMapping("")
    public boolean update(@RequestBody Vanbang vanbang) {
        return vanBangService.update(vanbang);

    }

    @DeleteMapping("/maVB-{maVB}")
    public boolean delete(@PathVariable("maVB") String maVB) {
        return vanBangService.delete(vanBangService.getByMaVB(maVB).getId());

    }
}
