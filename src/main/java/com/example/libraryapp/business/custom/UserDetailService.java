package com.example.libraryapp.business.custom;
import com.example.libraryapp.dao.UserDAO;
import com.example.libraryapp.entity.MyUserDetails;
import com.example.libraryapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDAO.findByName(username);
        user.orElseThrow(()->new UsernameNotFoundException("Not found: "+username));
        return user.map(MyUserDetails::new).get();
    }
}
