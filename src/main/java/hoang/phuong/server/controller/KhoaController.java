package hoang.phuong.server.controller;

import hoang.phuong.server.model.Khoa;
import hoang.phuong.server.service.KhoaService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KhoaController {
    @Autowired
    private KhoaService khoaService;

    /*---Add new Khoa---*/
    @PostMapping(path = "/khoa", produces = "application/json;charset=UTF-8")
    public void save(@RequestBody Khoa khoa) {
        khoaService.save(khoa);
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
