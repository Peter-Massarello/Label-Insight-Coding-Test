public class ProblemOne {

    /* Getting Letters Method
        - Declares two variables, a boolean to check if current character is a valid char
          and a String that contains the whole alphabet which will be incrementally chipped off as program runs
        - Takes input string and removes whitespace and sets to lowercase
        - Sets new input String to char array for ease of looping
        - Iterates through char array and if an alpha char is found AND the 'alph' String contains that character
          then remove that char from the final string, since that letter has been found
        - If the length of the 'alph' String reaches 0, break out of loop and return String. This is used for
          early terminations where the input string is very long, but midway through the entire alphabet has been found
     */
    public static String getMissingLetters(String input) {
        boolean isValid;
        String alph  = "abcdefghijklmnopqrstuvwxyz";

        // Quick check if empty string given, return whole alphabet
        if (input.length() == 0)
            return alph;

        input = input.replaceAll(" ", "");
        input = input.toLowerCase();

        char[] charArray = input.toCharArray();

        for (char c: charArray) {
            isValid = (((c >= 'a') && (c <= 'z')) && alph.contains(String.valueOf(c)));

            if (isValid)
                alph = alph.replaceAll(String.valueOf(c), "");

            if (alph.length() == 0)
                break;
        }

        return alph;
    }

    // Main method
    public static void main(String[] args) {
        System.out.println(getMissingLetters("A quick brown fox jumps over the lazy dog"));
        System.out.println(getMissingLetters("A slow yellow fox crawls under the proactive dog"));
        System.out.println(getMissingLetters("Lions, and tigers, and bears, oh my!"));
        System.out.println(getMissingLetters(""));
    }


}
