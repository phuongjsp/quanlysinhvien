package hoang.phuong.server.controller;

import hoang.phuong.server.model.Dinhchisinhvien;
import hoang.phuong.server.service.DinhchiSinhVienService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/dinhchisinhvien")
public class DinhchiSinhvienController {
    private final DinhchiSinhVienService dinhchiSinhVienService;

    @Inject
    public DinhchiSinhvienController(DinhchiSinhVienService dinhchiSinhVienService) {
        this.dinhchiSinhVienService = dinhchiSinhVienService;
    }


    @PostMapping(path = "")
    public Dinhchisinhvien save(@RequestBody Dinhchisinhvien dinhchisinhvien) {
        return dinhchiSinhVienService.save(dinhchisinhvien);
    }

    @GetMapping("/id/{id}")
    public Dinhchisinhvien get(@PathVariable("id") int id) {
        return dinhchiSinhVienService.getOne(id);
    }


    @GetMapping("")
    public List<Dinhchisinhvien> list() {
        return dinhchiSinhVienService.findAll();
    }

    @GetMapping("/condinhchi")
    public List<Dinhchisinhvien> listcondinhchi() {
        return dinhchiSinhVienService.listConDinhChi();
    }

    @PutMapping("")
    public boolean update(@RequestBody Dinhchisinhvien dinhchisinhvien) {
        Dinhchisinhvien dinhchisinhvien1 = dinhchiSinhVienService.update(dinhchisinhvien);
        return dinhchisinhvien1 != null;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return dinhchiSinhVienService.delete(id);
    }
}
