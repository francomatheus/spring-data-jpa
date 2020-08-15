package br.com.example.springjpa.service;

import br.com.example.springjpa.domain.StudentEntity;

import java.util.List;

public interface StudentService {

    List<StudentEntity> getAll();

    StudentEntity getOneById(Long id);

    StudentEntity save(StudentEntity student);

    StudentEntity update(Long id, StudentEntity student);

    void delete(Long id);

}



