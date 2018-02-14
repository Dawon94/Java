import java.util.Random;

public class WordList {
	
	private String[] wordList;
	private boolean[] already;
	public static WordList instance;
	Random random = new Random();
	
	private WordList() {
		wordList = new String[] {
				"apple",
				"banana",
				"java",
				"head",
				"first",
				"oxford",
				"innovator",
				"school",
				"business",
				"notebook",
				"premium"
		};
		
		already = new boolean[wordList.length - 1];
		
	}
	
	public String getWord() {
		while(Game.round < wordList.length) {
			int randomIndex = random.nextInt(wordList.length - 1);
				if(!already[randomIndex]) {
					return wordList[randomIndex];
			}
		}
		return "";		
	}
	
	public int getWordListSize() {
		return wordList.length;
	}
	
	public static WordList getInstance() {
		if (instance == null) {
			instance = new WordList();
		}
		
		return instance;
	}

}
