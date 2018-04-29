package hoang.phuong.server.controller;

import hoang.phuong.server.model.Sinhviencogiayto;
import hoang.phuong.server.service.SinhviencogiaytoService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/sinhviencogiayto")
public class SinhviencogiaytoController {

    private SinhviencogiaytoService sinhviencogiaytoService;
    private ThongtinsinhvienService thongtinsinhvienService;

    @Inject
    public SinhviencogiaytoController(SinhviencogiaytoService sinhviencogiaytoService, ThongtinsinhvienService thongtinsinhvienService) {
        this.sinhviencogiaytoService = sinhviencogiaytoService;
        this.thongtinsinhvienService = thongtinsinhvienService;
    }

    @PostMapping(path = "")
    public Sinhviencogiayto save(@RequestBody Sinhviencogiayto sinhviencogiayto) {
        return sinhviencogiaytoService.save(sinhviencogiayto);
    }

    @GetMapping("/{id}")
    public Sinhviencogiayto get(@PathVariable("id") int id) {
        return sinhviencogiaytoService.getbyId(id);
    }

    @GetMapping("")
    public List<Sinhviencogiayto> list() {
        return sinhviencogiaytoService.list();
    }

    @GetMapping("/maSv-{maSv}")
    public List<Sinhviencogiayto> listByMaSv(@PathVariable("maSv") String maSv) {
        return sinhviencogiaytoService.listByIdSv(thongtinsinhvienService.getByMaSV(maSv).getId());
    }

    @PutMapping("")
    public boolean update(@RequestBody Sinhviencogiayto sinhviencogiayto) {
        return sinhviencogiaytoService.update(sinhviencogiayto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return sinhviencogiaytoService.delete(id);
    }
}
