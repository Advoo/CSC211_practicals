package practical15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println("Ana   ");

        String filename = "joyce1922_ulysses.text";
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                for (String token : tokens) {
                    if (!token.isEmpty()) {
                        words.add(token);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("Read " + words.size() + " raw words.");
    }

    private static String cleanWord(String word) {
        // Remove characters: . , ; : _ ! — -  (including -dash)
        // We keep letters, apostrophes, and possibly hyphens? The spec says leave apostrophes.
        // We'll remove everything except letters and apostrophes.
        String cleaned = word.replaceAll("[^a-zA-Z']", ""); // keep letters and '
        return cleaned.toLowerCase();
    }


    private static String signature(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    }




