package dawons.calendar;

import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT = "cal>";
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);

		//���ڸ� �Է¹޾� �ش��ϴ� ���� �ִ� �ϼ��� ����ϴ� ���α׷�
		Calendar cal = new Calendar();
		int year = 1;
		int month = 1;
		while(true) {
			System.out.println("���Ͻô� ���� �Է��� �ּ���");
			System.out.println(PROMPT);
			year = scanner.nextInt();
			System.out.println("���Ͻô� ���� �Է��� �ּ���");
			System.out.println(PROMPT);
			month = scanner.nextInt();
			if (month == 0) {
				break;
			}
			cal.printCalendar(year, month);
		}
		
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
