package in.service;

import java.util.List;
import in.entity.Student;

public interface StudentService {
    boolean saveStudent(Student student);
    List<Student> getAllStudents();
    void deleteStudentByID(int id);
    Student findStudentById(int id);
}
