package com.ttw.userservice.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,
basePackages = "com.ttw.userservice.repository.model")
public class RepositoryConfiguration {


}
