package com.academia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {

    private Integer idMatricula;

    @NotNull
    private LocalDateTime fechaMatricula;

    @NotNull
    private EstudianteDTO estudiante;

    @NotNull
    private Boolean estado;

    @NotNull
    @JsonManagedReference
    private List<DetalleMatriculaDTO> detalles;

}
