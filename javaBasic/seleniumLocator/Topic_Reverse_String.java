package seleniumLocator;

public class Topic_Reverse_String {

	public static void main(String[] args) {
		String originalWord = "Gecko driver";
		String reverseWord = "";
		char ch;

		System.out.println("Original words: " + originalWord);

		for (int i = 0; i < originalWord.length(); i++) {
			ch = originalWord.charAt(i);
			reverseWord = ch + reverseWord;
		}

		System.out.println("Reverse  words: " + reverseWord);
	}

}
