package hoang.phuong.server.controller;

import hoang.phuong.server.model.Monhoc;
import hoang.phuong.server.service.MonhocService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/monhoc")
public class MonhocController {
    private MonhocService monhocService;

    @Inject
    public MonhocController(MonhocService monhocService) {
        this.monhocService = monhocService;
    }

    @PostMapping(path = "")
    public Monhoc save(@RequestBody Monhoc monhoc) {
        return monhocService.save(monhoc);
    }

    @GetMapping("/{id}")
    public Monhoc get(@PathVariable("id") int id) {
        return monhocService.getById(id);
    }

    @GetMapping("/maMh-{maMh}")
    public Monhoc getByMaMh(@PathVariable("maMh") String maMh) {
        return monhocService.getbyMaMh(maMh);
    }

    @GetMapping("")
    public List<Monhoc> list() {
        return monhocService.list();
    }

    @PutMapping("")
    public boolean update(@RequestBody Monhoc monhoc) {
        return monhocService.update(monhoc) != null;

    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return monhocService.delete(id);

    }
}
