package com.academia.controller;

import com.academia.dto.EstudianteDTO;
import com.academia.dto.ResponseDTO;
import com.academia.model.Estudiante;
import com.academia.service.IEstudianteService;
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
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteService service;

    @Autowired
    @Qualifier("estudianteMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<ResponseDTO<EstudianteDTO>> readAll() throws Exception {

        List<EstudianteDTO> lista = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());

        ResponseDTO<EstudianteDTO> response = new ResponseDTO<>();
        response.setData(lista);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ResponseDTO<EstudianteDTO>> create(@Valid @RequestBody EstudianteDTO estudiante) throws Exception {

        Estudiante obj = service.save(this.convertToEntity(estudiante));

        ResponseDTO<EstudianteDTO> response = new ResponseDTO<>();
        response.setData(List.of(this.convertToDto(obj)));
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<EstudianteDTO>> update(@Valid @PathVariable("id") Integer id,  @RequestBody EstudianteDTO estudianteDTO) throws Exception {

        estudianteDTO.setIdEstudiante(id);
        Estudiante obj = service.update(this.convertToEntity(estudianteDTO), id);

        ResponseDTO<EstudianteDTO> response = new ResponseDTO<>();
        response.setData(List.of(this.convertToDto(obj)));
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<EstudianteDTO>> readByIdResponse(@PathVariable("id") Integer id) throws Exception {
        Estudiante estudiante = service.readById(id);
        EstudianteDTO estudianteDTO = this.convertToDto(estudiante);

        ResponseDTO<EstudianteDTO> response = new ResponseDTO<>();
        response.setData(List.of(estudianteDTO));
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{

        service.delete(id);

        ResponseDTO<EstudianteDTO> response = new ResponseDTO<>();
        //response.setData(List.of(this.convertToDto(obj)));
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Metodo que convierte un Product a CategoriaDto
     *
     * @param estudiante
     * @return
     */
    private EstudianteDTO convertToDto(Estudiante estudiante){
        return mapper.map(estudiante, EstudianteDTO.class);
    }

    /**
     * Metodo que convierte de un objeto ProductDTO a Product
     * @param productDTO
     * @return
     */
    private Estudiante convertToEntity(EstudianteDTO estudianteDTO){
        return mapper.map(estudianteDTO, Estudiante.class);
    }

}
