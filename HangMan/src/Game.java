import java.util.Scanner;
import acm.program.*;

public class Game extends ConsoleProgram{
	public static int round = 0;
	private WordList wordList; 
	private HangmanCanvas canvas;
	private StringBuilder incorrectLetter;
	private StringBuilder displayedString;

	private void hangman() {
		String answer = wordList.getWord();
		char[] problemWord = answer.toCharArray();
		boolean[] guessed = new boolean[problemWord.length];
		int leftGuessing = 8;
		while(leftGuessing != 0) {
			print("The word now looks like this:  ");
			boolean isCorrect = true;
			displayedString = new StringBuilder();
			for (int i = 0; i < problemWord.length; i++) {
				if(guessed[i]) {
					print(problemWord[i]+ " ");
					displayedString.append(problemWord[i] + " ");
				}else {
					print("_ ");
					displayedString.append("_ ");
					isCorrect = false;
				}
			}

			canvas.displayWord(displayedString.toString());

			if(isCorrect) {
				println("");
				println("You guessed the word : " + answer);
				println("You win");
				println("Go to the next Game");
				break;
			}

			println("");
			println("You have " + leftGuessing + " guesses left.");
			print("Your guess:");
			String strLetter = readLine();
			println("");
			char letter = strLetter.toCharArray()[0];
			boolean isGuessed = false;
			for (int i = 0; i < problemWord.length; i++) {
				if(problemWord[i] == letter && guessed[i] == false) {
					guessed[i] = true;
					isGuessed = true;
				}
			}

			if (isGuessed == false) {
				println("There are no" + letter + "'s in the word");
				leftGuessing -= 1;
				incorrectLetter.append(letter);
				canvas.noteIncorrectGuess(incorrectLetter.toString());
				if (leftGuessing == 0) {
					println("You loose");
					println("Go to the next Game");
					println("");
					canvas.reset();
				}
				continue;
			}else {
				println("The guess is Correct");	
			}
		}
	}


	public void run() {
		wordList = WordList.getInstance();
		while(wordList.getWordListSize() > round) {
			canvas.reset();
			incorrectLetter = new StringBuilder();
			hangman();
			round++;
		}
	}

	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);

	}



}
