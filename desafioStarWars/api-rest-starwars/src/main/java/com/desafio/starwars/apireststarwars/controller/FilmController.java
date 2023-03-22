package com.desafio.starwars.apireststarwars.controller;

import com.desafio.starwars.apireststarwars.model.Film;
import com.desafio.starwars.apireststarwars.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {
    private static final String SWAPI_BASE_URL = "https://swapi.dev/api";
    private static final String LUKE_SKYWALKER_ENDPOINT = "/people/1";
    private static final String FILMS_ENDPOINT = "/films/";

    @GetMapping("/starwars/lukeskywalker/films")
    public List<Film> getLukeSkywalkerFilms() {
        RestTemplate restTemplate = new RestTemplate();

        // fazer a requisição para obter o objeto Luke Skywalker
        Person luke = restTemplate.getForObject(SWAPI_BASE_URL + LUKE_SKYWALKER_ENDPOINT, Person.class);

        // obter os URLs dos filmes em que Luke Skywalker aparece
        List<String> filmUrls = luke.getFilms();

        // fazer requisições para obter os objetos dos filmes
        List<Film> films = new ArrayList<>();
        for (String url: filmUrls) {
            Film film = restTemplate.getForObject(url, Film.class);
            films.add(film);
        }

        return films;
    }
}
