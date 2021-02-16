import java.util.ArrayList;
import java.util.List;

public class Task3 {


    private static String text = "Good Morning. how are you? are you fine, or good. good luck to you!fgfgfgfghfgfghfghfhgftgbcbbvb.    ghgytytytyyy     .";


    public static void main(String[] args) {


        ArrayList<String> sentence = (ArrayList<String>) extractSentence(text);
        for (int i = 0; i < sentence.size(); i++) {
            System.out.println(sentence.get(i));
        }

        whatMore(sentence);

    }

    private static List<String> extractSentence(String text) {

        List<String> sentenceList = new ArrayList<String>();

        String temp = "";
        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) != '.' && text.charAt(i) != '!' && text.charAt(i) != '?' && i != text.length() - 1) {

                temp += text.charAt(i);

            } else {
                temp += text.charAt(i);
                if (!temp.equals("")) {
                    int start = 0;
                    String tempS = "";
                    for (int z = 0; z < temp.length(); z++) {
                        if (temp.charAt(z) != ' ') {
                            start = z;
                            break;
                        }
                    }
                    for (int x = start; x < temp.length(); x++) {
                        tempS += temp.charAt(x);
                    }
                    sentenceList.add(tempS);
                    temp = "";
                }
            }
        }
        return sentenceList;
    }

    private static void whatMore(List<String> sentences) {

        int vowels = 0;
        int notVowels = 0;


        char[] vowelsChars = {'a', 'e', 'y', 'u', 'i', 'o', 'ы', 'э', 'ё', 'ю', 'я', 'и'};

        for (int i = 0; i < sentences.size(); i++) {

            for (int j = 0; j < sentences.get(i).length(); j++) {

                if (sentences.get(i).charAt(j) == ' ' || sentences.get(i).charAt(j) == ','
                        || sentences.get(i).charAt(j) == '.' || sentences.get(i).charAt(j) == '!'
                        || sentences.get(i).charAt(j) == '?') {
                    j++;
                } else {

                    for (int k = 0; k < vowelsChars.length; k++) {

                        if (sentences.get(i).charAt(j) == vowelsChars[k]) {
                            vowels++;
                            break;
                        }
                        if (k == vowelsChars.length - 1 && sentences.get(i).charAt(j) != k) {
                            notVowels++;
                        }
                    }
                }
            }

            if (vowels > notVowels) {
                System.out.println("vowels more");
            }
            if (vowels < notVowels) {
                System.out.println("notvowels more");
            }
            if (vowels == notVowels) {
                System.out.println("parity");
            }
            vowels = 0;
            notVowels = 0;
        }
    }
}


