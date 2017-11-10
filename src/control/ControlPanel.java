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
package control;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import model.AnimatedSprite;
import libraries.ImageTool;
import view.MainFrame;

/**
 *
 * @author Carzuilha
 */
public class ControlPanel extends JPanel {
       
    //  The project path which contains the Mario spritesheet.
    public static final String SPRITE_PATH = "img\\mario.png";
    public static final String BACKGR_PATH = "img\\background.png";
    
    //  The colors used in the sprite animation. The first is the color that will
    // be made transparent into the sprite; the second is the background color.
    public static final Color SPRITE_BCKGRND = new Color(0, 115, 0);
    public static final Color SCENARIO_BCKGND = new Color(102, 255, 102);
    
    //  The size of each step of the sprite on the screen (on pixels).
    public static final int SPRITE_STEP = 10;
    
    //  The gap that needs to be removed between frame and panel.
    public static final int WINDOW_GAP = 30;
    
    //  The number of rows and columns used to split the Mario spritesheet.
    public static int MARIO_COLS = 6;
    public static int MARIO_ROWS = 4;
    
    //  The sprite object (see the AnimatedSprite class for details).
    private AnimatedSprite animatedSprite;
    
    //  The background of the scene.
    private BufferedImage theBackground;
    
    /**
     *  Class constructor.
     * 
     */
    public ControlPanel() {
        
        super();
        
        //  Set the size and location of the panel.
        this.setSize(MainFrame.PANEL_WIDTH, MainFrame.PANEL_HEIGHT - WINDOW_GAP);
        this.setLocation(0, 0);
      
        //  Load the sprite and the background into the Panel object (but not 
        // yet on screen.
        this.loadSprite();
        this.loadBackground();
        
    }
        
    /**
     *  Initialize the sprite(s) into the Panel object.
     * 
     */
    private void loadSprite() {
        
        //  Loads and splits the spritesheet...
        BufferedImage img = ImageTool.makeColorTransparent(SPRITE_PATH, SPRITE_BCKGRND);
        BufferedImage[] imgs = ImageTool.splitImage(img, 6, 4);

        //  ...initialize the sprite(s) inside the Panel object...
        this.animatedSprite = new AnimatedSprite(imgs, SPRITE_STEP);
        
        //  ...adds the animation(s) inside the AnimatedSprite object(s)...
        this.animatedSprite.addNewAnimation(AnimatedSprite.WALK_RIGHT, new int[] { 9, 10, 11 });
        this.animatedSprite.addNewAnimation(AnimatedSprite.STOP_RIGHT, new int[] { 10, 10, 10 });
        this.animatedSprite.addNewAnimation(AnimatedSprite.WALK_LEFT, new int[] { 21, 22, 23 });
        this.animatedSprite.addNewAnimation(AnimatedSprite.STOP_LEFT, new int[] { 22, 22, 22 });
        this.animatedSprite.addNewAnimation(AnimatedSprite.WALK_DOWN, new int[] { 15, 16, 17 });
        this.animatedSprite.addNewAnimation(AnimatedSprite.STOP_DOWN, new int[] { 16, 16, 16 });
        this.animatedSprite.addNewAnimation(AnimatedSprite.WALK_UP, new int[] { 3, 4, 5 });
        this.animatedSprite.addNewAnimation(AnimatedSprite.STOP_UP, new int[] { 4, 4, 4 });
                
        //  ...set the highest possible position for the sprite, its initial 
        // coordinates...
        this.animatedSprite.setMaxPosition(this.getWidth() - this.animatedSprite.getFrameWidth(), 
                                           this.getHeight() - this.animatedSprite.getFrameHeight());
        this.animatedSprite.moveTo(0, 0);
        
        //  ...and sets the initial animation of the AnimatedSprite object(s).
        this.animatedSprite.setAnimation(AnimatedSprite.STOP_DOWN);
        
    }
    
    /**
     *  Initialize the background into the Panel object.
     * 
     */
    private void loadBackground() {        
        this.theBackground = ImageTool.loadImage(BACKGR_PATH);
    }

    /**
     *  Returns the AnimatedSprite object from the panel.
     * 
     * @return  The animated sprite from the panel.
     */
    public AnimatedSprite getAnimatedSprite() {
        return this.animatedSprite;
    }
    
    /**
     *  OVERRIDE: Paint the panel in the screen.
     * 
     * @param grphcs        The graphics of the panel.
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        
        super.paintComponent(grphcs);
        
        //  Draws the background image...
        grphcs.drawImage(this.theBackground, 0, 0, null);
        
        //  ...draws the animated sprite...
        this.animatedSprite.draw((Graphics2D) grphcs);
        
        // ...and dispose the Graphics object.
        grphcs.dispose();
        
    }
       
}
