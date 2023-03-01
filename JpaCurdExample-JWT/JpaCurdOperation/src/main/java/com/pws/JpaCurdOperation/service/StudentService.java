package com.pws.JpaCurdOperation.service;

import com.pws.JpaCurdOperation.dto.SignUpDTO;
import com.pws.JpaCurdOperation.dto.StudentDto;
import com.pws.JpaCurdOperation.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public void UserSignUp(SignUpDTO signupDTO) throws Exception;

    public List<Student> getAllStudent();

    public Optional<Student> getStudentById(Integer id) throws Exception;

    public void updateStudent(StudentDto studentDto) throws Exception;

    public String deleteStudentById(Integer id);

    public List<String> getAllStudentName();
}
