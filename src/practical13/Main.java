package practical13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args){
        String filepath = "more.txt";

        String[] records = loadFileIntoArray(filepath);

        if ( records != null){
            System.out.println("Your message: ");
            for ( String word : records){
                System.out.println(word);
            }
        }
    }
    /**
     * Reads all lines from a file and returns them as a String array.
     * Handles file not found, empty file, and I/O errors.
     */
    public static String[] loadFileIntoArray(String filePath) {
        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Trim whitespace and skip empty lines
                line = line.trim();
                if (!line.isEmpty()) {
                    list.add(line);
                }
            }

            if (list.isEmpty()) {
                System.out.println("Warning: The file is empty or contains only blank lines.");
                return new String[0];
            }

        } catch (IOException e) {
            System.err.println("Error reading filee: " + e.getMessage());
            return null;
        }

        // Convert ArrayList to String array
        return list.toArray(new String[0]);
    }
}



