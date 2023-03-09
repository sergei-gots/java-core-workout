package pro.sky.java.course_1.exam;

import pro.sky.java.util.Homework;

import static java.lang.System.out;

public class PalindromeService implements Homework {
    public static final String Panama = "A man, a plan, a canal: Panama!";
    public static final String Panama1 = "A man, a plan, a channel: Panama!";
    public static final String palindromeOfVelimirKhlebnikov = "Мороз в узел, лезу взором.";
    public static void main(String[] args) {
        PalindromeService palindromeService = new PalindromeService();
        palindromeService.homework();
    }

    @Override
    public void homework() {
        out.println("Exam.task \"Palindrome\"\n");

        checkAndShowIfItIsPalindrome(Panama);
        checkAndShowIfItIsPalindrome(Panama1);
        checkAndShowIfItIsPalindrome(palindromeOfVelimirKhlebnikov);
        checkAndShowIfItIsPalindrome("123a321");
        checkAndShowIfItIsPalindrome(",.,.,.,a..,.,.,.!");
        checkAndShowIfItIsPalindrome(",.,.,.,a..a,.,.,.!");
        checkAndShowIfItIsPalindrome(",.,.,.,a.a.b,.,.,.!");
        checkAndShowIfItIsPalindrome(",.,.,.,a.b.a,.,.,.!");

        out.println("So... Have a nice day!:)\n");

    }
    public void checkAndShowIfItIsPalindrome(String exp) {
        boolean isPalindrome = isPalindrome(exp);
        out.println("The expression \"" + exp +
                ((isPalindrome) ? " is a palindrome!:)\n" : " is not a palindrome:(\n"));
    }

    public boolean isPalindrome(String exp) {
        out.println("Now we check if an expression is palindrome or not.");
        out.println("The expression is: \"" + exp + "\".");
        String reducedExp = exp.replaceAll("(\\s+)|([.,!?:;'\\\"\\'-])", "").toLowerCase();
        out.println("The expression after removing spaces and punctuation and reduced to lower case: \"" +
                reducedExp    + "\".");
        if (reducedExp.length() < 2) {
            return true;
        }
        for (int i = 0; i <= reducedExp.length()/2 + reducedExp.length()%2 ; i++) {
            if (reducedExp.charAt(i) != reducedExp.charAt(reducedExp.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
