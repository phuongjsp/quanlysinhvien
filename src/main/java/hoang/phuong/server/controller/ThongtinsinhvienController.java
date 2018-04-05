package hoang.phuong.server.controller;

import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.service.ThongtingiadinhService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import hoang.phuong.server.service.ThongtinthemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    /*---Add new book---*/
    @PostMapping("/thongtinsinhvien")
    public ResponseEntity<?> save(@RequestBody Thongtinsinhvien thongtinsinhvien) {
        long id = thongtinsinhvienService.save(thongtinsinhvien);
        return ResponseEntity.ok().body("New thong tin sinh vien has been saved with ID:" + id);
    }

    /*---Get a book by id---*/
    @GetMapping("/thongtinsinhvien/{id}")
    public ResponseEntity<Thongtinsinhvien> get(@PathVariable("id") int id) {
        Thongtinsinhvien thongtinsinhvien = thongtinsinhvienService.getById(id);
        return ResponseEntity.ok().body(thongtinsinhvien);
    }

    @GetMapping("/thongtinsinhvien/maSV-{maSV}")
    public ResponseEntity<Thongtinsinhvien> get(@PathVariable("maSV") String maSV) {
        Thongtinsinhvien thongtinsinhvien = thongtinsinhvienService.getByMaSV(maSV);
        return ResponseEntity.ok().body(thongtinsinhvien);
    }

    @GetMapping("/")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok().body("thong tin sinh vien :");
    }
    /*---get all books---*/
    @GetMapping("/thongtinsinhvien")
    public ResponseEntity<List<Thongtinsinhvien>> list() {

        List<Thongtinsinhvien> thongtinsinhviens = thongtinsinhvienService.list();
        thongtinsinhviens.forEach(thongtinsinhvien -> {
            thongtinsinhvien.setThongtingiadinhList(thongtingiadinhService.listByIDSv(thongtinsinhvien.getId()));
            thongtinsinhvien.setThongtinthemList(thongtinthemService.listByIDSv(thongtinsinhvien.getId()));
        });
        return ResponseEntity.ok().body(thongtinsinhviens);
    }

    @GetMapping("/thongtinsinhvien/{min}/{max}")
    public ResponseEntity<List<Thongtinsinhvien>> listLimit(@PathVariable("min") int min, @PathVariable("max") int max) {

        List<Thongtinsinhvien> thongtinsinhviens = thongtinsinhvienService.listLimit(min, max);
        return ResponseEntity.ok().body(thongtinsinhviens);
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
    @PostMapping("/thongtinsinhvien/fliter/{min}/{max}")
    public ResponseEntity<List<Thongtinsinhvien>> listFliter(@RequestBody List<Map<String, Object>> mapparameters,
                                                             @PathVariable("min") int min, @PathVariable("max") int max) {
        List<Thongtinsinhvien> thongtinsinhviens = thongtinsinhvienService.listOrderBy(mapparameters, min, max);
        return ResponseEntity.ok().body(thongtinsinhviens);
    }

    /*---Update a book by id---*/
    @PutMapping("/thongtinsinhvien/maSV-{maSV}")
    public ResponseEntity<?> update(@PathVariable("maSV") String maSV, @RequestBody Thongtinsinhvien thongtinsinhvien) {
        thongtinsinhvien.setMaSv(maSV);
        if (thongtinsinhvienService.getByMaSV(maSV) == null) {
            return ResponseEntity.badRequest().body("can not find Thong tin sinh vien  by ma nganh");
        }
        thongtinsinhvienService.update(thongtinsinhvien);
        return ResponseEntity.ok().body(" Nganh dao tao has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/thongtinsinhvien/maSV-{maSV}")
    public ResponseEntity<?> delete(@PathVariable("maSV") String maSV) {
        if (thongtinsinhvienService.getByMaSV(maSV) == null) {
            return ResponseEntity.badRequest().body("can not find Thong tin sinh vien  by ma nganh");
        }
        thongtinsinhvienService.delete(maSV);
        return ResponseEntity.ok().body(" Nganh dao tao has been deleted successfully.");
    }
}
