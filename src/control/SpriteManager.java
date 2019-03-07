package control;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import model.GenericSprite;

/**
 *  Controls the sprite list of the application.
 * 
 * @author  Carlos de Carvalho (Carzuilha)
 */
public class SpriteManager {
    
    // The list containing all the sprites of the application.
    private final List<GenericSprite> spriteList;
    
    /**
     *  Creates a new instance of the object.
     * 
     */
    public SpriteManager() {
        spriteList = new ArrayList<>();
    }
    
    /**
     *  Returns the mains sprite of the application (the controllable one).
     * 
     * @return  The main sprite of the application, or null if empty.
     */
    public GenericSprite getMainSprite() {
        return (spriteList.size() > 0) ? spriteList.get(0) : null ;
    }
    
    /**
     * 
     * @param   _sprite     The sprite to be added.
     */
    public void addSprite(GenericSprite _sprite) {
        
        if (_sprite != null) {
            spriteList.add(_sprite);
        } 
        
    }
    
    /**
     *  Draws the sprite list into a graphics.
     * 
     * @param   _g          The graphics to receive the sprite list.
     */
    public void draw(Graphics2D _g) {
        
        spriteList.forEach(sprite -> { 
            sprite.draw(_g); 
        });
        
    }
    
}
