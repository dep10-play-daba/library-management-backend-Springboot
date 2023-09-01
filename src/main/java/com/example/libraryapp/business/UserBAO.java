package com.example.libraryapp.business;

import com.example.libraryapp.dto.UserDTO;
import com.example.libraryapp.entity.User;

import java.util.List;

public interface UserBAO {
    UserDTO saveUser(UserDTO userDTO)throws Exception;
    void deleteUser(int id)throws Exception;
    List<UserDTO> getAllUsers(String s)throws Exception;
    void updateUser(UserDTO userDTO,Integer userID)throws Exception;
    UserDTO findByUserID(Integer Id)throws Exception;

    UserDTO getUserByUsername(String username);
}
