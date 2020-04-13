package com.student.student;

public class Student {

    int rollNo;
    String name;
    int totalMarks;

    public Student(int rollNo, String name, int totalMarks) {
		this.rollNo = rollNo;
		this.name = name;
		this.totalMarks = totalMarks;
	}

	public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }
}
