import java.util.*;

public class w2q5 {

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        feedback = feedback.toLowerCase();

        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            boolean isStopWord = false;

            for (int j = 0; j < stopWords.length; j++) {
                if (words[i].equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                frequency.put(words[i],
                        frequency.getOrDefault(words[i], 0) + 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> a,
                               Map.Entry<String, Integer> b) {

                return b.getValue() - a.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}