package io.zipcoder;


import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

/**
 * @author tariq
 */
public class StringsAndThings {
    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        String evaluate = input;
        //Pattern pattern = Pattern.compile("[(z$)g|(y$)]\\b");
        Pattern pattern = Pattern.compile("[zy]\\b");
        Matcher matcher = pattern.matcher(evaluate);
        int count =0; //initialize counter
        while (matcher.find()){
            String match = matcher.group();
            count++;
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){

        return base.replaceAll("" + remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        String evaluate = input;
        //Pattern pattern = Pattern.compile("[(z$)g|(y$)]\\b");
        Pattern pattern1 = Pattern.compile("is");
        Matcher matcher1 = pattern1.matcher(evaluate);

        Pattern pattern2 = Pattern.compile("not");
        Matcher matcher2 = pattern2.matcher(evaluate);

        int countIs =0; //initialize counter
        int countNot =0;
        while (matcher1.find()){
//            String match1 = matcher1.group();
            countIs++;
        }
        while (matcher2.find()){
//            String match2 = matcher2.group();
            countNot++;
        }
        Boolean result = null;
        //use == for primitive types
        if (countIs == (countNot)){
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        for (int i = 0 ; i < input.length(); i++){
            // check index of string has g
            if (input.charAt(i) == 'g') {
                // check if index is greater than 0 and current char-1
                if ((i > 0 && input.charAt(i -1) == 'g') || (i < input.length() - 1 && input.charAt(i + 1) == 'g')){
                 continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        String evaluate = input;
        //Pattern pattern = Pattern.compile("[(z$)g|(y$)]\\b");
        Pattern pattern = Pattern.compile("([A-Za-z])\\1\\1");
        Matcher matcher = pattern.matcher(evaluate);
        int count =0; //initialize counter
        while (matcher.find()){
            String match = matcher.group();
            count++;
        }
        return count;
    }


}
