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
package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 *
 * @author Carzuilha
 */
public class AnimatedSprite extends Sprite {

    //  All the avaliable styles for the sprite animation.
    public static String WALK_RIGHT = "walk-right";
    public static String STOP_RIGHT = "stop-right";
    public static String WALK_LEFT  = "walk-left";
    public static String STOP_LEFT  = "stop-left";
    public static String WALK_DOWN  = "walk-down";
    public static String STOP_DOWN  = "stop-down";
    public static String WALK_UP    = "walk-up";
    public static String STOP_UP    = "stop-up";
    
    //  Store all the images for the sprite.
    private final BufferedImage[] theImages;

    //  Groups all the frames, hashed by a string key.
    private final HashMap<String, int[]> theFrames;

    //  Sets the size of the sprite step (on pixels).
    private final int stepSize;    

    //  Stores the current "state" of the sprite animation, the current frame 
    // being rendered and the current set of frames being rendered.
    private String currentAnim;
    private int currentFrame;
    private int[] currentFrameSet;
   
    //  Sets the loop direction. Up is true, down is false.
    private boolean loopDir;

    /**
     *  Class constructor.
     * 
     * @param   _images     The array that contains all the sprite images.
     * @param   _stepSize   The size of the sprite step.
     */
    public AnimatedSprite(BufferedImage[] _images, int _stepSize) {
        this.theFrames = new HashMap<>();
        this.theImages = _images;
        this.stepSize = _stepSize;
        this.loopDir = true;
        this.xCoord = 0;
        this.yCoord = 0;
    }
        
    /**
     *  Returns the size of the sprite step.
     * 
     * @return  The size of the step.
     */
    public int getStep() {
        return this.stepSize;
    }
    
    /**
     *  Returns the current animation of the sprite.
     * 
     * @return 
     */
    public String getAnimation() {
        return this.currentAnim;                
    }
    
    /**
     *  Set the current animation style for the sprite.
     * 
     * @param   _name       The new animation for the sprite.
     */
    public void setAnimation(String _name) {
        
        if(this.theFrames.containsKey(_name)) {
            this.currentAnim = _name;
            this.currentFrameSet = this.theFrames.get(currentAnim);
            this.currentFrame = 0;
        }
        
    }

    /**
     *  Adds a new animation to the sprite.
     * 
     * @param   _name       The name of the animation.
     * @param   _set        The set of frames used on the given animation.
     */
    public void addNewAnimation(String _name, int[] _set) {        
        this.theFrames.put(_name, _set);
        this.setAnimation(_name);    
    }
                
    /**
     *  OVERRIDE: Returns the width of a frame.
     * 
     * @return  The frame width.      
     */
    @Override
    public double getFrameWidth() {
        return this.theImages[0].getWidth();
    }
    
    /**
     *  OVERRIDE: Returns the height of a frame.
     * 
     * @return  The frame height.      
     */
    @Override
    public double getFrameHeight() {
        return this.theImages[0].getHeight();
    }
    
    /**
     *  OVERRIDE: Draws the sprite inside the panel.
     * 
     * @param   _g          The graphics that belongs to the panel.
     */
    @Override
    public void draw(Graphics2D _g) {

        //  Get the current frame for the framset...
        int imgNum = this.currentFrameSet[this.currentFrame];
        
        //  ...draws the frame on the graphics...
        _g.drawImage(this.theImages[imgNum], null, 
                     (int) this.xCoord, (int) this.yCoord);

        //  ...and reconfigure the frameset status.
        if (this.currentFrame == this.currentFrameSet.length - 1) {
            
            this.loopDir = false;
            this.currentFrame--;
        
        } else {
        
            if(this.currentFrame == 0) {
                this.loopDir = true;
            }
            
            if (this.loopDir) {
                this.currentFrame++;
            } else {
                this.currentFrame--;
            }
            
        }
       
    }
    
}
