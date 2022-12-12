package tech.devinhouse.devgram;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.devinhouse.devgram.model.Perfil;
import tech.devinhouse.devgram.service.PerfilService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DeVgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeVgramApplication.class, args);
    }

    @Bean
    CommandLineRunner run(PerfilService perfilService) {
        return args -> {
            List<Perfil> lista = perfilService.consultar();
            if (lista.isEmpty()) {
                perfilService.criar(new Perfil("Vinicius", "Era uma vez", LocalDate.now().minusYears(24),"Programador", LocalDateTime.now(), LocalDateTime.now()));
                perfilService.criar(new Perfil("Ana Paula", "Era uma vez", LocalDate.now().minusYears(24),"Analista", LocalDateTime.now(), LocalDateTime.now()));

            }
        };
    }

}
