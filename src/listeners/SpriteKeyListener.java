/*
 * Copyright (C) 2017 Carzuilha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.AnimatedSprite;

/**
 *
 * @author Carzuilha
 */
public class SpriteKeyListener implements KeyListener {
    
    //  The sprite that will receive the key listener.
    private final AnimatedSprite theSprite;
    
    /**
     *  Class constructor.
     * 
     * @param   _sprite     The sprite that will receive the key listener.
     */
    public SpriteKeyListener(AnimatedSprite _sprite) {
        this.theSprite = _sprite;
    }

    /**
     *  The event that will change the sprite position (and animation) each time 
     * an arrow key is pressed.
     * 
     * @param   ke          The key event (pressed key). 
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        
        //  Change the sprite position (if possible) accord with the pressed key.
        switch (ke.getKeyCode()) {
            
            case KeyEvent.VK_UP: 
                
                this.theSprite.moveTo(theSprite.getXCoord(), theSprite.getYCoord() - theSprite.getStep());
                
                if (!this.theSprite.getAnimation().equals(AnimatedSprite.WALK_UP)) {
                    this.theSprite.setAnimation(AnimatedSprite.WALK_UP);               
                }
                
                break;
                
            case KeyEvent.VK_DOWN: 
                
                this.theSprite.moveTo(theSprite.getXCoord(), theSprite.getYCoord() + theSprite.getStep());
                
                if (!this.theSprite.getAnimation().equals(AnimatedSprite.WALK_DOWN)) {
                    this.theSprite.setAnimation(AnimatedSprite.WALK_DOWN);               
                }
                
                break;
                 
            case KeyEvent.VK_LEFT: 
                
                this.theSprite.moveTo(theSprite.getXCoord() - theSprite.getStep(), theSprite.getYCoord());
                
                if (!this.theSprite.getAnimation().equals(AnimatedSprite.WALK_LEFT)) {
                    this.theSprite.setAnimation(AnimatedSprite.WALK_LEFT);               
                }
                
                break;
        
            case KeyEvent.VK_RIGHT: 
                
                this.theSprite.moveTo(theSprite.getXCoord() + theSprite.getStep(), theSprite.getYCoord());
                
                if (!this.theSprite.getAnimation().equals(AnimatedSprite.WALK_RIGHT)) {
                    this.theSprite.setAnimation(AnimatedSprite.WALK_RIGHT);               
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
        
        //  Changes the standby sprite direction accord to the previous act.
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
     *  Just an empty method (needed for the abstract implementation). 
     * 
     * @param   ke          The key event (typed key). 
     */
    @Override
    public void keyTyped(KeyEvent ke) {
        // Not used yet.
    }
    
}
