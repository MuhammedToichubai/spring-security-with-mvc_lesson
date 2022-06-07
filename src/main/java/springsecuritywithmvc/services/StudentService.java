package springsecuritywithmvc.services;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import springsecuritywithmvc.exceptions.AlreadyExistsException;
import springsecuritywithmvc.exceptions.NotFoundException;
import springsecuritywithmvc.models.Student;
import springsecuritywithmvc.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        String email = student.getEmail();

        boolean exists = studentRepository.existsByEmail(email);

        if (exists) {
            throw new AlreadyExistsException(
                    "email = " + email + " already in use!"
            );
        }

        studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new NotFoundException(
                    "Student with id = " + studentId + " not found!"
            );
        }

        return studentRepository.findById(studentId);
    }

    public void deleteById(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new NotFoundException(
                    "Student with id = " + studentId + " not found!"
            );
        }

        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Long studentId, Student newStudent) {
        studentRepository.updateStudent(studentId, newStudent);
    }

    public List<Student> findAll(String search) {
        return studentRepository.findAll(search);
    }
}
