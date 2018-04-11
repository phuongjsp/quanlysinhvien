package hoang.phuong.server.controller;

import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.model.Thongtinthem;
import hoang.phuong.server.service.ThongtinsinhvienService;
import hoang.phuong.server.service.ThongtinthemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThongtinthemController {
    @Autowired
    private ThongtinthemService thongtinthemService;

    @Autowired
    private ThongtinsinhvienService thongtinsinhvienService;

    /*---Add new thongtinthem---*/
    @PostMapping("/thongtinthem")
    public void save(@RequestBody Thongtinthem thongtinthem) {
          thongtinthemService.save(thongtinthem);
    }

    /*---Get a thongtinthem by id---*/
    @GetMapping("/thongtinthem/{id}")
    public  Thongtinthem get(@PathVariable("id") int id) {
        return thongtinthemService.getByID(id);
    }
    /*---Get a thongtinthem by idsv---*/
    @GetMapping("/thongtinthem/maSv-{maSv}")
    public  List<Thongtinthem>  get(@PathVariable("maSv") String maSv) {
        Thongtinsinhvien thongtinsinhvien = thongtinsinhvienService.getByMaSV(maSv);
        return  thongtinthemService.listByIDSv(thongtinsinhvien.getId());
    }

    /*---get all thongtinthem---*/
    @GetMapping("/thongtinthem")
    public List<Thongtinthem>  list() {
        return thongtinthemService.list();
    }

    /*---Update a thongtinthem by id---*/
    @PutMapping("/thongtinthem/{id}")
    public boolean    update(@PathVariable("id") int id, @RequestBody Thongtinthem thongtinthem) {
        thongtinthem.setId(id);
        if (thongtinthemService.getByID(id) == null) {
            return true;
        }
        thongtinthemService.update(thongtinthem);
        return false;
    }

    /*---Delete a thongtinthem by id---*/
    @DeleteMapping("/thongtinthem/{id}")
    public boolean delete(@PathVariable("id") int id) {
        if (thongtinthemService.getByID(id) == null) {
            return true;
        }
        thongtinthemService.delete(id);
        return false;
    }
}
