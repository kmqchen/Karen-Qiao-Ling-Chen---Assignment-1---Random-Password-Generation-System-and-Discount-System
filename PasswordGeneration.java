package PasswordGeneration;
import java.util.Random;
import java.util.StringTokenizer;
/**
to generate random passwords which will be composed of words from a few selected pages.
The selected text is provided as a multidimensional String array – the first level (dimension)
contains the pages, the second level contains the paragraphs on each page, and the third level
contains the lines in each paragraph.
The password generation process is as follows:
	A password is composed of three words.
	The page number, paragraph number, and line number are chosen randomly. You must use the
	java.util.Random class to generate random numbers using the nextInt() method. You can look it
	up in the Java API online.
	Convert the String from the chosen line into an array of words using the split(“ ”) method (space
	as the separator).
	Choose a random word from the array in Step 3. (Hint: the length attribute of an array will tell
	you how many words are in the array.)
	If a word is composed of only a single character (e.g., “a”), or the word contains the newline
	character (‘\n’), go back to Step 2.
	When you have three words, concatenate them to form a candidate password, and apply the
	following steps. You can use the compareTo() method from the String class (but no HashSet).
	Restriction: Don’t use any method from the Character class.
		No two words can be exactly the same (e.g., “theAlicethe” isn’t allowed, but “the” and
		"The" are accepted). Otherwise, go back to Step 2.
		The password must be at least 8 characters long but under 16 characters. Otherwise, go
		back to Step 2.
	The password must contain an upper case character. Otherwise, go back to Step 2.
	The password must contain a lower case character. Otherwise, go back to Step 2.
	The password must contain only one special (non-alphabetic) character. Otherwise, go back to Step 2.
	Restriction: Don’t use any method from the Character class.
	If all conditions are met, you print the password, along with the number of password
	generation attempts that failed due to: (i) having a newline character, (ii) having a single-character
	word, (iii) having the same words, (iv) not meeting the upper case requirement, (v) not meeting the
	lower case requirement, (vi) not meeting the special character requirement.
	You continue generating passwords until you generate a total of 10,000 passwords, OR if you generate a
	password where the count for the item (v) in Step 6 f) is non-zero. Your program’s output must be
	formatted as given below (you can use the Sting.format() method). Two examples to follow:
	You should divide your program into methods and provide JUnit testing for all of them.
		Explanation of the highlighted line in the output above:
		Before the valid password Whiteonce;the was generated, there were 3 passwords with a newline
		character generated; one whose length was not within the requested limits; 4 that did not have an upper
		case letter; and 1 that did not have a special character. Also, 10,000 passwords were generated as there
		was never a password generated with no lower case letters in it. */

public class PasswordGeneration {
	static final int GET_WORDS = 3;
	static final int SPLIT_WORDS = 10000;
	static final String DELIMITER = " ";
	private int i = 0;
	private int j = 0;
	private int k = 0;
	private int o = 0;
	private int x = 0;
	private int pageNo;
	private int paragraphNo;
	private int lineNo;
	private int newLineNo = 0;
	private int single = 0;		
	private int equalNo = 0;
	private int length = 0;
	private int upper = 0;
	private int upperNo = 0;
	private int lower = 0;
	private int lowerNo = 0;
	private int specChar = 0;
	private int specialCharacter = 0;
	private int wordCount;
	
	private String password = "";
	private String getWord1 = "";
	private String getWord2 = "";
	private String getWord3 = "";
	private String[] splittedWord  = new String[SPLIT_WORDS];
	private String[] getWord = new String[GET_WORDS];
	
	Random randPage = new Random();
	Random randParagraph = new Random();
	Random randLine = new Random();
	Random randWord = new Random();
	
	private char[] ch;
	
	boolean valid;
	
	// Default Constructor
	PasswordGeneration(){
		
	}
	
	//splittedBook Method
	String[] splittedBook(String[][][] article) {
		for(i = 0; i < article.length; i++) {
			for(j = 0; j < article[i].length; j++) {
				for(k = 0; k < article[i][j].length; k++) {
					StringTokenizer wordSplit = new StringTokenizer(article[i][j][k], DELIMITER);
					wordCount = wordSplit.countTokens();
					for(x = 0; x < wordCount; x++){
						splittedWord[x] = wordSplit.nextToken();
					}
				}
			}
		}
		return splittedWord;
	}
	
	//getWord Method
	String[] getWord(String article[][][]) {
		for(i = 0; i < GET_WORDS; i++) {
			//Random Word Selection
			pageNo = randPage.nextInt(article.length);
			paragraphNo = randParagraph.nextInt(article[pageNo].length);
			lineNo = randLine.nextInt(article[pageNo][paragraphNo].length);
			o = randWord.nextInt(wordCount);
			getWord[i] = splittedWord[o];
			
			this.ch = getWord[i].toCharArray();	
			
			//Case: a word with only one character
			if(getWord[i].length() < 2) {
				single++;
				getWord[0] = "";
				getWord[1] = "";
				getWord[2] = "";
				i = 0;
				pageNo = randPage.nextInt(article.length);
				paragraphNo = randParagraph.nextInt(article[pageNo].length);
				lineNo = randLine.nextInt(article[pageNo][paragraphNo].length);
				o = randWord.nextInt(wordCount);
				getWord[i] = splittedWord[o];
			}
			
			//Case: a word with \n (new line) character
			for(j = 0; j < getWord[i].length(); j++) {
				if(j > 0 && getWord[i].charAt(j - 1) == '\'') {
					if(getWord[i].charAt(j) == 'n') {
						newLineNo++;
						getWord[0] = "";
						getWord[1] = "";
						getWord[2] = "";
						i = 0;
						pageNo = randPage.nextInt(article.length);
						paragraphNo = randParagraph.nextInt(article[pageNo].length);
						lineNo = randLine.nextInt(article[pageNo][paragraphNo].length);
						o = randWord.nextInt(wordCount);
						getWord[i] = splittedWord[o];
					}
				}
			}
			
			//Characters in the random selected word with upper case letters / lower case letters / special characters
			for(char chh : ch) {
				if(chh >='A' && chh <='Z') {
					upperNo++;
			    } 
				else if (chh >= 'a' && chh <= 'z') {
			        lowerNo++;
			    } 
				else if (chh == '!' || chh == '@' || chh == '#' || chh == '$' || chh == '%' || chh == '^' 
						|| chh == '&' || chh == '*' || chh == ',' || chh == '.' || chh == '\"' || chh == '?' || chh == '!') {
					specialCharacter++;
			    }
				else if(chh == '=') {
					equalNo++;
				}
				else {
			        continue;
			    }
			}
			
			//Case: upper case letter - less than one:
			if(this.upperNo == 0) {
				this.upper++;
				getWord[0] = "";
				getWord[1] = "";
				getWord[2] = "";
				i = 0;
				pageNo = randPage.nextInt(article.length);
				paragraphNo = randParagraph.nextInt(article[pageNo].length);
				lineNo = randLine.nextInt(article[pageNo][paragraphNo].length);
				o = randWord.nextInt(wordCount);
				getWord[i] = splittedWord[o];
			}
			
			//lower case letter - less than one
			if(this.lowerNo == 0) {
				this.lower++;
				getWord[0] = "";
				getWord[1] = "";
				getWord[2] = "";
				i = 0;
				pageNo = randPage.nextInt(article.length);
				paragraphNo = randParagraph.nextInt(article[pageNo].length);
				lineNo = randLine.nextInt(article[pageNo][paragraphNo].length);
				o = randWord.nextInt(wordCount);
				getWord[i] = splittedWord[o];
			}
			
			//Case: special characters - more than 1
			if(this.specialCharacter > 1) {
				this.specChar++;
			}
			
			//Case: special characters - less 1
			if(this.specialCharacter == 0) {
				specChar++;
				getWord[0] = "";
				getWord[1] = "";
				getWord[2] = "";
				i = 0;
				pageNo = randPage.nextInt(article.length);
				paragraphNo = randParagraph.nextInt(article[pageNo].length);
				lineNo = randLine.nextInt(article[pageNo][paragraphNo].length);
				o = randWord.nextInt(wordCount);
				getWord[i] = splittedWord[o];
			}
		}
		
		//3 strings to obtain randomly selected words 
		getWord1 = getWord[0];
		getWord2 = getWord[1];
		getWord3 = getWord[2];
		password = getWord1 + getWord2 + getWord3;
		
		return this.getWord;
	}
	
	//Password validation
	boolean validPassword() {
		if(this.getWord1.equals(this.getWord2) || this.getWord2.equals(this.getWord3) || this.getWord1.equals(this.getWord3))
			this.valid = false;
		else if(this.password.length() < 8 || this.password.length() > 16)
			this.valid = false;
		else if(upperNo < 1)
			this.valid = false;
		else if(lowerNo < 1)
			this.valid = false;
		else if(specialCharacter < 1)
			this.valid = false;
		else {
			this.valid = true;
		}
		return this.valid;
	}
	
	//Password output
	public String toString() {
		if(this.valid == true) {
			System.out.printf("Password = %-20s",this.password);
			System.out.printf("\tNewLine = " + this.newLineNo);
			System.out.printf("\tSingle = " + this.single);
			System.out.printf("\tEqual = " + this.equalNo);
			System.out.printf("\tLength = " + this.length);
			System.out.printf("\tUpper = " + this.upper);
			System.out.printf("\tLower = " + this.lower);
			System.out.printf("\tSpecial = " + this.specChar);
			System.out.println();
		}
		
		//Reset values of the variables
		newLineNo = 0;
		single = 0;		
		equalNo = 0;
		length = 0;
		upper = 0;
		upperNo = 0;
		lower = 0;
		lowerNo = 0;
		specChar = 0;
		specialCharacter = 0;
			
		return "Password: " + this.password + "New lines: " + this.newLineNo + "Single: " + this.single + "Equal: " 
				+ this.equalNo + "Upper: " + this.upper + "Lower: " + this.lower + "Special: " + this.specChar;
	}
}
