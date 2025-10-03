package in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.entity.Student;
import in.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/student-form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student()); // ← This is required!
        return "register"; // make sure template name matches exactly
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/student/view-all";
    }

    @GetMapping("/view-all")
    public String viewAllStudents(Model model) {
        List<Student> slist = studentService.getAllStudents();
        model.addAttribute("students", slist);  // changed key name to plural for clarity
        return "View-All";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int sid) {
        studentService.deleteStudentByID(sid);
        return "redirect:/student/view-all";
    }

    @GetMapping("/edit-form/{id}")
    public String studentEditForm(@PathVariable("id") int sid, Model model) {
        Student s = studentService.findStudentById(sid);
        model.addAttribute("std", s);
        return "Edit-student";
    }

    @GetMapping("/search-student")
    public String searchById(@RequestParam("sid") int id, Model model) {
        Student std = studentService.findStudentById(id);
        if (std != null) {
            model.addAttribute("student", std);
        } else {
            model.addAttribute("error", "No student found with this ID!");
        }
        return "Home";
    }
}
