package view;

import listeners.SpriteKeyListener;
import java.awt.Dimension;
import javax.swing.JFrame;
import model.AnimatedSprite;

/**
 *  Defines the main frame of the application.
 * 
 * @author  Carlos de Carvalho (Carzuilha)
 */
public class MainFrame extends JFrame {

    // The application title.
    public static String APP_TITLE = "Testing Sprites";             
    
    // Defines the dimensions of the frame.
    public static Dimension PANEL_SIZE = new Dimension(500, 500);   
    
    // Contains all the sprites of the application.
    private final MainPanel mainPanel;                                    
    
    /**
     *  Creates a new instance of the object.
     */
    public MainFrame() {
        
        super();
        
        mainPanel = new MainPanel();
        
        initializeComponent();
        addKeyListener();
    }
    
    /**
     *  Initializes all the frame resources.
     */
    private void initializeComponent() {

        setVisible(true);
        setSize(PANEL_SIZE);
        setTitle(APP_TITLE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        setContentPane(mainPanel);
    }
    
    /**
     *  Adds the key listener to the frame.
     */
    private void addKeyListener() {
        addKeyListener(
            new SpriteKeyListener((AnimatedSprite) mainPanel.getMainSprite())
        );
    }
    
}
