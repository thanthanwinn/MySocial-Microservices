package com.ttw.notificationservice.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class RepositoryConfiguration {
}
