import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class WordList {
	
	private ArrayList<String> wordList = null;
	FileReader fr = null;
	BufferedReader br = null;
	
	private boolean[] already;
	public static WordList instance;
	Random random = new Random();
	
	private WordList() {
		
		wordList = new ArrayList<String>();
		
		try {
			fr = new FileReader("C:\\Users\\ssop6\\eclipse-workspace\\HangMan\\words.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			br = new BufferedReader(fr);
			while(true) {
				String temp = br.readLine();
				if(temp.equals(null)) {
					break;
				}
				System.out.println(temp);
				wordList.add(temp);
			}
		}catch(Exception e) {
			
		}finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		already = new boolean[wordList.size() - 1];
		
	}
	
	public String getWord() {
		if(Game.round > wordList.size()) {
			return "";
		}
		
		while(true) {
			int randomIndex = random.nextInt(wordList.size() - 1);
				if(!already[randomIndex]) {
					already[randomIndex] = true;
					return wordList.get(randomIndex);
			}
		}		
	}
	
	public int getWordListSize() {
		return wordList.size();
	}
	
	public static WordList getInstance() {
		if (instance == null) {
			instance = new WordList();
		}
		
		return instance;
	}

}
