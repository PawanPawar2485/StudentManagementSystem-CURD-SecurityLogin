package in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.entity.Student;
import in.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public boolean saveStudent(Student student) {
        try {
            studentRepo.save(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void deleteStudentByID(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student findStudentById(int id) {
        Optional<Student> opt = studentRepo.findById(id);
        return opt.orElse(null);
    }
}
