package tech.devinhouse.devgram.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devgram.dto.PerfilResponse;
import tech.devinhouse.devgram.model.Perfil;
import tech.devinhouse.devgram.service.PerfilService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/perfis")
@AllArgsConstructor
public class PerfilController {
    
    private PerfilService service;

    @GetMapping
    public ResponseEntity<List<PerfilResponse>> listar() {
        List<Perfil> perfis = service.consultar();
        List<PerfilResponse> resp = new ArrayList<>();
        for (Perfil perfil: perfis) {
            PerfilResponse r = mapper.map(perfil, PerfilResponse.class);
            resp.add(r);
        }
//        List<PerfilResponse> resp = perfis.stream()
//                .map(p -> mapper.map(p, PerfilResponse.class)).collect(Collectors.toList());
        return ResponseEntity.ok(resp);
    }

    @GetMapping("{nome}")
    public ResponseEntity<PerfilResponse> listar(@PathVariable("nome") String nome) {
        Perfil perfil = service.consultar(nome);
        PerfilResponse resp = mapper.map(perfil, PerfilResponse.class);
        return ResponseEntity.ok(resp);
    }
