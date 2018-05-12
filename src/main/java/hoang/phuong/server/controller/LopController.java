package hoang.phuong.server.controller;

import hoang.phuong.server.model.Lopsv;
import hoang.phuong.server.service.LopsvService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/lopsv")
public class LopController {
    private LopsvService lopsvService;

    @Inject
    public LopController(LopsvService lopsvService) {
        this.lopsvService = lopsvService;
    }

    @PostMapping("")
    public Lopsv save(@RequestBody Lopsv lopsv) {
        return lopsvService.save(lopsv);
    }

    @GetMapping("/maLop-{maLop}")
    public Lopsv get(@PathVariable("maLop") String maLop) {
        return lopsvService.getByMaLop(maLop);
    }

    @GetMapping("/{id}")
    public Lopsv getById(@PathVariable("id") int id) {
        return lopsvService.getbyId(id);
    }

    @GetMapping("")
    public List<Lopsv> list() {
        return lopsvService.list();
    }

    @PutMapping("")
    public boolean update(@RequestBody Lopsv lopsv) {
        return lopsvService.update(lopsv);

    }

    @DeleteMapping("/maLop-{maLop}")
    public boolean delete(@PathVariable("maLop") String maLop) {
        return lopsvService.delete(maLop);
    }
}
