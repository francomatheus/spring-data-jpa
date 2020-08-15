package br.com.example.springjpa.service.impl;

import br.com.example.springjpa.domain.StudentEntity;
import br.com.example.springjpa.repository.StudentRepository;
import br.com.example.springjpa.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getOneById(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public StudentEntity save(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentEntity update(Long id, StudentEntity student) {
        Optional<StudentEntity> studentUpdate = Optional.ofNullable(studentRepository.getOne(id));
        if (studentUpdate.isEmpty()){
            throw new EmptyResultDataAccessException("Id doesn't exist!",Integer.parseInt(studentUpdate.get().getId().toString()));
        }

        BeanUtils.copyProperties(student,studentUpdate.get(),"id");
        StudentEntity studentSaved = studentRepository.save(studentUpdate.get());
        return studentSaved;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}




