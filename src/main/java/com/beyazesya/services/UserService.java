package com.beyazesya.services;


import com.beyazesya.dto.user.UserDTO;
import jakarta.validation.Valid;

public interface UserService {

    UserDTO addUser (@Valid UserDTO dto);

}
