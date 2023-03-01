package com.pws.JpaCurdOperation.service;


import com.pws.JpaCurdOperation.dto.SignUpDTO;
import com.pws.JpaCurdOperation.dto.StudentDto;
import com.pws.JpaCurdOperation.entity.Student;
import com.pws.JpaCurdOperation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void UserSignUp(SignUpDTO signupDTO) throws Exception {

        Optional<Student> optionalUser = studentRepository.findStudentByName(signupDTO.getUserName());
        if (optionalUser.isPresent())
            throw new Exception("Student Already Exist with Name : " + signupDTO.getUserName());
        Student user = new Student();
        user.setUserName(signupDTO.getUserName());
        PasswordEncoder encoder = new BCryptPasswordEncoder(8);
        user.setPassword(encoder.encode(signupDTO.getPassword()));
        user.setBranch(signupDTO.getBranch());
        studentRepository.save(user);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Integer id) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return studentRepository.findById(id);
        } else {
            throw new Exception("Id Not present");
        }
    }

    @Override
    public void updateStudent(StudentDto studentDto) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(studentDto.getId());
        Student student = null;
        if (!optionalStudent.isPresent())
            System.out.println("Id Not present");
        student = optionalStudent.get();
        student.setUserName(studentDto.getUserName());
        student.setPassword(studentDto.getPassword());
        student.setBranch(studentDto.getBranch());
        studentRepository.save(student);
    }


    @Override
    public String deleteStudentById(Integer id) {
        Optional<Student> optionalStudent=studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return id + " Id is deleted";
        }
        else {
            return id+" id Not present";
        }
    }

    @Override
    public List<String> getAllStudentName() {
        return studentRepository.fetchAllStudentName();
    }
}
