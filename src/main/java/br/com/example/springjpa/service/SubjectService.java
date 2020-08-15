package br.com.example.springjpa.service;

import br.com.example.springjpa.domain.SubjectEntity;

import java.util.List;

public interface SubjectService {

    List<SubjectEntity> getAll();

    SubjectEntity getOneById(Long id);

    SubjectEntity save(SubjectEntity subject);

    SubjectEntity update(Long id, SubjectEntity subject);

    void delete(Long id);
}





