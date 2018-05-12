package hoang.phuong.server.controller;

import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.model.Thongtinthem;
import hoang.phuong.server.service.ThongtinsinhvienService;
import hoang.phuong.server.service.ThongtinthemService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/thongtinthem")
public class ThongtinthemController {
    private ThongtinthemService thongtinthemService;
    private ThongtinsinhvienService thongtinsinhvienService;

    @Inject
    public ThongtinthemController(ThongtinthemService thongtinthemService, ThongtinsinhvienService thongtinsinhvienService) {
        this.thongtinthemService = thongtinthemService;
        this.thongtinsinhvienService = thongtinsinhvienService;
    }

    @PostMapping("")
    public Thongtinthem save(@RequestBody Thongtinthem thongtinthem) {
        return thongtinthemService.save(thongtinthem);
    }

    @GetMapping("/{id}")
    public Thongtinthem get(@PathVariable("id") int id) {
        return thongtinthemService.getByID(id);
    }

    @GetMapping("/maSv-{maSv}")
    public List<Thongtinthem> get(@PathVariable("maSv") String maSv) {
        Thongtinsinhvien thongtinsinhvien = thongtinsinhvienService.getByMaSV(maSv);
        return thongtinthemService.listByIDSv(thongtinsinhvien.getId());
    }

    @GetMapping("")
    public List<Thongtinthem> list() {
        return thongtinthemService.list();
    }

    @PutMapping("")
    public boolean update(@RequestBody Thongtinthem thongtinthem) {
        return thongtinthemService.update(thongtinthem);

    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return thongtinthemService.delete(id);

    }
}
