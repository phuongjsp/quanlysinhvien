package hoang.phuong.server.controller;

import hoang.phuong.server.model.Svcovb;
import hoang.phuong.server.service.SvCoVbService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import hoang.phuong.server.service.VanBangService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/svcovb")
public class SvCoVbController {
    private SvCoVbService svCoVbService;
    private ThongtinsinhvienService thongtinsinhvienService;
    private VanBangService vanBangService;

    @Inject
    public SvCoVbController(SvCoVbService svCoVbService, ThongtinsinhvienService thongtinsinhvienService, VanBangService vanBangService) {
        this.svCoVbService = svCoVbService;
        this.thongtinsinhvienService = thongtinsinhvienService;
        this.vanBangService = vanBangService;
    }

    @PostMapping("")
    public Svcovb save(@RequestBody Svcovb svcovb) {
        return svCoVbService.save(svcovb);
    }

    @GetMapping("/{id}")
    public Svcovb get(@PathVariable("id") int id) {
        return svCoVbService.getById(id);
    }

    @GetMapping("")
    public List<Svcovb> list() {
        return svCoVbService.list();
    }

    @GetMapping("/maSV-{MaSv}")
    public List<Svcovb> istByMaSV(@PathVariable("MaSv") String MaSv) {
        return svCoVbService.listByIdSv(thongtinsinhvienService.getByMaSV(MaSv).getId());
    }

    @GetMapping("/maVB-{maVB}")
    public List<Svcovb> listByidVB(@PathVariable("maVB") String maVB) {
        return svCoVbService.listByLoaiVB(vanBangService.getByMaVB(maVB).getId());
    }

    @GetMapping("/only/maSV-{MaSv}-maVB-{maVB}")
    public List<Svcovb> listbyIdSvAndLoaiVb(
            @PathVariable("MaSv") String MaSv,
            @PathVariable("maVB") String maVB) {
        return svCoVbService.listbyIdSvAndLoaiVb(thongtinsinhvienService.getByMaSV(MaSv).getId(),
                vanBangService.getByMaVB(maVB).getId());
    }

    @PutMapping("")
    public boolean update(@RequestBody Svcovb svcovb) {
        return svCoVbService.update(svcovb);

    }

    @DeleteMapping("/{id}")
    public boolean dalete(@PathVariable("id") int id) {
        return svCoVbService.delete(id);

    }
}
