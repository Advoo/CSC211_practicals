package practical15;

import java.io.*;
import java.util.*;



public class Anagrams {

    public static void main(String[] args) throws IOException {
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
            String cleaned = cleanWord(w);
            if (!cleaned.isEmpty()) {
                cleanedWord.add(cleaned);
            }
        }


        //dictionary
        HashMap<String, ArrayList<String>> dict = new HashMap<>();
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

        //LaTex file generator
        String textFileName = "theAna.tex";
        try (PrintWriter out = new PrintWriter(new FileWriter(textFileName))) {
            out.println("\\documentclass{article}");
            out.println("\\begin{document}");
            out.println("\\section*{Anagrams found in Ulysses}");
            out.println("\\section*{By Advocate}");
            out.println("10 March 2026");
            out.println("\\begin{description}");


            for (Map.Entry<String, ArrayList<String>> entry : dict.entrySet()) {
                ArrayList<String> list = entry.getValue();
                if (list.size() >= 2) {
                    Collections.sort(list);
                    out.print("  \\item[" + entry.getKey() + "] ");
                    out.println(String.join(", ", list));
                }
            }

            out.println();
            out.println("\\end{description}");
            out.println("\\end{document}");
            System.out.println("LaTeX file '" + textFileName + "' generated.");
        } catch (IOException e) {
            System.err.println("Error writing LaTeX file: " + e.getMessage());
        }
    }


    /**
     * Remove punctuation except apostrophe, then lowercase
     */
    private static String cleanWord(String word) {
        // only letters and apostrophes
        String cleaned = word.replaceAll("[^a-zA-Z']", "");
        return cleaned.toLowerCase();
    }

    /**
     * Return alphabetically sorted characters of the word
     */
    private static String signature(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}






