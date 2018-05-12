package hoang.phuong.server.controller;

import hoang.phuong.server.model.Nganhdaotao;
import hoang.phuong.server.service.NganhdaotaoService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/qlsv/nganhdaotao")
public class NganhdaotaoController {
    private NganhdaotaoService nganhdaotaoService;

    @Inject
    public NganhdaotaoController(NganhdaotaoService nganhdaotaoService) {
        this.nganhdaotaoService = nganhdaotaoService;
    }

    @PostMapping("")
    public Nganhdaotao save(@RequestBody Nganhdaotao nganhdaotao) {
        return nganhdaotaoService.save(nganhdaotao);
    }

    @GetMapping("/{id}")
    public Nganhdaotao get(@PathVariable("id") int id) {
        return nganhdaotaoService.getByID(id);
    }

    @GetMapping("/maNganh-{maNganh}")
    public Nganhdaotao get(@PathVariable("maNganh") String maNganh) {
        return nganhdaotaoService.getByMaNganhdaotao(maNganh);
    }

    @GetMapping("")
    public List<Nganhdaotao> list() {
        return nganhdaotaoService.list();
    }

    @PutMapping("")
    public boolean update(@RequestBody Nganhdaotao nganhdaotao) {
        return nganhdaotaoService.update(nganhdaotao);

    }

    @DeleteMapping("/maNganh-{maNganh}")
    public boolean delete(@PathVariable("maNganh") String maNganh) {
        return nganhdaotaoService.delete(maNganh);

    }
}
