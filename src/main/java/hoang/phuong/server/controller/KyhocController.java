package hoang.phuong.server.controller;

import hoang.phuong.server.model.Kyhoc;
import hoang.phuong.server.service.KyhocService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/kyhoc")
public class KyhocController {
    private KyhocService kyhocService;

    @Inject
    public KyhocController(KyhocService kyhocService) {
        this.kyhocService = kyhocService;
    }

    @PostMapping(path = "")
    public Kyhoc save(@RequestBody Kyhoc kyhoc) {
        return kyhocService.save(kyhoc);
    }

    @GetMapping("/id/{id}")
    public Kyhoc get(@PathVariable("id") int id) {
        return kyhocService.getById(id);
    }

    @GetMapping("/maKh/{maKh}")
    public Kyhoc getByMaKh(@PathVariable("maKh") String maKh) {
        return kyhocService.getBymaKh(maKh);
    }

    @GetMapping("")
    public List<Kyhoc> list() {
        return kyhocService.list();
    }

    @PutMapping("")
    public boolean update(@RequestBody Kyhoc kyhoc) {
        return kyhocService.update(kyhoc) != null;

    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return kyhocService.delete(id);

    }
}
