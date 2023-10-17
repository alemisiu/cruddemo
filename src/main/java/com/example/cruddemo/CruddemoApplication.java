package com.example.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.Entity.Student;
import com.example.cruddemo.dao.StudentDAO;

import jakarta.persistence.Id;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {

			// createStudent(studentDAO);

			 createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent (studentDAO);

			// deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("deleting all student :");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count:" + numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("deleting  student id:" + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrive student based on the id : primary key
		int studentId = 1;
		System.out.println("getting student Id:" + studentId);
		var myStudent = studentDAO.findById(studentId);
		// change first name to the "Scooby"
		System.out.println("updating student ....");
		myStudent.setFirstName("Scooby");
		// update the student
		studentDAO.update(myStudent);
		// display the updated student
		System.out.println("updated student :" + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of the students
		List<Student> theStudents = studentDAO.findByLastName("doe");
		// display the list of the students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		// idk
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("creating a student object: ...");
		var tempStudent = new Student("Dafffy", "Duck", "daffy@luv2code.com");
		// save the student
		System.out.println("save the student :");
		studentDAO.save(tempStudent);
		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student . generated id " + theId);
		// retrive student based on the id : primary key
		System.out.println("retriving student  with id:" + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student

		System.out.println("found  the student :" + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("creating 3 students object");
		Student tempStudent1 = new Student("Paul", "DOE", "paul@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "Mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "Bonita@luv2code.com");
		// save the students object
		System.out.println("saving the new students: ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("creating new student object");
		Student tempStudent = new Student("Paul", "DOE", "paul@luv2code.com");
		// save the student object
		System.out.println("saving the student : ... ");
		studentDAO.save(tempStudent);
		// display id of the saved student

		System.out.println("saved student generated id:" + tempStudent.getId());

	}

}
