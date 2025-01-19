package com.cruddemo.cruddemo;

import com.cruddemo.cruddemo.Entity.Student;
import com.cruddemo.cruddemo.dao.StudentDao;
import com.cruddemo.cruddemo.dao.StudentDaoImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	private final StudentDaoImpl studentDaoImpl;

	public CruddemoApplication(StudentDaoImpl studentDaoImpl) {
		this.studentDaoImpl = studentDaoImpl;
	}

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
			System.out.println("Elindult");
			//saveStudent(studentDao);
			//createMultipleStudent(studentDao);

			//findById(studentDao,7);
			//findAll(studentDao);
			//findByName(studentDao,"Doe");
			//updateStudent(studentDao);
			deleteStudent(studentDao);
		};
	}
	private void updateStudent(StudentDao studentDao){
		int id =2;
		Student student = studentDao.findById(2);
		student.setFirstname("Updated");
		studentDao.update(student);
		System.out.println("Updated");
	}
	private void deleteStudent(StudentDao studentDao){
		int id = 2;
		studentDao.delete(id);
	}

	private void findByName(StudentDao dao, String name){
		List<Student> students = dao.findByName(name);
	}

	private void findAll(StudentDao studentDao) {
		List<Student> students = studentDao.findAll();

		for(Student s : students){
			System.out.println("Student name: "+ s.getFirstname() + "ID: "+ s.getId());
		}
	}
	private void findById(StudentDao studentDao, Integer id){
		Student s = studentDao.findById(id);

		System.out.println("Student name:"+ s.getFirstname() + "ID:" + s.getId());
	}
	private void createMultipleStudent(StudentDao studentDao){
		Student student1 = new Student("Kern","József","kern.jozsef@gmail.com");
		Student student2 = new Student("Józsa","Gergő","jozsagergo@gmail.com");
		Student student3 = new Student("Kovács","Ákos","kovacsakos@gmail.com");
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);

	}
	private void saveStudent(StudentDao student){
		Student newStudent =
				new Student("Paul","Doe", "paul.dou@gmail.com");
		student.save(newStudent);

		System.out.println("New Student id:" + newStudent.getId());
	}
}
