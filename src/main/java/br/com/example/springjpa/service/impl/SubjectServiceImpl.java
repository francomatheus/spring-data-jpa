package br.com.example.springjpa.service.impl;

import br.com.example.springjpa.domain.SubjectEntity;
import br.com.example.springjpa.repository.SubjectRepository;
import br.com.example.springjpa.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<SubjectEntity> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public SubjectEntity getOneById(Long id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public SubjectEntity save(SubjectEntity subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public SubjectEntity update(Long id, SubjectEntity subject) {
        Optional<SubjectEntity> subjectUpdate = Optional.ofNullable(subjectRepository.getOne(id));
        if (subjectUpdate.isEmpty()){
            throw new EmptyResultDataAccessException("Id doesn't exist!",Integer.parseInt(subjectUpdate.get().getId().toString()));
        }

        BeanUtils.copyProperties(subject,subjectUpdate.get(),"id");
        SubjectEntity subjectSaved = subjectRepository.save(subjectUpdate.get());

        return subjectSaved;
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
}










