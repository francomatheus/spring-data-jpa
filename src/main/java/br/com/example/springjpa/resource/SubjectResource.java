package br.com.example.springjpa.resource;

import br.com.example.springjpa.domain.SubjectEntity;
import br.com.example.springjpa.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectResource {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<SubjectEntity>> getAllSubject(){
        List<SubjectEntity> allSubject = subjectService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(allSubject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectEntity> getOneSubject(@PathVariable Long id){
        Optional<SubjectEntity> subjectById = Optional.ofNullable(subjectService.getOneById(id));
        if (subjectById.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(subjectById.get());
    }

    @PostMapping
    public ResponseEntity<SubjectEntity> saveSubject(@RequestBody SubjectEntity subject) throws URISyntaxException {
        SubjectEntity subjectSave = subjectService.save(subject);
        return ResponseEntity.created(new URI("/subject".concat(subjectSave.getId().toString()))).body(subjectSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectEntity> updateSubject(@PathVariable Long id, @RequestBody SubjectEntity subject){
        SubjectEntity subjectUpdate = subjectService.update(id, subject);
        return ResponseEntity.status(HttpStatus.OK).body(subjectUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubject (@PathVariable Long id){
        subjectService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}





