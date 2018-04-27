package hoang.phuong.server.controller;

import hoang.phuong.server.model.Nganhdaotao;
import hoang.phuong.server.service.NganhdaotaoService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
public class NganhdaotaoController {
    private NganhdaotaoService nganhdaotaoService;

    @Inject
    public NganhdaotaoController(NganhdaotaoService nganhdaotaoService) {
        this.nganhdaotaoService = nganhdaotaoService;
    }

    /*---Add new nganhdaotao---*/
    @PostMapping("/nganhdaotao")
    public Nganhdaotao save(@RequestBody Nganhdaotao nganhdaotao) {
        return nganhdaotaoService.save(nganhdaotao);
    }

    /*---Get a nganhdaotao by id---*/
    @GetMapping("/nganhdaotao/{id}")
    public  Nganhdaotao get(@PathVariable("id") int id) {
        return nganhdaotaoService.getByID(id);
    }
    /*---Get a nganhdaotao by maNganh---*/
    @GetMapping("/nganhdaotao/maNganh-{maNganh}")
    public Nganhdaotao get(@PathVariable("maNganh") String maNganh) {
        return nganhdaotaoService.getByMaNganhdaotao(maNganh);
    }

    /*---get all nganhdaotao---*/
    @GetMapping("/nganhdaotao")
    public  List<Nganhdaotao> list() {
        return  nganhdaotaoService.list();
    }

    /*---Update a nganhdaotao by id---*/
    @PutMapping("/nganhdaotao/id-{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody Nganhdaotao nganhdaotao) {
        if (nganhdaotaoService.getByID(id) == null) {
            return false;
        }
        return nganhdaotaoService.update(nganhdaotao);

    }

    /*---Delete a nganhdaotao by maNganh---*/
    @DeleteMapping("/nganhdaotao/maNganh-{maNganh}")
    public boolean delete(@PathVariable("maNganh") String maNganh) {
        if (nganhdaotaoService.getByMaNganhdaotao(maNganh) == null) {
            return false;
        }
        return nganhdaotaoService.delete(maNganh);

    }
}
