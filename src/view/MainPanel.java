package view;

import control.SpriteManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import libraries.ImageTools;
import model.GenericSprite;
import resources.SpriteBuilder;

/**
 *  Defines the main panel of the application, which contains the sprite list.
 * 
 * @author  Carlos de Carvalho (Carzuilha)
 */
public class MainPanel extends JPanel {
       
    // Defines the path of the sprites used by the application.
    public static final String BACKGR_PATH = "src\\resources\\Background.png";
    
    // Defines the default background color for each sprite.
    public static final Color SPRITE_BG = new Color(0, 115, 0);
    public static final Color SCENE_BG = new Color(102, 255, 102);
    
    // Used to avoid the sprite to exceed the panel boundaries.
    public static final int WINDOW_GAP = 30;
        
    // The panel background.
    private final BufferedImage theBackground;
    
    // Controls all the sprites of the application.
    private final SpriteManager spriteManager;
    
    /**
     *  Creates a new instance of the panel.
     */
    public MainPanel() {
        
        super();
        
        spriteManager = new SpriteManager();
        theBackground = ImageTools.load(BACKGR_PATH);
                
        initializeComponent();        
        loadSprites();        
    }
    
    /**
     *  Initializes all the panel resources.
     */
    private void initializeComponent() {
        
        setLocation(0, 0);
        setSize(MainFrame.PANEL_SIZE.width, MainFrame.PANEL_SIZE.height);
        
    }
        
    /**
     *  Loads the sprite(s) to be added into the panel.
     */
    private void loadSprites() {        
        spriteManager.addSprite(SpriteBuilder.createMario());
    }

    /**
     *  Returns the main AnimatedSprite of the application.
     * 
     * @return  The main animated sprite from the panel.
     */
    public GenericSprite getMainSprite() {
        return spriteManager.getMainSprite();
    }
    
    /**
     *  Override. Paints the panel in the screen.
     * 
     * @param   g           The graphics of the panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        g.drawImage(theBackground, 0, 0, null);

        spriteManager.draw((Graphics2D) g);
        
        g.dispose();
        
    }
       
}
