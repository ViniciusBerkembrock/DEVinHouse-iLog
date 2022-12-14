package tech.devinhouse.exerciciosemanal_lojautil.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.exerciciosemanal_lojautil.model.Produto;
import tech.devinhouse.exerciciosemanal_lojautil.model.Venda;
import tech.devinhouse.exerciciosemanal_lojautil.service.VendaService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "venda")
public class VendaController {

    private VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @GetMapping(path = "{id}")
    public Venda getId(@PathVariable("id") Integer id) {
        return vendaService.buscarPorId(id);
    }

    @GetMapping(path = "porDatas")
    public List<Venda>  getPorDatas(
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'") Date dataInicial,
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'") Date dataFinal){
        return vendaService.buscarPorDatas(dataInicial, dataFinal);
    }

    @GetMapping(path = "porStatus")
    public List<Venda> getPorStatus(String status) {
        return vendaService.buscarPorStatus(status);
    }

    @PostMapping
    public Venda post(@RequestBody Venda venda) throws Exception {
        return vendaService.salvar(venda);
    }

    @DeleteMapping(path = "{id}")
    public Venda delete(@PathVariable("id") Integer id) {
        return vendaService.cancelarPorId(id);
    }


}
