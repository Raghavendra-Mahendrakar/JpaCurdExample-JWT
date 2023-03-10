package com.pws.JpaCurdOperation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Integer id;

    private String userName;

    private String password;

    private String branch;
}
