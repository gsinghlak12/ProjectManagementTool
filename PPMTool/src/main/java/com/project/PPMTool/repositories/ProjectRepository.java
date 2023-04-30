package com.project.PPMTool.repositories;

import com.project.PPMTool.model.Project;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Override
    void flush();

    @Override
    <S extends Project> S saveAndFlush(S entity);

    @Override
    <S extends Project> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Project> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<Project> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Project getOne(Long aLong);

    @Override
    Project getById(Long aLong);

    @Override
    Project getReferenceById(Long aLong);

    @Override
    <S extends Project> List<S> findAll(Example<S> example);

    @Override
    <S extends Project> List<S> findAll(Example<S> example, Sort sort);

    @Override
    List<Project> findAllById(Iterable<Long> longs);
}
