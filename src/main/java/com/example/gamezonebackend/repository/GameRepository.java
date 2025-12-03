package com.example.gamezonebackend.repository;

import com.example.gamezonebackend.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {}
