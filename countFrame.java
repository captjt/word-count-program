
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * countFrame class for my Word Count program
 * @author Jordan Taylor
 */
public class countFrame extends JFrame{
    
    /**
     * Creates the string of text, the count variable
     * and the swing objects to put on a new subwindow for each file
     */
    private String text;
    private int count;
    private String filename;
    private JScrollPane pane;
    private JTextArea out;
    
    /**
     * Creates a constructor for the countFrame class
     * and calls the setUpFrame method
     * @param displayCount int to display the wordcount and passes it to the local variable count
     * @param textDisplay string to display the text in the file and passes it to the local variable text
     */
    public countFrame(int displayCount, String textDisplay, String s){
        text = textDisplay;
        count = displayCount;
        this.filename = s;
        this.setUpFrame();
    }
    
    /**
     * Method to set up the subwindow for each file
     * Creates a new frame and adds each component with select attributes for each
     */
    private void setUpFrame(){
        JFrame f = new JFrame();
        out = new JTextArea();
            
        out.setText("The word count for the file named '" + this.filename + "' is: " + this.count + "\n\nThe document itself contains: \n\n" + this.text);
        out.setLineWrap(true);
        out.setWrapStyleWord(true);
        out.setEditable(false);
            
        pane = new JScrollPane(out);
        
        f.add(pane);
        f.pack();
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(true);
    }
}
