package com.academia.dto;

import com.academia.model.Curso;
import com.academia.model.Matricula;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleMatriculaDTO {

    @JsonBackReference
    private MatriculaDTO matricula;

    @NotNull
    private CursoDTO curso;

    @NotNull
    private String aula;

}
