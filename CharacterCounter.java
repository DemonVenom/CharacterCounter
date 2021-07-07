import java.io.IOException;
import java.io.*;
import java.util.Scanner;


public class CharacterCounter {

    public static int fileWords = 0;
    public static int fileLines = 1;
    public static int fileCharacters = 0;


    public CharacterCounter() {

        // Create new scanner object
        Scanner scnr = new Scanner(System.in);

        // Prompt the user to input the file
        System.out.print("Welcome to the Character, Word, and Line Counter\nEnter the name of the file you want to use (must be within program folder) or directory path \n(Windows: C:\\Users\\<folder path>\\<filename> or macOS: ~/folder>/<filename>)\n==================================================================\nType File Name then Press [Enter]: ");
        // Scan the next line and put it into string variable
        String userInput = scnr.nextLine();

        // Create try method to...
        try {

            // ...crate new FileReader object
            FileReader fr = new FileReader(userInput);

            // Call Counter method
            Counter(fr);

            // Close FileReader
            fr.close();
        }
        // Catch FileNotFoundException exception
        catch (FileNotFoundException fnfe) {

            // Set lines to 0
            fileLines = 0;
            // Prompt the user that the file operation failed
            System.out.println("File Does Not Exist, is not in the Program Folder, or Directory Path Address was not Entered Correctly");
        }
        // Catch input-output exception
        catch(IOException ie) {

            // Just return and do nothing else
            return;
        }

        // Print out results, ending on a newline
        System.out.printf("Characters: %d\nLines: %d\nWords: %d\n", fileCharacters, fileLines, fileWords);
    }


    // Create method to count characters, words, and lines

    public static void Counter(InputStreamReader inputStreamReader) throws IOException {

        // Create integer variable initialized at zero
        int character = 0;

        // Read each individual character from the file using the read() method
        // and until the file has ended (when it reaches -1)...
        while ((character = inputStreamReader.read()) != -1) {

            // Add one to the chars integer variable
            fileCharacters++;

            // On the condition that the read character is a new line...
            if (character =='\n') {

                // Add one to the integer variable lines
                fileLines++;
                // Debug the chars variables by subtracting 2
                fileCharacters = fileCharacters - 2;
            }

            // On the condition that the read character is a space, tab, new line, or form feed
            if (character == ' ' || character == '\t' || character == '\n' || character == '\f' ) {

                // Add one to the integer variable words
                ++fileWords;
            }


        }

    }


}