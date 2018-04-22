package hoang.phuong.server.controller;

import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.service.SvCoVbService;
import hoang.phuong.server.service.ThongtingiadinhService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import hoang.phuong.server.service.ThongtinthemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ThongtinsinhvienController {
    @Autowired
    private ThongtinsinhvienService thongtinsinhvienService;

    @Autowired
    private ThongtinthemService thongtinthemService;
    @Autowired
    private ThongtingiadinhService thongtingiadinhService;
@Autowired
private SvCoVbService svCoVbService;
    /*---Add new thongtinsinhvien---*/
    @PostMapping("/thongtinsinhvien")
    public Thongtinsinhvien save(@RequestBody @DateTimeFormat Thongtinsinhvien thongtinsinhvien) {
        return thongtinsinhvienService.save(thongtinsinhvien);
//        return ResponseEntity.ok().body("New thong tin sinh vien has been saved with ID:" + id);
    }

    /*---Get a thongtinsinhvien by id---*/
    @GetMapping("/thongtinsinhvien/{id}")
    public Thongtinsinhvien get(@PathVariable("id") int id) {
        Thongtinsinhvien thongtinsinhvien = thongtinsinhvienService.getById(id);
        return thongtinsinhvien;
    }
    /*---Get a thongtinsinhvien by maSV---*/
    @GetMapping("/thongtinsinhvien/maSV-{maSV}")
    public  Thongtinsinhvien  get(@PathVariable("maSV") String maSV) {
        return thongtinsinhvienService.getByMaSV(maSV);
    }

    /*---get all thongtinsinhvien---*/
    @GetMapping("/thongtinsinhvien")
    public  List<Thongtinsinhvien> list() {
        return  thongtinsinhvienService.list();
    }
    /*---get all thongtinsinhvien limit---*/
    @GetMapping("/thongtinsinhvien/{min}/{max}")
    public  List<Thongtinsinhvien> listLimit(@PathVariable("min") int min, @PathVariable("max") int max) {
        return thongtinsinhvienService.listLimit(min, max);
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
    /*---get all thongtinsinhvien limit and fliter---*/
    @PostMapping("/thongtinsinhvien/fliter/{min}/{max}")
    public List<Thongtinsinhvien> listFliter(@RequestBody List<Map<String, Object>> mapparameters,
                                                             @PathVariable("min") int min, @PathVariable("max") int max) {
        return thongtinsinhvienService.listOrderBy(mapparameters, min, max);
    }

    /*---Update a thongtinsinhvien by maSV---*/
    @PutMapping("/thongtinsinhvien/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Thongtinsinhvien thongtinsinhvien) {
        if (thongtinsinhvienService.getById(id) == null) {
            return false;
        }
        thongtinsinhvienService.update(thongtinsinhvien);
        return true;
    }

    /*---Delete a thongtinsinhvien by maSV---*/
    @DeleteMapping("/thongtinsinhvien/maSV-{maSV}")
    public boolean delete(@PathVariable("maSV") String maSV) {
        if (thongtinsinhvienService.getByMaSV(maSV) == null) {
            return false;
        }
        thongtinsinhvienService.delete(maSV);
        return true;
    }
}
