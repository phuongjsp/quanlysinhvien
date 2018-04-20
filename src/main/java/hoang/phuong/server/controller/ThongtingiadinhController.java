package hoang.phuong.server.controller;

import hoang.phuong.server.model.Thongtingiadinh;
import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.service.ThongtingiadinhService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThongtingiadinhController {
    @Autowired
    private ThongtingiadinhService thongtingiadinhService;
    @Autowired
    private ThongtinsinhvienService thongtinsinhvienService;

    /*---Add new thongtingiadinh---*/
    @PostMapping("/thongtingiadinh")
    public void save(@RequestBody Thongtingiadinh thongtingiadinh) {
        thongtingiadinhService.save(thongtingiadinh);
    }

    /*---Get a thongtingiadinh by id---*/
    @GetMapping("/thongtingiadinh/{id}")
    public Thongtingiadinh  get(@PathVariable("id") int id) {
        return thongtingiadinhService.getByID(id);
    }
    /*---Get a thongtingiadinh by id-sv--*/
    @GetMapping("/thongtingiadinh/IDSV-{idsv}")
    public  List<Thongtingiadinh> getListByIDSv(@PathVariable("idsv") int idsv) {
        return thongtingiadinhService.listByIDSv(idsv);
    }

    /*---get all thongtingiadinh---*/
    @GetMapping("/thongtingiadinh")
    public  List<Thongtingiadinh>  list() {
        return thongtingiadinhService.list();
    }

    /*---Update a thongtingiadinh by id---*/
    @PutMapping("/thongtingiadinh/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Thongtingiadinh thongtingiadinh) {
        thongtingiadinh.setId(id);
        if (thongtingiadinhService.getByID(id) == null) {
            return false;
        }
        thongtingiadinhService.update(thongtingiadinh);
        return true;
    }

    /*---Delete a thongtingiadinh by id---*/
    @DeleteMapping("/thongtingiadinh/{id}")
    public boolean delete(@PathVariable("id") int id) {
        if (thongtingiadinhService.getByID(id) == null) {
            return false;
        }
        thongtingiadinhService.delete(id);
        return true;
    }
}
