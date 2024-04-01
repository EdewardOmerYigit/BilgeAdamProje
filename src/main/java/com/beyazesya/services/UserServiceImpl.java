package com.beyazesya.services;


import com.beyazesya.dto.user.UserDTO;
import com.beyazesya.entities.User;
import com.beyazesya.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

   private final UserRepository repository;

    @Override
    public UserDTO addUser(UserDTO dto) {
        try {
            User user = mapUserDtoToEntity(dto);
                user = repository.save(user);
                return mapEntityToUserDto(user);
            } catch (Exception ex) {
                throw new ServiceException("User Kayıt Sırasında Hata Oluştu", ex);
            }
    }



    private User mapUserDtoToEntity(UserDTO dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());

        return entity;
    }

    private UserDTO mapEntityToUserDto(User entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        return dto;
    }

}
