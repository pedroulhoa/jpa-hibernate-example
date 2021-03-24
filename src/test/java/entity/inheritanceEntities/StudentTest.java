package entity.inheritanceEntities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.DAO;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    DAO<Student> dao;

    @BeforeEach
    void dao() {
        dao = new DAO<>(Student.class);
    }

    @Test
    void createStudentsTest() {
        Student student = new Student(123L, "Pedro");
        ScholarshipStudent scholarshipStudent = new ScholarshipStudent(1234L, "João", 500.20);

        dao.insertAtomic(student);
        dao.insertAtomic(scholarshipStudent);
        dao.closeEntityManager();

        assertNotNull(student.getRegistration());
        assertNotNull(scholarshipStudent.getRegistration());
    }

}