package Spring;

import Database.Model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public Album album() {
        return new Album();
    }

    @Bean
    public AlbumArt albumArt() {
        return new AlbumArt();
    }

    @Bean
    public AlbumType albumType() {
        return new AlbumType();
    }

    @Bean
    public Artist artist() {
        return new Artist();
    }

    @Bean
    public ContactInfo contactInfo() {
        return new ContactInfo();
    }

    @Bean
    public Genre genre() {
        return new Genre();
    }

    @Bean
    public Label label() {
        return new Label();
    }

    @Bean
    public Release release() {
        return new Release();
    }

    @Bean
    public Song song() {
        return new Song();
    }
}

