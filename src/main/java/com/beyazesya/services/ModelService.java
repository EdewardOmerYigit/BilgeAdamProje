package com.beyazesya.services;

import com.beyazesya.dto.model.ModelDTO;
import jakarta.validation.Valid;

public interface ModelService {

    ModelDTO addModel (@Valid ModelDTO dto);

}
