package com.example.course_management.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "students") // Chuẩn hóa tên bảng snake_case số nhiều
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // 1 học sinh có thể có nhiều lượt đăng ký khóa học
    @OneToMany(mappedBy = "student")
    private List<StudentEnrollment> enrollments;

    public Student() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<StudentEnrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<StudentEnrollment> enrollments) { this.enrollments = enrollments; }
}