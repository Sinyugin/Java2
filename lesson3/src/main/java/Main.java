
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String[] words = " Набор произвольных слов которые могут повторятся в тексте.Набор набор могут слов набор в в в слов.".toLowerCase().split("[\\p{Space}\\p{Punct}]+");
        final List<String> wordList = Arrays.asList(words);
        final Set<String> uniqueWord = new HashSet<>(wordList);

        long start = System.currentTimeMillis();

        for (String word : uniqueWord){
            final int count = Collections.frequency(wordList, word);
        }
        System.out.println("n * n: " + (System.currentTimeMillis() - start));

        Map<String, Integer> map = new HashMap<>((int) (wordList.size() * 1.25));
        for (String s : wordList) {
            int count = map.getOrDefault(s, 0) + 1;
            map.put(s, count);
        }
        map.forEach((k, v)-> System.out.println("Слово " + k + " встретилось " + v));

    }
//    private static String generateWord(){
//    final byte[] bytes = new byte[7];
//    new Random().nextBytes(bytes);
//    return new String(bytes, StandardCharsets.UTF_8);
//    }
}


