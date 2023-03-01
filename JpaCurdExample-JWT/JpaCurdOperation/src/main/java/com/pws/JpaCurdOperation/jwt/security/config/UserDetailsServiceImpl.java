package com.pws.JpaCurdOperation.jwt.security.config;

import com.pws.JpaCurdOperation.entity.Student;
import com.pws.JpaCurdOperation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

            Optional<Student> optionalUser = studentRepository.findStudentByName(userName);
            if (optionalUser.isPresent()) {
                return optionalUser.get();
            }else
                throw new UsernameNotFoundException(userName);
    }
}
