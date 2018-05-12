package hoang.phuong.server.controller;

import hoang.phuong.server.model.Diachi;
import hoang.phuong.server.service.DiaChiService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qlsv/diachi")
public class DiaChiController {

    private DiaChiService diaChiService;

    @Inject
    public DiaChiController(DiaChiService diaChiService) {
        this.diaChiService = diaChiService;
    }

    @PostMapping("")
    public Diachi save(@RequestBody Diachi diachi) {
        return diaChiService.save(diachi);
    }

    @GetMapping("/{id}")
    public Diachi get(@PathVariable("id") int id) {
        return diaChiService.getByID(id);
    }

    @GetMapping("")
    public List<Diachi> list() {
        return diaChiService.list();
    }

    @PostMapping("/fliter")
    public List<Diachi> listByProperties(@RequestBody Map<String, String> mapparameters) {
        return diaChiService.listByProperties(mapparameters);
    }

    @PutMapping("")
    public boolean update(@RequestBody Diachi diachi) {
        return diaChiService.update(diachi);

    }

    /*---Delete a diachi by id---*/
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        if (diaChiService.getByID(id) == null) {
            return false;
        }
        diaChiService.delete(id);
        return true;
    }
}
