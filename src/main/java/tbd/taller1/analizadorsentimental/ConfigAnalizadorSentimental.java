package tbd.taller1.analizadorsentimental;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAnalizadorSentimental {
    @Bean
    public Classifier classifier() {
        return new Classifier();
    }
}
