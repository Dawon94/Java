import java.util.ArrayList;

public class StudentManager {
	
	ArrayList<Student> students = new ArrayList<Student>();
	StudentExpel StudentExpel = new StudentExpel();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentManager studentManager = new StudentManager();
		
		studentManager.addStudent("ȫ", 22, 13146315, "���ؿ�ȭ");
	}
	
	private void addStudent(String name, int age, int studentName, String major) {
		students.add(new Student(name,age,studentName,major));
		System.out.println(name + "�л����� �Է¿Ϸ�");
	}

}
