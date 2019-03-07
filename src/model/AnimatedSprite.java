package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 *  Defines an animated sprite. An animated sprite must have animations for
 * movements/standby on four directions (up, down, left and right).
 * 
 * @author      Carlos de Carvalho (Carzuilha)
 */
public class AnimatedSprite extends GenericSprite {

    //  All the avaliable styles for the sprite animation.
    public static String WALK_RIGHT = "walk-right";
    public static String STOP_RIGHT = "stop-right";
    public static String WALK_LEFT  = "walk-left";
    public static String STOP_LEFT  = "stop-left";
    public static String WALK_DOWN  = "walk-down";
    public static String STOP_DOWN  = "stop-down";
    public static String WALK_UP    = "walk-up";
    public static String STOP_UP    = "stop-up";
    
    //  Sets the size of the sprite step (on pixels).
    private final int stepSize; 
    
    // The current frame of the sprite being rendered.
    private int currentFrame;
    
    // The current "state" of the sprite animation.
    private String currentAnim;
    
     //  Sets the loop direction. 'true' means up, 'false' means down.
    private boolean goingUp;
    
    //  Stores the current set of frames being rendered.        
    private int[] currentFrameSet; 
    
    //  Contains all the images for the sprite.
    private final BufferedImage[] theImages;

    //  Groups all the frames, hashed by a string key.
    private final HashMap<String, int[]> theFrames;       

    /**
     *  Creates a new instance of the object.
     * 
     * @param   _images     The array that contains all the sprite images.
     * @param   _stepSize   The size of the sprite step.
     */
    public AnimatedSprite(BufferedImage[] _images, int _stepSize) {
        
        theFrames = new HashMap<>();
        
        theImages = _images;
        stepSize = _stepSize;
        
        goingUp = true;
        
        xCoord = 0;
        yCoord = 0;
    }
        
    /**
     *  Returns the size of the sprite step.
     * 
     * @return  The size of the step.
     */
    public int getStep() {
        return stepSize;
    }
    
    /**
     *  Returns the current animation of the sprite.
     * 
     * @return  The current animation of the sprite.
     */
    public String getAnimation() {
        return currentAnim;                
    }
    
    /**
     *  Set the current animation style for the sprite.
     * 
     * @param   _name       The new animation for the sprite.
     */
    public void setAnimation(String _name) {
        
        if(theFrames.containsKey(_name)) {
            currentAnim = _name;
            currentFrameSet = theFrames.get(currentAnim);
            currentFrame = 0;
        }
        
    }

    /**
     *  Adds a new animation to the sprite.
     * 
     * @param   _name       The name of the animation.
     * @param   _set        The set of frames used on the given animation.
     */
    public void addNewAnimation(String _name, int[] _set) {        
        
        theFrames.put(_name, _set);
        
        setAnimation(_name);    
    }
                
    /**
     *  Override. Returns the width of a frame.
     * 
     * @return  The frame width.      
     */
    @Override
    public double getFrameWidth() {
        return (theImages.length > 0) ? theImages[0].getWidth() : 0 ;
    }
    
    /**
     *  Override. Returns the height of a frame.
     * 
     * @return  The frame height.      
     */
    @Override
    public double getFrameHeight() {
        return (theImages.length > 0) ? theImages[0].getHeight() : 0;
    }
    
    /**
     *  Override. Draws the sprite inside the panel.
     * 
     * @param   _g          The graphics that belongs to the panel.
     */
    @Override
    public void draw(Graphics2D _g) {

        int imgNum = currentFrameSet[currentFrame];

        _g.drawImage(theImages[imgNum], null, (int)xCoord, (int)yCoord);

        if (currentFrame == currentFrameSet.length - 1) {
            
            goingUp = false;
            currentFrame--;
        
        } else {
        
            if(currentFrame == 0) {
                goingUp = true;
            }
            
            if (goingUp) {
                currentFrame++;
            } else {
                currentFrame--;
            }
            
        }       
    }
    
}
