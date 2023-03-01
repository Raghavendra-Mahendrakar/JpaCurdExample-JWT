package com.pws.JpaCurdOperation.controller;

import com.pws.JpaCurdOperation.dto.LoginDto;
import com.pws.JpaCurdOperation.dto.SignUpDTO;
import com.pws.JpaCurdOperation.dto.StudentDto;
import com.pws.JpaCurdOperation.entity.Student;
import com.pws.JpaCurdOperation.jwt.security.config.JwtUtil;
import com.pws.JpaCurdOperation.repository.StudentRepository;
import com.pws.JpaCurdOperation.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("authenticate")
    public String generateToken(@RequestBody LoginDto loginDto) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserName(),loginDto.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(loginDto.getUserName());
    }

    @PostMapping("public/signup")
    public ResponseEntity<Object> signup(@RequestBody SignUpDTO signUpDTO) throws Exception {
        studentService.UserSignUp(signUpDTO);
        return new ResponseEntity<>("Student added",HttpStatus.OK);
    }

    @GetMapping("fetchAllStudent")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PutMapping("updateStudent")
    public ResponseEntity<Object> updateStudent(@RequestBody StudentDto studentDto) throws Exception {
        studentService.updateStudent(studentDto);
        return new ResponseEntity<>("Student updated",HttpStatus.OK);
    }

    @GetMapping("getStudentById")
    public Optional<Student> getStudentById(@RequestParam Integer id) throws Exception{
        return studentService.getStudentById(id);
    }

    @DeleteMapping("deleteById")
    public String deleteStudentById(@RequestParam Integer id){
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/fetch/name")
    public ResponseEntity<Object> getAllStudentName(){
    List<String> students=studentService.getAllStudentName();
        return ResponseEntity.ok(students);
    }

}
