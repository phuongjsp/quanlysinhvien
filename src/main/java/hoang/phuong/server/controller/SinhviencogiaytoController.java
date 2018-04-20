package hoang.phuong.server.controller;

import hoang.phuong.server.model.Sinhviencogiayto;
import hoang.phuong.server.service.SinhviencogiaytoService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SinhviencogiaytoController {

    @Autowired
    private SinhviencogiaytoService sinhviencogiaytoService;
    @Autowired
    private ThongtinsinhvienService thongtinsinhvienService;

    @PostMapping(path = "/sinhviencogiayto")
    public Sinhviencogiayto save(@RequestBody Sinhviencogiayto sinhviencogiayto) {
        return sinhviencogiaytoService.save(sinhviencogiayto);
    }

    @GetMapping("/sinhviencogiayto/{id}")
    public Sinhviencogiayto get(@PathVariable("id") int id) {
        return sinhviencogiaytoService.getbyId(id);
    }

    @GetMapping("/sinhviencogiayto")
    public List<Sinhviencogiayto> list() {
        return sinhviencogiaytoService.list();
    }

    @GetMapping("/sinhviencogiayto/maSv-{maSv}")
    public List<Sinhviencogiayto> listByMaSv(@PathVariable("maSv") String maSv) {
        return sinhviencogiaytoService.listByIdSv(thongtinsinhvienService.getByMaSV(maSv).getId());
    }

    @PutMapping("/sinhviencogiayto")
    public boolean update(@RequestBody Sinhviencogiayto sinhviencogiayto) {
        if (sinhviencogiaytoService.update(sinhviencogiayto)) {
            return true;
        }
        return false;
    }

    @DeleteMapping("/sinhviencogiayto/{id}")
    public boolean delete(@PathVariable("id") int id) {
        if (sinhviencogiaytoService.delete(id)) {
            return true;
        }
        return false;
    }
}
