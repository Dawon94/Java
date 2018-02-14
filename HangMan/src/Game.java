import java.util.Scanner;

public class Game {
	public static int round = 0;
	private WordList wordList;
	private Scanner sc;
	
	Game(){
		wordList = WordList.getInstance();
		sc = new Scanner(System.in);
	}
	
	private void hangman() {
		String answer = wordList.getWord();
		char[] problemWord = answer.toCharArray();
		boolean[] guessed = new boolean[problemWord.length];
		int leftGuessing = 8;
		while(leftGuessing != 0) {
			System.out.print("The word now looks like this:  ");
			boolean isCorrect = true;
			for (int i = 0; i < problemWord.length; i++) {
				if(guessed[i]) {
					System.out.print(problemWord[i]+ " ");
				}else {
					System.out.print("_ ");
					isCorrect = false;
				}
			}
			
			if(isCorrect) {
				System.out.println("");
				System.out.println("You guessed the word : " + answer);
				System.out.println("You win");
				System.out.println("Go to the next Game");
				break;
			}
			
			System.out.println("");
			System.out.println("You have " + leftGuessing + " guesses left.");
			System.out.print("Your guess:");
			String strLetter = sc.next();
			System.out.println("");
			char letter = strLetter.toCharArray()[0];
			boolean isGuessed = false;
			for (int i = 0; i < problemWord.length; i++) {
				if(problemWord[i] == letter && guessed[i] == false) {
					guessed[i] = true;
					isGuessed = true;
				}
			}
			
			if (isGuessed == false) {
				System.out.println("There are no" + letter + "'s in the word");
				leftGuessing -= 1;
				if (leftGuessing == 0) {
					System.out.println("You loose");
					System.out.println("Go to the next Game");
				}
				continue;
			}else {
				System.out.println("The guess is Correct");	
			}
	 		}
		}
		
	
	public void start() {
		while(wordList.getWordListSize() > round) {
			hangman();
			round++;
		}
	}
	
	

}
