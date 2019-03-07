package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.AnimatedSprite;

/**
 *  Defines a custom key listener for the application. This listener activates
 * the sprite movement.
 * 
 * @author     Carlos de Carvalho (Carzuilha)
 */
public class SpriteKeyListener implements KeyListener {
    
    //  The sprite that will receive the key listener.
    private final AnimatedSprite theSprite;
    
    /**
     *  Creates a new instance of the object.
     * 
     * @param   _sprite     The sprite that will receive the key listener.
     */
    public SpriteKeyListener(AnimatedSprite _sprite) {
        theSprite = _sprite;
    }

    /**
     *  The event that will change the sprite position (and animation) each time 
     * an arrow key is pressed.
     * 
     * @param   ke          The key event (pressed key). 
     */
    @Override
    public void keyPressed(KeyEvent ke) {

        switch (ke.getKeyCode()) {
            
            case KeyEvent.VK_UP: 
                
                theSprite.moveTo(theSprite.getXCoord(), theSprite.getYCoord() - theSprite.getStep());
                
                if (!theSprite.getAnimation().equals(AnimatedSprite.WALK_UP)) {
                    theSprite.setAnimation(AnimatedSprite.WALK_UP);               
                }
                
                break;
                
            case KeyEvent.VK_DOWN: 
                
                theSprite.moveTo(theSprite.getXCoord(), theSprite.getYCoord() + theSprite.getStep());
                
                if (!theSprite.getAnimation().equals(AnimatedSprite.WALK_DOWN)) {
                    theSprite.setAnimation(AnimatedSprite.WALK_DOWN);               
                }
                
                break;
                 
            case KeyEvent.VK_LEFT: 
                
                theSprite.moveTo(theSprite.getXCoord() - theSprite.getStep(), theSprite.getYCoord());
                
                if (!theSprite.getAnimation().equals(AnimatedSprite.WALK_LEFT)) {
                    theSprite.setAnimation(AnimatedSprite.WALK_LEFT);               
                }
                
                break;
        
            case KeyEvent.VK_RIGHT: 
                
                theSprite.moveTo(theSprite.getXCoord() + theSprite.getStep(), theSprite.getYCoord());
                
                if (!theSprite.getAnimation().equals(AnimatedSprite.WALK_RIGHT)) {
                    theSprite.setAnimation(AnimatedSprite.WALK_RIGHT);               
                }
                
                break;
            
            default: break;            
        
        }
        
    }

    /**
     *  The event that will change the sprite position to standby when the key 
     * was released. 
     *
     * @param   ke          The key event (released key). 
     */
    @Override
    public void keyReleased(KeyEvent ke) {

        switch (ke.getKeyCode()) {
            
            case KeyEvent.VK_UP:
                theSprite.setAnimation(AnimatedSprite.STOP_UP);
                break;
            
            case KeyEvent.VK_DOWN:
                theSprite.setAnimation(AnimatedSprite.STOP_DOWN);
                break;
            
            case KeyEvent.VK_LEFT:
                theSprite.setAnimation(AnimatedSprite.STOP_LEFT);
                break;
            
            case KeyEvent.VK_RIGHT:
                theSprite.setAnimation(AnimatedSprite.STOP_RIGHT);
                break;
            
            default: break;
        
        }
        
    }
    
    /**
     *  Just an empty method (required by the abstract implementation). 
     * 
     * @param   ke          The key event (typed key). 
     */
    @Override
    public void keyTyped(KeyEvent ke) {
        // Do nothing.
    }
    
}
