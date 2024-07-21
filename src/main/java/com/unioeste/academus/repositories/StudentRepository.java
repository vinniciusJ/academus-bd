package com.unioeste.academus.repositories;

import com.unioeste.academus.models.Student;
import com.unioeste.academus.models.Subject;
import com.unioeste.academus.models.SubjectClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT student FROM Student student LEFT JOIN CourseEnrollment courseEnrollment ON courseEnrollment.student.id = student.id")
    public List<Student> findAll();

    @Query("SELECT sc FROM SubjectClassEnrollment sce " +
            "JOIN sce.subjectClass sc " +
            "WHERE sce.student.id = :studentId")
    public List<SubjectClass> findStudentSubjectClassesById(@Param("studentId") Long studentId);

    @Query("SELECT DISTINCT sc.subject FROM SubjectClassEnrollment sce " +
            "JOIN sce.subjectClass sc " +
            "WHERE sce.student.id = :studentId")
    List<Subject> findAllSubjectsByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT s FROM Student s WHERE s.code = :studentCode")
    public Student findByCode(@Param("studentCode") String studentCode);

    @Query("""
        SELECT sc
        FROM SubjectClass sc
        JOIN sc.subject s
        WHERE s.course.id = (
            SELECT ce.course.id
            FROM CourseEnrollment ce
            WHERE ce.student.id = :studentId
        )
         AND sc.academicYear = (
            SELECT ay
            FROM AcademicYear ay
            WHERE ay.year = EXTRACT(YEAR FROM CURRENT_DATE)
        )
        AND sc NOT IN (
            SELECT sce.subjectClass
            FROM SubjectClassEnrollment sce
            JOIN sce.subjectClass sc_e
            JOIN sc_e.subject s_e
            WHERE sce.student.id = :studentId
            AND s_e.id = s.id
        )
    """)
    public List<SubjectClass> findAvailableSubjectClasses(@Param("studentId") Long studentId);






}
