package com.academia.dto;

import com.academia.model.Curso;
import com.academia.model.Matricula;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleMatriculaDTO {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleMatricula;

    @NotNull
    private MatriculaDTO matricula;

    @NotNull
    private CursoDTO curso;

    @NotNull
    private String aula;

}
