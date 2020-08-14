package br.com.example.springjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "registration", nullable = false, unique = true)
    private String registration;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "course")
    private String course;

}



