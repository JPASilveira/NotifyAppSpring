package br.com.silveira.notifyapp.config;

import br.com.silveira.notifyapp.domain.factory.RepositoryFactory;
import br.com.silveira.notifyapp.infrastructure.h2.H2NotifyLogDAO;
import br.com.silveira.notifyapp.infrastructure.h2.H2NotifyLogFactory;
import br.com.silveira.notifyapp.infrastructure.sqlite.SQLiteNotifyLogDAO;
import br.com.silveira.notifyapp.infrastructure.sqlite.SQLiteNotifyLogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryFactoryConfig {

    @Value("${notify.persistence:h2}")
    private String persistence;

    @Bean
    public RepositoryFactory repositoryFactory(
            H2NotifyLogDAO h2DAO,
            SQLiteNotifyLogDAO sqliteDAO
    ) {
        return switch (persistence.toLowerCase()) {
            case "sqlite" -> new SQLiteNotifyLogFactory(sqliteDAO);
            case "h2" -> new H2NotifyLogFactory(h2DAO);
            default -> throw new IllegalArgumentException("Unsupported persistence: " + persistence);
        };
    }
}
