package br.com.example.springjpa.repository;

import br.com.example.springjpa.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    List<StudentEntity> findAllBySubjectsCode(String code);


}



