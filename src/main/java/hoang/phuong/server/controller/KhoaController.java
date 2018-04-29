package hoang.phuong.server.controller;

import hoang.phuong.server.model.Khoa;
import hoang.phuong.server.service.KhoaService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/khoa")
public class KhoaController {
    private KhoaService khoaService;

    @Inject
    public KhoaController(KhoaService khoaService) {
        this.khoaService = khoaService;
    }

    @PostMapping(path = "")
    public Khoa save(@RequestBody Khoa khoa) {
        return khoaService.save(khoa);
    }

    @GetMapping("/{id}")
    public Khoa get(@PathVariable("id") int id) {
        return khoaService.getByID(id);
    }

    @GetMapping("/maKhoa-{maKhoa}")
    public Khoa get(@PathVariable("maKhoa") String maKhoa) {
        return khoaService.getByMaKhoa(maKhoa);
    }

    @GetMapping("")
    public List<Khoa> list() {
        return khoaService.list();
    }

    @PutMapping("")
    public boolean update(@RequestBody Khoa khoa) {
        return khoaService.update(khoa);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {

        return khoaService.delete(id);

    }
}
