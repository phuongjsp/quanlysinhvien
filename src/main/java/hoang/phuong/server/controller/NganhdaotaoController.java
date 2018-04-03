package hoang.phuong.server.controller;

import hoang.phuong.server.model.Nganhdaotao;
import hoang.phuong.server.service.NganhdaotaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NganhdaotaoController {
    @Autowired
    private NganhdaotaoService nganhdaotaoService;

    /*---Add new book---*/
    @PostMapping("/nganhdaotao")
    public ResponseEntity<?> save(@RequestBody Nganhdaotao nganhdaotao) {
        long id = nganhdaotaoService.save(nganhdaotao);
        return ResponseEntity.ok().body("New nganh dao tao has been saved with ID:" + id);
    }

    /*---Get a book by id---*/
    @GetMapping("/nganhdaotao/{id}")
    public ResponseEntity<Nganhdaotao> get(@PathVariable("id") int id) {
        Nganhdaotao nganhdaotao = nganhdaotaoService.getByID(id);
        return ResponseEntity.ok().body(nganhdaotao);
    }

    @GetMapping("/nganhdaotao/maNganh-{maNganh}")
    public ResponseEntity<Nganhdaotao> get(@PathVariable("maNganh") String maNganh) {
        Nganhdaotao nganhdaotao = nganhdaotaoService.getByMaNganhdaotao(maNganh);
        return ResponseEntity.ok().body(nganhdaotao);
    }

    /*---get all books---*/
    @GetMapping("/nganhdaotao")
    public ResponseEntity<List<Nganhdaotao>> list() {
        List<Nganhdaotao> nganhdaotaos = nganhdaotaoService.list();
        return ResponseEntity.ok().body(nganhdaotaos);
    }

    /*---Update a book by id---*/
    @PutMapping("/nganhdaotao/maNganh-{maNganh}")
    public ResponseEntity<?> update(@PathVariable("maNganh") String maNganh, @RequestBody Nganhdaotao nganhdaotao) {
        nganhdaotao.setMaNganh(maNganh);
        if (nganhdaotaoService.getByMaNganhdaotao(maNganh) == null) {
            return ResponseEntity.badRequest().body("can not find Nganh dao tao  by ma nganh");
        }
        nganhdaotaoService.update(nganhdaotao);
        return ResponseEntity.ok().body(" Nganh dao tao has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/nganhdaotao/maNganh-{maNganh}")
    public ResponseEntity<?> delete(@PathVariable("maNganh") String maNganh) {
        if (nganhdaotaoService.getByMaNganhdaotao(maNganh) == null) {
            return ResponseEntity.badRequest().body("can not find Nganh dao tao  by ma nganh");
        }
        nganhdaotaoService.delete(maNganh);
        return ResponseEntity.ok().body(" Nganh dao tao has been deleted successfully.");
    }
}
