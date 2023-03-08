package com.academia.dto;

import com.academia.model.DetalleMatricula;
import com.academia.model.Estudiante;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

    private Integer idMatricula;

    @NotNull
    private LocalDateTime fechaMatricula;

    @NotNull
    private Estudiante estudiante;

    @NotNull
    private Boolean estado;

    @NotNull
    private List<DetalleMatricula> detalleMatriculas;

}
