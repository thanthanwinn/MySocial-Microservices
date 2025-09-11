package com.ttw.relationservice.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.function.Function;

public interface BaseRepository<T,ID> extends JpaRepository<T,ID> {
    <R> List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunction);

    <R> Page<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunction, Function<CriteriaBuilder, CriteriaQuery<Long>> countFunction, int page, int size);
}
