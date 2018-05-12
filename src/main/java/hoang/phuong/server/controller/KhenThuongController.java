package hoang.phuong.server.controller;

import hoang.phuong.server.model.Khenthuong;
import hoang.phuong.server.service.KhenThuongService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/qlsv/khenthuong")
public class KhenThuongController {
    private final KhenThuongService khenThuongService;

    @Inject
    public KhenThuongController(KhenThuongService khenThuongService) {
        this.khenThuongService = khenThuongService;
    }

    @PostMapping(path = "")
    public Khenthuong save(@RequestBody Khenthuong khenthuong) {
        return khenThuongService.save(khenthuong);
    }

    @GetMapping("/id/{id}")
    public Khenthuong get(@PathVariable("id") int id) {
        return khenThuongService.getById(id);
    }


    @GetMapping("")
    public List<Khenthuong> list() {
        return khenThuongService.findAll();
    }

    @GetMapping("/idSv/{idSv}")
    public List<Khenthuong> listByIdSv(@PathVariable("idSv") int idSv) {
        return khenThuongService.findByIdSv(idSv);
    }

    @GetMapping("/year")
    public List<Khenthuong> listByYear(@RequestParam(value = "stdate") String stdate,
                                       @RequestParam(value = "eddate") String eddate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return khenThuongService.findByYear(sdf.parse(stdate), sdf.parse(eddate));
        } catch (ParseException e) {
            return null;
        }
    }

    @PutMapping("")
    public boolean update(@RequestBody Khenthuong khenthuong) {
        return khenThuongService.update(khenthuong) != null;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return khenThuongService.delete(id);
    }

}
