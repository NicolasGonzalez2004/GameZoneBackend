package com.example.gamezonebackend;

import com.example.gamezonebackend.model.Game;
import com.example.gamezonebackend.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GamezonebackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamezonebackendApplication.class, args); // es el punto de entrada, aquí arranca el servidor Spring Boot
    }

    @Bean
    CommandLineRunner init(GameRepository repo) {       // es un componente que use para que se ejecuta al iniciar el backend
        return args -> { // args es el parametro

            repo.save(new Game( // el repo save me guarda el juego en la BD
                    "FIFA 23",
                    "Simulador de fútbol con equipos actualizados.",
                    "Deportes",
                    "PS5",
                    59990.0,
                    "https://jdigitales.cl/cdn/shop/products/294054198_10159985921774288_6439892320597747946_n.jpg?v=1658506974&width=600"
            ));

            repo.save(new Game(
                    "GTA V",
                    "Mundo abierto en Los Santos con muchas misiones.",
                    "Acción",
                    "PC",
                    39990.0,

                    "https://i.blogs.es/6a071d/gtav/1366_2000.jpg"
            ));

            repo.save(new Game(
                    "The Last of Us Part II",
                    "Historia de supervivencia con mucho drama y exploración.",
                    "Aventura",
                    "PS4",
                    44990.0,
                    "https://static.wikia.nocookie.net/thelastofus/images/8/85/Portada_Parte_II_limpia.jpeg/revision/latest?cb=20211209014334&path-prefix=es"
            ));

            repo.save(new Game(
                    "Mario Kart 8 Deluxe",
                    "Carreras arcade con personajes clásicos de Nintendo.",
                    "Carreras",
                    "Nintendo Switch",
                    49990.0,
                    "https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_1.5/c_scale,w_1200/store/software/switch/70010000000153/de697f487a36d802dd9a5ff0341f717c8486221f2f1219b675af37aca63bc453"
            ));

            repo.save(new Game(
                    "God of War Ragnarok",
                    "Acción y aventura basada en mitología nórdica.",
                    "Acción",
                    "PS5",
                    64990.0,
                    "https://ngpmedia.com/wp-content/uploads/2022/11/GOD-OF-WAR-RAGNAROK-PORTADA.jpg"
            ));

            repo.save(new Game(
                    "Repo",
                    "Terror, entretencion para jugar con amigos online",
                    "Sandbox",
                    "PC",
                    5750.0,
                    "https://static0.gamerantimages.com/wordpress/wp-content/uploads/2025/05/repo-how-save-your-manual-progress.jpg?w=1600&h=900&fit=crop"
            ));
            repo.save(new Game(
                    "Halo",
                    "Accion , basada en historia espacial.",
                    "Shooter",
                    "PC",
                    31990.0,
                    "https://i.blogs.es/c47d88/halo-4/1366_2000.jpeg"
            ));
            repo.save(new Game(
                    "Spiderman 2",
                    "Accion , basada en la pelicula de Stan Lee.",
                    "Acción / Aventura",
                    "PC",
                    42000.0,
                    "https://image.api.playstation.com/vulcan/ap/rnd/202306/1219/1c7b75d8ed9271516546560d219ad0b22ee0a263b4537bd8.png"
            ));
            repo.save(new Game(
                    "Geometry Dash",
                    "Entretencion de ritmos",
                    "Plataformas / Ritmo",
                    "PC",
                    3000.0,
                    "https://imgs.crazygames.com/games/geometry-dash-online/cover_1x1-1732744370684.png?format=auto&quality=70&metadata=none"
            ));
            repo.save(new Game(
                    "Left 4 dead 2",
                    "Terror , entretencion con amigos ",
                    "Survival / Horror",
                    "PC",
                    5750.0,
                    "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/550/header.jpg?t=1745368562"
            ));
            repo.save(new Game(
                    "ONE PIECE World Seeker",
                    "Juego de acción y aventura en mundo abierto donde Luffy explora",
                    "Sandbox",
                    "PC",
                    40600.0,
                    "https://image.api.playstation.com/cdn/UP0700/CUSA11205_00/eTt6imVY7zAmpg8hMA3NaeCtoywhEEDG.png"
            ));

        };
    }
}
