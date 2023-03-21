package com.desafio.starwars.apireststarwars.controller;

import com.desafio.starwars.apireststarwars.model.InfoDoFilme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @GetMapping("/listagem")
    public String listagemDeFilmes() {
        //InfoDoFilme infoDoFilme = new InfoDoFilme("dsda",)
        return "";//new ResponseEntity<>("Listagem de Filmes da API", HttpStatus.OK);
    }


}
