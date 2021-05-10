public class ProblemOne {

    // Main method
    public static String getMissingLetters(String input) {
        // Initial variable declarations
        // Boolean used for validation of string
        // String of alphabet that will be incrementally stripped of letters found
        boolean isValid;
        String alph  = "abcdefghijklmnopqrstuvwxyz";

        // Quick check if empty string given, return whole alphabet
        if (input.length() == 0)
            return  alph;

        // Replaces all spaces with empty space and sets it to lower case
        input = input.replaceAll(" ", "");
        input = input.toLowerCase();

        // Converting input array to char array for ease of looping
        char[] charArray = input.toCharArray();

        for (char c: charArray) {
            // If the array contains a letter between a-z AND 'alph' contains that character
            // isValid is true, otherwise, false
            isValid = (((c >= 'a') && (c <= 'z')) && alph.contains(String.valueOf(c)));

            // If isValid is true, replace the character with a blank space to signify that
            // the letter has appeared and no longer needs to be included in the final output
            if (isValid)
                alph = alph.replaceAll(String.valueOf(c), "");

            // If length of alph goes to 0, all letter found.
            // There is no need to continue the loop, so break and return alph (which is a blank string)
            if (alph.length() == 0)
                break;
        }

        return alph;
    }

    public static void main(String args[]) {
        System.out.println(getMissingLetters("A quick brown fox jumps over the lazy dog"));
        System.out.println(getMissingLetters("A slow yellow fox crawls under the proactive dog"));
        System.out.println(getMissingLetters("Lions, and tigers, and bears, oh my!"));
        System.out.println(getMissingLetters(""));
    }


}
