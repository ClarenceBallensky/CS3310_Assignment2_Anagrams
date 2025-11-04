/**
 * Clarence Ballensky
 * CS 3310.01, Fall 2025
 * Programming assignment 2: anagrams
 * ProcessText class: Parses through words in a given input file to identify if any of the words are anagrams of each other
 */

import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.Normalizer;
import java.util.Arrays;


public class ProcessText
{
    /**
     * Method: main
     * Purpose: parses through each word in the input file, groups all anagrams, saves the groups to an output file
     */
    public static void main (String[] args) {


        //makes sure that the filename is the only command line argument
        if (args.length != 1) {
            throw new IllegalArgumentException("Please ONLY provide a file name as a command line argument.");
        }

        //the String part stores the key, and stores the alphabetized version of a word
        //the List<String> part stores all words that match up with the key (all anagrams within that group)
        HashMap<String, List<String>> anagramGroups = new HashMap<>();

        File inputFile = new File(args[0]); //opens up the file specified in the command line


        //read the contents of the file
        try (Scanner sc = new Scanner(inputFile)) {
            while (sc.hasNextLine()) {
                String word = sc.nextLine().trim(); //stores one word from the input file
                if (word.isEmpty()) {
                    continue;
                }
                String sortedKey = sortCharacters(word); //sorted version of the given word

                if (!anagramGroups.containsKey(sortedKey)) //if the anagram group doesn't exist yet, make a new anagram group
                {
                    anagramGroups.put(sortedKey, new ArrayList<>());
                }
                anagramGroups.get(sortedKey).add(word);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found --> " + args[0]);
        }

        //creates output file
        String outputFilename = "C:\\Users\\prize\\IdeaProjects\\CS3310_Assignment2_Anagrams\\src\\main\\resources\\outputFile.txt";

        //prints contents to output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename)))
        {
            for ( List<String> group : anagramGroups.values())
            {
                if (group.size() > 1)
                {
                    Collections.sort(group);
                    String line =  String.join(", ", group); //comma-separates words in the anagram group

                    writer.write(line);
                    writer.newLine();
                }

            }

        }
        catch (IOException e)
        {
            System.err.println("Error writing to file: " + e.getMessage());
        }

    }

    /**
     * Method: sortCharacters
     * Purpose: normalize and ignore capitals for a given string, then sort it alphabetically and return the sorted string
     * @param word a given word from the input file
     * @return String(wordChars)
     */
    public static String sortCharacters(String word)
    {

        //normalizer decomposes accented characters into their base character + diacritical mark
        //e.g. "ä" becomes "a\u0308"
        String normalized = Normalizer.normalize(word, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("\\p{M}", ""); //remove diacritical marks
        normalized = normalized.replaceAll("[^\\p{IsAlphabetic}]", ""); //remove punctuation and special characters (leaves only letters)
        normalized = normalized.toLowerCase(); //make all characters lowercase

        char[] wordChars =  normalized.toCharArray(); //create a character array of each character in the word
        Arrays.sort(wordChars); //sort the characters from the word alphabetically
        return new String(wordChars); //return a new string of the alphabetically sorted characters from the word
    }
}


