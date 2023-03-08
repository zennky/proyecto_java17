package com.academia.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    private Integer idCurso;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nombre;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 20)
    private String sigla;


    @NotNull
    private Boolean estado;
}
