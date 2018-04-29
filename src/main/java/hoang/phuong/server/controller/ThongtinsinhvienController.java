package hoang.phuong.server.controller;

import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.service.ThongtinsinhvienService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qlsv/thongtinsinhvien")
public class ThongtinsinhvienController {
    private ThongtinsinhvienService thongtinsinhvienService;

    @Inject
    public ThongtinsinhvienController(ThongtinsinhvienService thongtinsinhvienService) {
        this.thongtinsinhvienService = thongtinsinhvienService;
    }

    @PostMapping("")
    public Thongtinsinhvien save(@RequestBody @DateTimeFormat Thongtinsinhvien thongtinsinhvien) {
        return thongtinsinhvienService.save(thongtinsinhvien);
    }

    @GetMapping("/{id}")
    public Thongtinsinhvien get(@PathVariable("id") int id) {
        return thongtinsinhvienService.getById(id);
    }

    @GetMapping("/maSV-{maSV}")
    public  Thongtinsinhvien  get(@PathVariable("maSV") String maSV) {
        return thongtinsinhvienService.getByMaSV(maSV);
    }


    //get fliter?msv vd
/*
[
    {
        "property": "ten",
        "type": "eq",
        "value": "nhu"
    },
    {
        "property": "maSv",
        "order": "desc"
    }
]
 */
    @PostMapping("/fliter/{min}/{max}")
    public List<Thongtinsinhvien> listFliter(@RequestBody List<Map<String, Object>> mapparameters,
                                                             @PathVariable("min") int min, @PathVariable("max") int max) {
        return thongtinsinhvienService.listOrderBy(mapparameters, min, max);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Thongtinsinhvien thongtinsinhvien) {

        return thongtinsinhvienService.update(thongtinsinhvien);
    }

    /*---Delete a thongtinsinhvien by maSV---*/
    @DeleteMapping("/maSV-{maSV}")
    public boolean delete(@PathVariable("maSV") String maSV) {

        return thongtinsinhvienService.delete(maSV);

    }
}
