package resources;

import java.awt.Color;
import java.awt.image.BufferedImage;
import libraries.ImageTools;
import model.AnimatedSprite;
import view.MainFrame;

/**
 *  This class is used to load a sprite of the application. Splitting the sprite
 * loading in a separated class gives a better maintenance to the code.
 * 
 * @author  Carlos de Carvalho (Carzuilha)
 */
public class SpriteBuilder {
    
    /**
     *  Returns a preset sprite of Mario. 
     * 
     * @return  A sprite of Mario.
     */    
    public static AnimatedSprite createMario() {
        
        BufferedImage image = 
            ImageTools.makeTransparent(
                    "src\\resources\\Mario.png", 
                    new Color(0, 115, 0)
            );

        BufferedImage[] images = ImageTools.split(image, 6, 4);
        
        AnimatedSprite sprite = new AnimatedSprite(images, 10);

        sprite.addNewAnimation(AnimatedSprite.WALK_UP, new int[] { 3, 4, 5 });
        sprite.addNewAnimation(AnimatedSprite.WALK_RIGHT, new int[] { 9, 10, 11 });
        sprite.addNewAnimation(AnimatedSprite.WALK_DOWN, new int[] { 15, 16, 17 });
        sprite.addNewAnimation(AnimatedSprite.WALK_LEFT, new int[] { 21, 22, 23 });
        
        sprite.addNewAnimation(AnimatedSprite.STOP_UP, new int[] { 4, 4, 4 });
        sprite.addNewAnimation(AnimatedSprite.STOP_RIGHT, new int[] { 10, 10, 10 });
        sprite.addNewAnimation(AnimatedSprite.STOP_DOWN, new int[] { 16, 16, 16 });
        sprite.addNewAnimation(AnimatedSprite.STOP_LEFT, new int[] { 22, 22, 22 });
        
        sprite.setMaxPosition(
            MainFrame.PANEL_SIZE.width - sprite.getFrameWidth(),
            MainFrame.PANEL_SIZE.height - sprite.getFrameHeight()
        );
        
        sprite.moveTo(
            MainFrame.PANEL_SIZE.width * .5, 
            MainFrame.PANEL_SIZE.height * .5
        );
        
        sprite.setAnimation(AnimatedSprite.STOP_DOWN);
        
        return sprite;
        
    }
    
}
