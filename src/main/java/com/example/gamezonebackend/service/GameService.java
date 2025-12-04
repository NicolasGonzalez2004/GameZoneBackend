package com.example.gamezonebackend.service;

import com.example.gamezonebackend.model.Game;
import com.example.gamezonebackend.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service // marca la clase
public class GameService {

    private final GameRepository repo; // repositorio para acceder a la BD(H2)

    public GameService(GameRepository repo) {
        this.repo = repo; // inyección del repositorio(spring bot me entrega automa.. un objeto del repo)
    }

    // GET /games → obtener todos los juegos
    public List<Game> findAll() {
        return repo.findAll(); //  me devuelve lista completa desde la BD
    }

    // GET /games/{id} → obtener 1 juego por ID
    public Game findById(Long id) { // metodo para buscar un juego en especifico segun su id
        return repo.findById(id) //  busca el juego por ID
                .orElseThrow(() -> new ResponseStatusException( // si no lo encuentra el juego
                        HttpStatus.NOT_FOUND,                  // me lanza código 404
                        "Juego no encontrado"                  // mensaje de error
                ));
    }

    // POST /games → me permite crear un juego nuevo
    public Game create(Game game) {
        game.setId(null); // evita que el usuario mande un ID inventado y asegura que la BD cree el ID correcto
        return repo.save(game); // guarda el juego en la BD
    }

    // PUT /games/{id} → me permite actualizar
    public Game update(Long id, Game datos) { // modifica un juego que existe usando el id

        Game existente = findById(id); // Busca el juego a actualizar o lanza 404

        // actualiza cada campo con los nuevos valores enviados
        existente.setTitle(datos.getTitle());
        existente.setDescription(datos.getDescription());
        existente.setGenre(datos.getGenre());
        existente.setPlatform(datos.getPlatform());
        existente.setPrice(datos.getPrice());
        existente.setImageUrl(datos.getImageUrl());

        return repo.save(existente); // me guarda los cambios en la BD
    }

    // DELETE /games/{id} → eliminar un juego
    public void delete(Long id) {

        if (!repo.existsById(id)) { // verifica si el juego existe
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, // Si no existe, error 404
                    "Juego no encontrado"
            );
        }

        repo.deleteById(id); // elimina el juego por ID
    }
}
