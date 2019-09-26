package es.ibermutua.services.arqexampleservice.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("es.ibermutua.services.arqexampleservice")
@EntityScan(basePackages = {"es.ibermutua.services.arqexampleservice.data.domain"})
@EnableJpaRepositories(basePackages = {"es.ibermutua.services.arqexampleservice.repositories"})
@EnableAutoConfiguration
@EnableTransactionManagement
public class JpaConfig {
}
