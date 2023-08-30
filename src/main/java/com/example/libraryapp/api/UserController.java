package com.example.libraryapp.api;

import com.example.libraryapp.business.UserBAO;
import com.example.libraryapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private final UserBAO userBAO;

    public UserController(UserBAO userBAO) {
        this.userBAO = userBAO;
    }
    @GetMapping
    public List<UserDTO> getAllUsers(@RequestParam(value = "q",required = false)String query) throws Exception {
        if (query==null)query="";
       return userBAO.getAllUsers(query);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void saveUser(@RequestBody UserDTO userDto) throws Exception {
        userBAO.saveUser(userDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "/{UserID}",consumes = "application/json")
    public void UpdateUser(@RequestBody UserDTO userDto,@PathVariable("UserID") Integer userID) throws Exception {
        userBAO.updateUser(userDto,userID);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{UserID}")
    public void DeleteUser(@PathVariable("UserID") Integer userID) throws Exception {
        userBAO.deleteUser(userID);
    }

}
