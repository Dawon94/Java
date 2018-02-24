package dawons.calendar;

import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT = "cal>";
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);

		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		Calendar cal = new Calendar();
		int year = 1;
		int month = 1;
		while(true) {
			System.out.println("원하시는 년을 입력해 주세요");
			System.out.println(PROMPT);
			year = scanner.nextInt();
			System.out.println("원하시는 달을 입력해 주세요");
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
