package com.example.course_management.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseStatus status;

    // Thay thế long instructorId cũ bằng object Instructor
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // 1 khóa học có thể có nhiều lượt đăng ký
    @OneToMany(mappedBy = "course")
    private List<StudentEnrollment> enrollments;

    public Course() {}

    public Course(String title, CourseStatus status, Instructor instructor) {
        this.title = title;
        this.status = status;
        this.instructor = instructor;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public CourseStatus getStatus() { return status; }
    public void setStatus(CourseStatus status) { this.status = status; }
    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public List<StudentEnrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<StudentEnrollment> enrollments) { this.enrollments = enrollments; }
}