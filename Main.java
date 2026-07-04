import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    private static Set<String> wordset = new HashSet<>();
    private static Map<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Word Finder");
        System.out.println("==");
        System.out.print("Enter input file name");

        String inputFile = scanner.nextLine().trim();

        try {

            long start = System.currentTimeMillis();

            List<String> words = Files.readAllLines(Paths.get(inputFile));
            wordset.addAll(words);
            words.sort((a, b) -> Integer.compare(b.length(), a.length()));

            String longestCompoundWord = "";
            String secondLongestCompoundWord = "";

        
            for (String word : words) {

                if (isCompoundWord(word, true)) {

                    if (longestCompoundWord.isEmpty()) {
                        longestCompoundWord = word;
                    } else {
                        secondLongestCompoundWord = word;
                        break;
                    }
                }
            }
            long finish = System.currentTimeMillis();
            System.out.println(" Result-");
            System.out.println("Longest Compound Word" + longestCompoundWord);
            System.out.println("Second Longest Compound Word: " + secondLongestCompoundWord);
            System.out.println("Time Taken:" + (finish - start) + " ms");

        } catch (IOException e) {
            System.out.println("\nError: File not found!");
            System.out.println("Please make sure the file exists in the same folder.");
        }

        scanner.close();
    }

    private static boolean isCompoundWord(String word, boolean firstCall) {

        if (!firstCall && memo.containsKey(word)) {
            return memo.get(word);
        }

        for (int i = 1; i < word.length(); i++) {

            String left = word.substring(0, i);
            String right = word.substring(i);

            if (wordset.contains(left)) {

                if (wordset.contains(right) || isCompoundWord(right, false)) {

                    if (!firstCall) {
                        memo.put(word, true);
                    }

                    return true;
                }
            }
        }

        if (!firstCall) {
            memo.put(word, false);
        }

        return false;
    }
}