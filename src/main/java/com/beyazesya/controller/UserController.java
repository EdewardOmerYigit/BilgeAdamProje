package com.beyazesya.controller;

import com.beyazesya.dto.model.ModelDTO;
import com.beyazesya.dto.model.ModelSaveDTO;
import com.beyazesya.dto.model.ModelUpdateDTO;
import com.beyazesya.dto.user.UserDTO;
import com.beyazesya.entities.Model;
import com.beyazesya.services.ModelServiceImpl;
import com.beyazesya.services.UserService;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO dto) throws NullPointerException{
        try {
            UserDTO addUser = service.addUser(dto);
            return new ResponseEntity<>(addUser, HttpStatus.CREATED);
        }catch (DuplicateRequestException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
