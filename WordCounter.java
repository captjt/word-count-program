
import java.io.File;
import java.util.ArrayList;

/**
 * WordCounter class in my Word Count program
 * @author Jordan Taylor
 */
public class WordCounter {
    
    /**
     * Creates my file and my string of text and filename
     */
    private File f;
    private String text;
    private String filename;
    
    /**
     * Creates the constructor for the WordCounter class
     * sets text equal to the String passed when it is called
     * then calls the getFiles() method in the class
     * @param s 
     */
    public WordCounter(String s){
        this.text = s;
        this.filename = s;
        this.getFiles();
    }
    
    /**
     * Method to get the files
     * and start a thread for each file entered
     */
    private void getFiles(){
        //System.out.println("I got here");
        if(this.text.equals("")){
            //System.out.println("You entered an invalid file name.");
            return;
        }
        else{
            f = new File(this.text);
            Thread thread = new Thread(new MyRunnable(f, this.filename));
            thread.start();
        }
    }
        
}
