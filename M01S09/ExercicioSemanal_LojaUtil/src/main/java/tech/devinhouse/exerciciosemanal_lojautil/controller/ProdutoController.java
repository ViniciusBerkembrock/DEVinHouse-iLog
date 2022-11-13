package tech.devinhouse.exerciciosemanal_lojautil.controller;

import org.springframework.web.bind.annotation.*;
import tech.devinhouse.exerciciosemanal_lojautil.model.Produto;
import tech.devinhouse.exerciciosemanal_lojautil.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping(path = "produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> get() {
        return produtoService.buscar();
    }

    @PostMapping
    public Produto post(@RequestBody Produto produto) throws Exception {
        return produtoService.salvar(produto);
    }

    @PutMapping Produto put(@RequestBody Produto produto) throws Exception {
        return produtoService.salvar(produto);
    }

    @DeleteMapping
    public boolean delete(Integer id) {
        return produtoService.apagar(id);
    }
}
