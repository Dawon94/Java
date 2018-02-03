import java.util.ArrayList;

public class StudentExpel {
	ArrayList<Student> expelStudent;
	
	public StudentExpel() {
		expelStudent = new ArrayList<Student>();
	}
	
	public void addExpelStudent(String name, int age, int studentNum, String major) {
		expelStudent.add(new Student(name, age, studentNum, major));
	}

}
