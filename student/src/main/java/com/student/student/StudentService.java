package com.student.student;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	Map<Integer, Student> students = new HashMap<>();
	
    public StudentService() {
		Student s1 = new Student(1,"Daniel",100);
		Student s2 = new Student(2,"Paul",200);
		Student s3 = new Student(3,"John",300);
		Student s4 = new Student(4,"Jim",400);
		Student s5 = new Student(5,"Kim",500);
		Student s6 = new Student(6,"Alex",600);
		Student s7 = new Student(7,"Ronald",700);
		Student s8 = new Student(8,"Jill",800);
		Student s9 = new Student(9,"Jack",900);
		Student s10 = new Student(10,"Jackson",1000);
		
		students.put(1, s1);
		students.put(2, s2);
		students.put(3, s3);
		students.put(4, s4);
		students.put(5, s5);
		students.put(6, s6);
		students.put(7, s7);
		students.put(8, s8);
		students.put(9, s9);
		students.put(10, s10);
	}

    public void addStudent(Student student) throws Exception {
        if(students.containsKey(student.getRollNo())) {
            throw new Exception("Student already exists");
        }
        else {
            students.put(student.getRollNo(), student);
        }
    }

    public Iterable<Student> getStudents(){
        return students.values();
    }

    public Student getStudent(int rollNo) throws Exception {

        if(students.containsKey(rollNo)) {
            return students.get(rollNo);
        }
        else {
            throw new Exception("Student not found");
        }
    }

    public void updateStudent(Student student) throws Exception {
        if(students.containsKey(student.getRollNo())) {
            students.put(student.getRollNo(), student);
        }
        else {
            throw new Exception("Student not found");
        }
    }

    public void deleteStudent(int rollNo) throws Exception {
        if(students.containsKey(rollNo)) {
            students.remove(rollNo);
        }
        else {
            throw new Exception("Student not found");
        }
    }

}
