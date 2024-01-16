import java.util.List;

public class Studentcontroller {
	private StudentRepository studentRepository;

  
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return ((Object) studentRepository.findById(id)).orElse(null);
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student created successfully";
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setGrade(updatedStudent.getGrade());
            existingStudent.setAddress(updatedStudent.getAddress());
            studentRepository.save(existingStudent);
            return "Student updated successfully";
        } else {
            return "Student not found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }
}
}
