package com.pws.JpaCurdOperation.repository;

import com.pws.JpaCurdOperation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("select o.userName from Student o")
    List<String> fetchAllStudentName();

    @Query("select o from Student o where o.userName=:userName")
    Optional<Student> findStudentByName(String userName);
}
