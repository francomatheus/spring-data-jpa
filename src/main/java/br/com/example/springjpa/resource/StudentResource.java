package br.com.example.springjpa.resource;

import br.com.example.springjpa.domain.StudentEntity;
import br.com.example.springjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentResource {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudent(){
        List<StudentEntity> allStudent = studentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(allStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getOneStudent(@PathVariable Long id){
        Optional<StudentEntity> studentById = Optional.ofNullable(studentService.getOneById(id));
        if (studentById.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentById.get());
    }

    @PostMapping
    public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentEntity student) throws URISyntaxException {
        StudentEntity studentSave = studentService.save(student);
        return ResponseEntity.created(new URI("/student".concat(studentSave.getId().toString()))).body(studentSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @RequestBody StudentEntity student){
        StudentEntity studentUpdate = studentService.update(id, student);
        return ResponseEntity.status(HttpStatus.OK).body(studentUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent (@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}



