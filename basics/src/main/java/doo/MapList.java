package doo;

import java.util.*;

public class MapList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> occurrences = new HashMap<>();
        List<String> words = new ArrayList<>();

        String word;
        do {
            word = scanner.nextLine();
            words.add(word);
            occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
        } while (!word.isBlank());


        words.stream().map(e -> e.concat(" ")).forEach(System.out::println);
        new TreeSet<>(words).stream().map(e -> e.concat(" ")).forEach(System.out::println);
    }
}
