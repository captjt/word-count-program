
import java.io.File;
import java.util.Scanner;
/**
 * MyRunnable class for my Word Count Program
 * This class implements Runnable
 * @author Jordan Taylor
 */
public class MyRunnable implements Runnable{

    /**
     * Creates my values to pass the text in the files
     *   the word count of the files
     * Also, creates the scanner for the file
     *   and the file itself
     */
    private String output;
    private String filename;
    private int wordCount;
    private Scanner scanLines;
    private File file;
    
    /**
     * Creates the constructor of MyRunnable class
     * sets the output to nothing
     * sets word count to 0
     * Then tries to scan the file for words if not found alerts you.
     * @param f passes the file to the local file variable
     */
    public MyRunnable(File f, String s){
        this.file = f;
        this.filename = s;
        this.output = "";
        this.wordCount = 0;
        
        try{
            this.scanLines = new Scanner(this.file);
        }
        catch(Exception e){
            new countFrame(0, "This file does not exist please close the window and enter a valid file name.", this.filename);
            //System.out.println("File is invalid.");
        }
    }
    
    /**
     * Method to run the process
     */
    public void run() {
        /**
         * While loop to go through the file while the file has something to scan
         * Then adds the text to output to pass it at the end
         */
        while(scanLines.hasNext()){
            this.output += scanLines.nextLine() + "\n";
            //System.out.print(output);
        }
            
        /**
         * Creates a new scanner to get the word count of the output String
         */
        Scanner wordCounter = new Scanner(this.output);
            
        while(wordCounter.hasNext()){
            wordCounter.next();
            this.wordCount++;
        }
        
        /**
         * Calls a new countFrame while passing wordcount and output to it
         */
        new countFrame(this.wordCount, this.output, this.filename);
    }    
}
