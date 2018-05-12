package hoang.phuong.server.controller;

import hoang.phuong.server.model.Giaovien;
import hoang.phuong.server.service.GiaoVienService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/giaovien")
public class GiaovienController {
    private GiaoVienService giaoVienService;

    @Inject
    public GiaovienController(GiaoVienService giaoVienService) {
        this.giaoVienService = giaoVienService;
    }

    @PostMapping(path = "")
    public Giaovien save(@RequestBody Giaovien giaovien) {
        return giaoVienService.save(giaovien);
    }

    @GetMapping("/{id}")
    public Giaovien get(@PathVariable("id") int id) {
        return giaoVienService.getById(id);
    }

    @GetMapping("/maGv-{maGv}")
    public Giaovien getByMaGT(@PathVariable("maGv") String maGv) {
        return giaoVienService.getBymaGv(maGv);
    }

    @GetMapping("")
    public List<Giaovien> list() {
        return giaoVienService.list();
    }

    @PutMapping("")
    public boolean update(@RequestBody Giaovien giaovien) {
        return giaoVienService.update(giaovien) != null;

    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return giaoVienService.delete(id);

    }
}
