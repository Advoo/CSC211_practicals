package practical15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.classfile.Attributes.signature;

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

        List<String> cleanedWord = new ArrayList<>();
        for (String w : words) {
            String cleaned = cleanedWord(w);
            if (!cleaned.isEmpty()) {
                cleanedWord.add(cleaned);
            }
        }


        //dictionary
        HashMap<String, ArrayList<String> dict = new HashMap<>();
        for (String word : cleanedWord) {
            String sig = signature(word);
            dict.computeIfAbsent(sig, k -> new ArrayList<>()).add(word);

        }


    // Print anagram groups to console
        System.out.println("\nAnagram groups (size >= 2):");
        for (Map.Entry<String, ArrayList<String>> entry : dict.entrySet()) {
        ArrayList<String> list = entry.getValue();
        if (list.size() >= 2) {
            Collections.sort(list);
            System.out.println(entry.getKey() + " : " + list);
        }

    }
}




