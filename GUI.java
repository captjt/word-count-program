
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.font.TextAttribute.FONT;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * GUI class for my Word Count Program
 * Establishes the user interface for the program
 * @author Jordan Taylor
 */
public class GUI extends JFrame {
    
    /**
     * Creates my java swing objects to put into my frame
     */
    private JTextArea textArea1;
    private JPanel panel;
    private JButton start;
    private JFrame frame;
    
    /**
     * Creates my array list of jtextfields
     */
    public ArrayList<JTextField> listText;
    
    /**
     * Creates my screen size and my screen location to start with
     */
    final private int x = 350;
    final private int y = 400;
    final private int screenX = 500;
    final private int screenY = 100;
    
    /**
     * Creates a constructor of my GUI class
     * and calls the setUpGUI() method in my class
     */
    public GUI(){
        this.setUpGUI();
    }
    
    /**
     * Method to set up the interface for the user
     * Creates new instances of my swing objects and 
     * declares values for each object as well as setting rules for each one
     * adds each textfield and button to the panel to add to the frame
     * creates action listener for the start button
     */
    public void setUpGUI(){        
        textArea1 = new JTextArea();
        listText = new ArrayList<JTextField>();
        panel = new JPanel();
        start = new JButton();
        
        textArea1.setText("       Enter your file names in each text field.\nYou must enter starting from the top text field.");
        textArea1.setEditable(false);
        textArea1.setBackground(Color.BLACK);
        textArea1.setForeground(Color.WHITE);
        panel.add(textArea1);
        
        for(int i=0;i<11;i++){
            listText.add(new JTextField(20));
            listText.get(i).setEditable(true);
            panel.add(listText.get(i));
        }
        
        start.setText("Start Counting");
        
        panel.add(start);
        
        frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setSize(x, y);
        frame.setLocation(screenX, screenY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        
        start.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    for(int i = 0; i < 11; i++){
                        if(listText.get(i).getText().equals("")){
                            return;
                        }
                        else{
                            //System.out.println("I got here!");
                            WordCounter count = new WordCounter(listText.get(i).getText());
                        }
                    }
                }
            });
    }    
}
