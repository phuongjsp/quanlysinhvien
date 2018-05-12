package hoang.phuong.server.controller;

import hoang.phuong.server.model.Thongtingiadinh;
import hoang.phuong.server.service.ThongtingiadinhService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/thongtingiadinh")
public class ThongtingiadinhController {
    private ThongtingiadinhService thongtingiadinhService;
    private ThongtinsinhvienService thongtinsinhvienService;

    @Inject
    public ThongtingiadinhController(ThongtingiadinhService thongtingiadinhService, ThongtinsinhvienService thongtinsinhvienService) {
        this.thongtingiadinhService = thongtingiadinhService;
        this.thongtinsinhvienService = thongtinsinhvienService;
    }

    @PostMapping("")
    public Thongtingiadinh save(@RequestBody Thongtingiadinh thongtingiadinh) {
        return thongtingiadinhService.save(thongtingiadinh);
    }

    @GetMapping("/{id}")
    public Thongtingiadinh get(@PathVariable("id") int id) {
        return thongtingiadinhService.getByID(id);
    }

    @GetMapping("/IDSV-{idsv}")
    public List<Thongtingiadinh> getListByIDSv(@PathVariable("idsv") int idsv) {
        return thongtingiadinhService.listByIDSv(idsv);
    }

    @GetMapping("")
    public List<Thongtingiadinh> list() {
        return thongtingiadinhService.list();
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Thongtingiadinh thongtingiadinh) {
        return thongtingiadinhService.update(thongtingiadinh);

    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return thongtingiadinhService.delete(id);

    }
}
