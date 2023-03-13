package com.academia.controller;

import com.academia.dto.CursoDTO;
import com.academia.dto.CursoDTO;
import com.academia.dto.ResponseDTO;
import com.academia.model.Curso;
import com.academia.model.Estudiante;
import com.academia.service.ICursoService;
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
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private ICursoService service;

    @Autowired
    @Qualifier("cursoMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<ResponseDTO<CursoDTO>> readAll() throws Exception {

        List<CursoDTO> lista = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());

        ResponseDTO<CursoDTO> response = new ResponseDTO<>();
        response.setData(lista);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ResponseDTO<CursoDTO>> create(@Valid @RequestBody CursoDTO curso) throws Exception {

        Curso obj = service.save(this.convertToEntity(curso));

        ResponseDTO<CursoDTO> response = new ResponseDTO<>();
        response.setData(List.of(this.convertToDto(obj)));
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<CursoDTO>> update(@Valid @PathVariable("id") Integer id,  @RequestBody CursoDTO cursoDTO) throws Exception {

        cursoDTO.setIdCurso(id);
        Curso obj = service.update(this.convertToEntity(cursoDTO), id);

        ResponseDTO<CursoDTO> response = new ResponseDTO<>();
        response.setData(List.of(this.convertToDto(obj)));
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<CursoDTO>> readByIdResponse(@PathVariable("id") Integer id) throws Exception {
        Curso curso = service.readById(id);
        CursoDTO cursoDTO = this.convertToDto(curso);

        ResponseDTO<CursoDTO> response = new ResponseDTO<>();
        response.setData(List.of(cursoDTO));
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{

        service.delete(id);

        ResponseDTO<CursoDTO> response = new ResponseDTO<>();
        //response.setData(List.of(this.convertToDto(obj)));
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("OK");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Metodo que convierte un Curso a CursoDto
     *
     * @param curso
     * @return
     */
    private CursoDTO convertToDto(Curso curso){
        return mapper.map(curso, CursoDTO.class);
    }

    /**
     * Metodo que convierte de un objeto CursoDTO a Curso
     * @param cursoDTO
     * @return
     */
    private Curso convertToEntity(CursoDTO cursoDTO){
        return mapper.map(cursoDTO, Curso.class);
    }

}
