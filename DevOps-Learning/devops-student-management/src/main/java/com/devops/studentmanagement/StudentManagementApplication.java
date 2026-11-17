package com.devops.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
        System.out.println("=================================================");
        System.out.println(" DevOps Student Management Application Started!  ");
        System.out.println(" Ready to accept API requests on port 8080       ");
        System.out.println("=================================================");
    }
}
