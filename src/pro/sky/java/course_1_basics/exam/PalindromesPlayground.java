package pro.sky.java.course_1_basics.exam;

public class PalindromesPlayground {

    public static final char SYMBOL_PSI = 0x03C8;
    private static final String[] PALINDROMES = {
            "A man, a plan, a canal - Panama!:)",
            "saippuakivikauppias",
            "Ni" + SYMBOL_PSI + "on anomemata me monan o" + SYMBOL_PSI + "in",
            "Ein Esel lese nie",
            "Pluto - Tulp",
            "Мороз в узел, лезу взором",
            "This is not a palindrome:)"
    };

    public static void main(String[] args) {

        System.out.println("\nTicket 2: Palindromes\n");
        for (String exp: PALINDROMES
        ) {
            checkAndDisplayIfItIsPalindromeOrNot(exp);
        }
    }

    public static void checkAndDisplayIfItIsPalindromeOrNot(String exp) {
        System.out.println("Expression  \"" + exp + "\"" +
                ((isPalindrome(exp)) ? " is " : "\u001B[31m is not \u001B[0m") +
                "a palindrome.\n");
    }

    private static boolean isPalindrome(String exp) {

        String reduced = exp.
                replaceAll("(\\s+)|(!,?)|(:)|(;)|(\\))|(-)|(\\,)|(\\.)", "").
                toLowerCase();
        System.out.println("reduced = " + reduced);

        if (reduced.length() < 2 ) {
            return true;
        }

        for (int i = 0; i < reduced.length()/2; i++) {
            if (reduced.charAt(i) !=  reduced.charAt(reduced.length() - 1 -i)) {
                return false;
            }
        }

        return true;
    }
}
