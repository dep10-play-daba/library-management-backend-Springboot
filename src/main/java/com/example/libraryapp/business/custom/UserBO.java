package com.example.libraryapp.business.custom;

import com.example.libraryapp.business.UserBAO;
import com.example.libraryapp.business.util.Transformer;
import com.example.libraryapp.dao.UserDAO;
import com.example.libraryapp.dto.UserDTO;
import com.example.libraryapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserBO implements UserBAO {
    private final Transformer transformer;
    private final UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserBO(Transformer transformer, UserDAO userDAO) {
        this.transformer = transformer;
        this.userDAO = userDAO;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) throws Exception {
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        return transformer.toUserDTO(userDAO.save(transformer.fromUserDTO(userDTO)));
    }


    @Override
    public void deleteUser(int id) throws Exception {
        userDAO.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllUsers(String s) throws Exception {
        if (s.isEmpty()){
            return userDAO.findAll().stream().map(user->transformer.toUserDTO(user)).collect(Collectors.toList());
        }
        int a;
        try {
            a=Integer.parseInt(s);
            System.out.println("try");
        }catch (Exception e){
            a=-1;
            System.out.println("catch");
        }
        s="%"+s+"%";
        System.out.println("string map : "+ s);
        return userDAO.findUserByUserIdLikeOrNameLikeOrContactLike(a,s,s).stream().map(transformer::toUserDTO).collect(Collectors.toList());
    }

    @Override
    public void updateUser(UserDTO userDTO,Integer userID) throws Exception {
        User user=userDAO.findById(userID).orElse(null);
        if (user==null) throw new SQLException();
        user.setAddress(userDTO.getAddress());
        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        if (!user.getContact().equals(userDTO.getContact())){
            user.setContact(userDTO.getContact());
        }
        user.setRole(userDTO.getRole());
        userDAO.save(user);
    }

    @Override
    public UserDTO findByUserID(Integer Id) throws Exception {
        return null;
    }
}
