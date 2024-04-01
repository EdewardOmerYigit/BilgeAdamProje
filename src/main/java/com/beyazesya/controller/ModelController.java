package com.beyazesya.controller;

import com.beyazesya.dto.model.ModelDTO;
import com.beyazesya.dto.model.ModelSaveDTO;
import com.beyazesya.dto.model.ModelUpdateDTO;
import com.beyazesya.entities.Model;
import com.beyazesya.services.ModelServiceImpl;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/model")
@RequiredArgsConstructor
public class ModelController {

    private final ModelServiceImpl modelService;

    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String isRunning() {
        return "API is working";
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ModelDTO> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelDTO getModelByID(@PathVariable("id") Long id) {
        return modelService.getModelByID(id);
    }


    @PostMapping("/add")
    public ResponseEntity<ModelDTO> addModel(@Valid @RequestBody ModelDTO dto) throws NullPointerException{
        try {
            ModelDTO addModel = modelService.addModel(dto);
            return new ResponseEntity<>(addModel, HttpStatus.CREATED);
        }catch (DuplicateRequestException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Model saveModel(@RequestBody ModelSaveDTO dto) throws Exception {
        return modelService.saveModel(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Model updateModel(@RequestBody ModelUpdateDTO dto) throws Exception {
        return modelService.updateModel(dto);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteModel(@PathVariable("id") Long id) throws Exception {
        modelService.deleteModel(id);
        return "Silme İşlemi Başarılı.";
    }
}
