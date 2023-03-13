package com.academia.controller;

import com.academia.dto.EstudianteDTO;
import com.academia.dto.MatriculaDTO;
import com.academia.dto.ResponseDTO;
import com.academia.model.Estudiante;
import com.academia.model.Matricula;
import com.academia.service.ICursoService;
import com.academia.service.IMatriculaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private IMatriculaService service;

    @Autowired
    @Qualifier("matriculaMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<ResponseDTO<MatriculaDTO>> readAll() throws Exception {

        List<MatriculaDTO> lista = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());

        ResponseDTO<MatriculaDTO> response = new ResponseDTO<>();
        response.setData(lista);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ResponseDTO<MatriculaDTO>> create(@Valid @RequestBody MatriculaDTO matricula) throws Exception {

        Matricula mat = this.convertToEntity(matricula);
        Matricula obj = service.save(mat);

        ResponseDTO<MatriculaDTO> response = new ResponseDTO<>();
        response.setData(List.of(this.convertToDto(obj)));
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Metodo que convierte una Matricula a MatriculaDto
     *
     * @param matricula
     * @return
     */
    private MatriculaDTO convertToDto(Matricula matricula){
        return mapper.map(matricula, MatriculaDTO.class);
    }

    /**
     * Metodo que convierte de un objeto MatriculaDTO a Matricula
     * @param matriculaDTO
     * @return
     */
    private Matricula convertToEntity(MatriculaDTO matriculaDTO){
        return mapper.map(matriculaDTO, Matricula.class);
    }

}
