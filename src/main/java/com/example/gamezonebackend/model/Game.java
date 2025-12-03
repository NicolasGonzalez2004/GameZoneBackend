package com.example.gamezonebackend.model;

import jakarta.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String genre;
    private String platform;
    private Double price;
    private String imageUrl;

    public Game() {
    }

    public Game(String title, String description, String genre,
                String platform, Double price, String imageUrl) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.platform = platform;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // ------- GETTERS -------
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getGenre() { return genre; }
    public String getPlatform() { return platform; }
    public Double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }

    // ------- SETTERS -------
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPlatform(String platform) { this.platform = platform; }
    public void setPrice(Double price) { this.price = price; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
