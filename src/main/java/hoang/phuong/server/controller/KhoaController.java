package hoang.phuong.server.controller;

import hoang.phuong.server.model.Khoa;
import hoang.phuong.server.service.KhoaService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
public class KhoaController {
    private KhoaService khoaService;

    @Inject
    public KhoaController(KhoaService khoaService) {
        this.khoaService = khoaService;
    }

    /*---Add new Khoa--- , produces = "application/json;charset=UTF-8"*/
    @PostMapping(path = "/khoa")
    public Khoa save(@RequestBody Khoa khoa) {
        return khoaService.save(khoa);
    }

    /*---Get a Khoa by id---*/
    @GetMapping("/khoa/{id}")
    public Khoa get(@PathVariable("id") int id) {
        return khoaService.getByID(id);
    }

    @GetMapping("/khoa/maKhoa-{maKhoa}")
    public Khoa get(@PathVariable("maKhoa") String maKhoa) {
        return khoaService.getByMaKhoa(maKhoa);
    }

    /*---get all Khoa---*/
    @GetMapping("/khoa")
    public List<Khoa> list() {
        return khoaService.list();
    }
    /*---Update a book by id---*/
    @PutMapping("/khoa/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Khoa khoa) {
        khoa.setId(id);
        if (khoaService.getByID(id) == null) {
            return false;
        }
        khoaService.update(khoa);
        return true;
    }
    /*---Delete a Khoa by id---*/
    @DeleteMapping("/khoa/{id}")
    public boolean delete(@PathVariable("id") int id) {
        if (khoaService.getByID(id) == null) {
            return false;
        }
        khoaService.delete(id);
        return true;
    }
}
