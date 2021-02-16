import java.util.ArrayList;
import java.util.List;

public class Task2 {


    private static String text = "Скорость входящего соединения влияет на то, как быстро открываются сайты и скачиваются файлы. Исходящее соединение используется при передаче данных с вашего компьютера в сеть — например, при отправке писем или загрузке фотографий в облако. Проверить скорость интернета вам поможет Яндекс.Интернетометр.";


    public static void main(String[] args) {

        ArrayList<String> names = (ArrayList<String>) extractWord(text);
        calcRepeats(names);


    }


    private static List<String> extractWord(String text) {

        ArrayList<String> wordsList = new ArrayList<String>();

        String temp = "";

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == '\n') {
                temp += "";
            }


            if (text.charAt(i) != ',' && text.charAt(i) != '.' && text.charAt(i) != '!'
                    && text.charAt(i) != '?' && text.charAt(i) != ' ') {
                if (i == text.length() - 1) {
                    temp += text.charAt(i);
                    wordsList.add(temp);
                }
                temp += text.charAt(i);
            } else {
                if (!temp.equals("")) {
                    wordsList.add(temp);
                    temp = "";
                }
            }
        }
        return wordsList;
    }


    private static void calcRepeats(List<String> words) {

        ArrayList<String> tempNamesList = new ArrayList<String>(words);
        int count = 0;

        for (int i = 0; i < tempNamesList.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (tempNamesList.get(i).equals(words.get(j))) {
                    count++;
                }
            }
            System.out.println(tempNamesList.get(i) + "\n" + "repeats " + count + " times\n");
            count = 0;
            String temp1 = tempNamesList.get(i);
            for (int j = 0; j < tempNamesList.size(); j++) {
                tempNamesList.remove(temp1);
            }
            i = -1;
        }

    }

}
