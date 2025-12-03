package com.example.gamezonebackend.service;

import com.example.gamezonebackend.model.Game;
import com.example.gamezonebackend.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GameService {

    private final GameRepository repo;

    public GameService(GameRepository repo) {
        this.repo = repo;
    }

    // GET /games
    public List<Game> findAll() {
        return repo.findAll();
    }

    // GET /games/{id}
    public Game findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Juego no encontrado"
                ));
    }

    // POST /games
    public Game create(Game game) {
        game.setId(null); // evita problemas si viene un ID
        return repo.save(game);
    }

    // PUT /games/{id}
    public Game update(Long id, Game datos) {
        Game existente = findById(id);

        existente.setTitle(datos.getTitle());
        existente.setDescription(datos.getDescription());
        existente.setGenre(datos.getGenre());
        existente.setPlatform(datos.getPlatform());
        existente.setPrice(datos.getPrice());
        existente.setImageUrl(datos.getImageUrl());

        return repo.save(existente);
    }

    // DELETE /games/{id}
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Juego no encontrado"
            );
        }
        repo.deleteById(id);
    }
}
