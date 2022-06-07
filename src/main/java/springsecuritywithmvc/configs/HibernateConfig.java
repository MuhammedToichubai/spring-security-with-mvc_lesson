package springsecuritywithmvc.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

    @Bean
    public EntityManager createBeanOfEntityManager() {
        return Persistence.createEntityManagerFactory("peaksoft")
                .createEntityManager();
    }
}
