package com.academia.controller;

import com.academia.dto.EstudianteDTO;
import com.academia.model.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> readAll() throws Exception {

        EstudianteDTO estudiante1 = new EstudianteDTO(1, "Erick", "Ibañez", "Velasco", "12345678", 20);
        EstudianteDTO estudiante2 = new EstudianteDTO(2, "Miriam", "Lopez", "Surco", "123456", 15);
        EstudianteDTO estudiante3 = new EstudianteDTO(3, "Michelle", "Ibañez", "Lopez", "12344", 10);

        List<EstudianteDTO> lista = new ArrayList<>();

        lista.add(estudiante1);
        lista.add(estudiante2);
        lista.add(estudiante3);

        return new ResponseEntity<>(lista, HttpStatus.OK);

    }

}
