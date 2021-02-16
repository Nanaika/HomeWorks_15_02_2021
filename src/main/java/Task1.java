import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

    private static ArrayList<String> stringList = new ArrayList<String>();


    public static void main(String[] args) {

        while (stringList.size() < 10) {
            Scanner scanner = new Scanner(System.in);
            stringList.add(scanner.nextLine());
        }

        long averageLength = arithmeticMean();

        for (String str : stringList) {
            if (str.length() < averageLength) {
                System.out.println(str + "\n" + "length is " + str.length());
            }
        }

    }
    private static long arithmeticMean() {

        long totalLength = 0;
        for (String str : stringList) {
            totalLength += str.length();
        }
        return totalLength / stringList.size();
    }
}
