package com.academia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {

    private Integer idEstudiante;

    private String nombres;

    private String apellido1;

    private String apellido2;

    private String dni;

    private Integer edad;

}
