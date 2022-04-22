package PasswordGeneration;

public class PasswordGenerationOutput {

	//--------------------------------------------------------------------------------------------------
	
	//Assignment 1
	
	//Written by: Qiao Ling Chen, Student #0995426
	
	//For Application Development 2 (Mobile) - Winter 2022
	
	//---------------------------------------------------------------------------------------------------
	
	/**
	To generate random passwords which will be composed of words from a few selected pages.
	The selected text is provided as a multidimensional String array – the first level (dimension)
	contains the pages, the second level contains the paragraphs on each page, and the third level
	contains the lines in each paragraph.*/
	
	/**
	The password generation process is as follows: steps
		1. 	A password is composed of three words.
		2. 	The page number, paragraph number, and line number are chosen randomly. You must use the
			java.util.Random class to generate random numbers using the nextInt() method. You can look it
			up in the Java API online.
		3. 	Convert the String from the chosen line into an array of words using the split(“ ”) method (space
			as the separator).
		4.	 Choose a random word from the array in Step 3. (Hint: the length attribute of an array will tell
			you how many words are in the array.)
		5. 	If a word is composed of only a single character (e.g., “a”), or the word contains the newline
			character (‘\n’), go back to Step 2.
		6. 	When you have three words, concatenate them to form a candidate password, and apply the
			following steps. You can use the compareTo() method from the String class (but no HashSet).
			Restriction: Don’t use any method from the Character class.
				a. 	No two words can be exactly the same (e.g., “theAlicethe” isn’t allowed, but “the” and
					"The" are accepted). Otherwise, go back to Step 2.
				b. 	The password must be at least 8 characters long but under 16 characters. Otherwise, go
					back to Step 2.
				c.	The password must contain an upper case character. Otherwise, go back to Step 2.
				d.	The password must contain a lower case character. Otherwise, go back to Step 2.
				e.	The password must contain only one special (non-alphabetic) character. Otherwise, go back to Step 2.
					Restriction: Don’t use any method from the Character class.
				f.	If all conditions are met, you print the password, along with the number of password
					generation attempts that failed due to: (i) having a newline character, (ii) having a single-character
					word, (iii) having the same words, (iv) not meeting the upper case requirement, (v) not meeting the
					lower case requirement, (vi) not meeting the special character requirement.
		7. 	You continue generating passwords until you generate a total of 10,000 passwords, OR if you generate a
			password where the count for the item (v) in Step 6 f) is non-zero. Your program’s output must be
			formatted as given below (you can use the Sting.format() method). Two examples to follow:
			You should divide your program into methods and provide JUnit testing for all of them.
			Explanation of the highlighted line in the output above:
			Before the valid password Whiteonce;the was generated, there were 3 passwords with a newline
			character generated; one whose length was not within the requested limits; 4 that did not have an upper
			case letter; and 1 that did not have a special character. Also, 10,000 passwords were generated as there
			was never a password generated with no lower case letters in it.	*/
	
	public static void main(String[] args) {
		final String[][][] book = {
				{
					{"ALICE was beginning to get very tired of sitting by her sister on the\n",
						"bank, and of having nothing to do. Once or twice she had peeped into the\n",
						"book her sister was reading, but it had no pictures or conversations in\n",
						"it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n",
					"conversations?\"\n"},
					{"So she was considering in her OWN mind (as well as she could, for the\n",
						"day made her feel very sleepy and stupid), whether the pleasure of\n",
						"making a daisy-chain would be worth the trouble of getting up and\n",
						"picking the daisies, when suddenly a White Rabbit with pink eyes ran\n",
					"close by her.\n"},
					{"There was nothing so very remarkable in that, nor did Alice think it so\n",
						"very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
						"dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
						"out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
						"started to her feet, for it flashed across her mind that she had never\n",
						"before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
						"out of it, and, burning with curiosity, she ran across the field after\n",
						"it and was just in time to see it pop down a large rabbit-hole, under\n",
					"the hedge. In another moment, down went Alice after it!"}
				},
				{
					{"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n",
					"telescope!\"\n"},
					{"And so it was indeed! She was now only ten inches high, and her face\n",
						"brightened up at the thought that she was now the right size for going\n",
					"through the little door into that lovely garden.\n"},
					{"After awhile, finding that nothing more happened, she decided on going\n",
						"into the garden at once; but, alas for poor Alice! When she got to the\n",
						"door, she found she had forgotten the little golden key, and when she\n",
						"went back to the table for it, she found she could not possibly reach\n",
						"it: she could see it quite plainly through the glass and she tried her\n",
						"best to climb up one of the legs of the table, but it was too slippery,\n",
						"and when she had tired herself out with trying, the poor little thing\n",
					"sat down and cried.\n"},
					{"\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
						"sharply. \"I advise you to leave off this minute!\" She generally gave\n",
						"herself very good advice (though she very seldom followed it), and\n",
						"sometimes she scolded herself so severely as to bring tears into her\n",
					"eyes.\n"},
					{"Soon her eye fell on a little glass box that was lying under the table:\n",
						"she opened it and found in it a very small cake, on which the words \"EAT\n",
						"ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
						"Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
						"makes me grow smaller, I can creep under the door: so either way I'll\n",
					"get into the garden, and I don't care which happens!\"\n"},
					{"She ate a little bit and said anxiously to herself, \"Which way? Which\n",
						"way?\" holding her hand on the top of her head to feel which way she was\n",
						"growing; and she was quite surprised to find that she remained the same\n",
					"size. So she set to work and very soon finished off the cake."}
				},
				{
					{"The King and Queen of Hearts were seated on their throne when they\n",
						"arrived, with a great crowd assembled about them--all sorts of little\n",
						"birds and beasts, as well as the whole pack of cards: the Knave was\n",
						"standing before them, in chains, with a soldier on each side to guard\n",
						"him; and near the King was the White Rabbit, with a trumpet in one hand\n",
						"and a scroll of parchment in the other. In the very middle of the court\n",
						"was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
					"trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n"},
					{"The judge, by the way, was the King and he wore his crown over his great\n",
						"wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
					"(some were animals and some were birds) I suppose they are the jurors.\"\n"},
					{"Just then the White Rabbit cried out \"Silence in the court!\"\n"},
					{"\"HERALD! read the accusation!\" said the King."}
				}
		};
		
		PasswordGeneration passwordGeneration = new PasswordGeneration();
		int i = 0;
		
		boolean tryAgain = true;
		
		passwordGeneration = new PasswordGeneration();
		passwordGeneration.splittedBook(book);
		
		//Welcome Message
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------  Welcome for taking password validation  -------------------------------------------------");
		System.out.println();
		System.out.println();
		
		while(tryAgain) {
			passwordGeneration.getWord(book);
			passwordGeneration.validPassword();
			passwordGeneration.toString();
			if(i >= 100) {
				tryAgain = false;
				System.out.println();
				System.out.println("--------------------------------------------------------------  Thank You!  ---------------------------------------------------------------");
				System.exit(0);
			}
			else
				i++;
		}
	}
}
