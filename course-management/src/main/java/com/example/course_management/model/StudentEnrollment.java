package com.example.course_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_enrollments") // Chuẩn hóa tên bảng snake_case
public class StudentEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id") // Khóa ngoại trỏ về bảng students
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id") // Khóa ngoại trỏ về bảng courses
    private Course course;

    public StudentEnrollment() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}