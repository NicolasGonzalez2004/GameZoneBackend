package com.example.gamezonebackend.controller;

import com.example.gamezonebackend.model.Game;
import com.example.gamezonebackend.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/games")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    // GET /games  → lista todos
    @GetMapping
    public List<Game> all() {
        return service.findAll();
    }

    // GET /games/{id}  → uno por ID
    @GetMapping("/{id}")
    public Game one(@PathVariable Long id) {
        return service.findById(id);
    }

    // POST /games  → crear juego
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game create(@RequestBody Game game) {
        return service.create(game);
    }

    // PUT /games/{id}  → actualizar juego
    @PutMapping("/{id}")
    public Game update(@PathVariable Long id, @RequestBody Game game) {
        return service.update(id, game);
    }

    // DELETE /games/{id}  → eliminar juego
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
