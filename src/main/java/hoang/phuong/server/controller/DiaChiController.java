package hoang.phuong.server.controller;

import hoang.phuong.server.model.Diachi;
import hoang.phuong.server.service.DiaChiService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RestController
public class DiaChiController {

    private DiaChiService diaChiService;

    @Inject
    public DiaChiController(DiaChiService diaChiService) {
        this.diaChiService = diaChiService;
    }

    /*---Add new diachi---*/
    @PostMapping("/diachi")
    public Diachi save(@RequestBody Diachi diachi) {
       return   diaChiService.save(diachi);
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
    /*---get all diachi by Properties---*/
    @PostMapping("/diachi/fliter")
    public  List<Diachi> listByProperties(@RequestBody  Map<String, String> mapparameters) {
        return diaChiService.listByProperties(mapparameters);
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
            return false;
        }
        diaChiService.delete(id);
        return true;
    }
}
