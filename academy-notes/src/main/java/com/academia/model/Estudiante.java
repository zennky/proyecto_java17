package com.academia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;

    @Column(nullable = false, length = 25, name = "nombre")
    private String nombres;

    @Column(nullable = false, length = 30, name = "apellido1")
    private String apellido1;

    @Column(nullable = true, length = 30, name = "apellido2")
    private String apellido2;

    @Column(nullable = false, length = 15, name = "dni")
    private String dni;

    @Column(nullable = false)
    private Integer edad;

}
