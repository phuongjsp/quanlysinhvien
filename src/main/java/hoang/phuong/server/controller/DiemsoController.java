package hoang.phuong.server.controller;

import hoang.phuong.server.model.Diemso;
import hoang.phuong.server.service.DiemsoService;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qlsv/diemso")
public class DiemsoController {
    private DiemsoService diemsoService;

    @Inject
    public DiemsoController(DiemsoService diemsoService) {
        this.diemsoService = diemsoService;
    }

    @PostMapping(path = "")
    public Diemso save(@RequestBody Diemso diemso) {
        return diemsoService.save(diemso);
    }

    @GetMapping("/{id}")
    public Diemso get(@PathVariable("id") int id) {
        return diemsoService.getbyId(id);
    }


    @GetMapping("")
    public List<Diemso> list() {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        return diemsoService.listBYMultivalue(map);
    }

    @RequestMapping(path = "list", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    public List<Diemso> listByMap(@RequestBody Map<String, List<Object>> maprequest) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        maprequest.forEach((s, integers) -> map.put(s, integers));
        return diemsoService.listBYMultivalue(map);
    }

    @PutMapping("")
    public boolean update(@RequestBody Diemso diemso) {
        return diemsoService.update(diemso) != null;

    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return diemsoService.delete(id);

    }
}
