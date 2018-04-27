package hoang.phuong.server.controller;

import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.service.ThongtinsinhvienService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RestController
public class ThongtinsinhvienController {
    private ThongtinsinhvienService thongtinsinhvienService;

    @Inject
    public ThongtinsinhvienController(ThongtinsinhvienService thongtinsinhvienService) {
        this.thongtinsinhvienService = thongtinsinhvienService;
    }

    /*---Add new thongtinsinhvien---*/
    @PostMapping("/thongtinsinhvien")
    public Thongtinsinhvien save(@RequestBody @DateTimeFormat Thongtinsinhvien thongtinsinhvien) {
        return thongtinsinhvienService.save(thongtinsinhvien);
//        return ResponseEntity.ok().body("New thong tin sinh vien has been saved with ID:" + id);
    }

    /*---Get a thongtinsinhvien by id---*/
    @GetMapping("/thongtinsinhvien/{id}")
    public Thongtinsinhvien get(@PathVariable("id") int id) {
        return thongtinsinhvienService.getById(id);
    }
    /*---Get a thongtinsinhvien by maSV---*/
    @GetMapping("/thongtinsinhvien/maSV-{maSV}")
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
