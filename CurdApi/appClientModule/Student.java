import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
public class Student {
   
   
    private Long id;
    private String name;
    private int age;
    private String grade;
    private String address;

    // Getters and setters
}
public interface StudentRepository extends JpaRepository<Student, Long> 
{

	List<Student> findAll();

	Object findById(Long id);

	void save(Student student);}