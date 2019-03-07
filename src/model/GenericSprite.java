package model;

import java.awt.Graphics2D;

/**
 *  Defines a generic sprite. This class cannot be instanced alone.
 * 
 * @author      Carlos de Carvalho (Carzuilha)
 */
public abstract class GenericSprite {
    
    //  The coordinates of a sprite inside a panel (upper left).
    protected double xCoord = 0;
    protected double yCoord = 0;
    
    //  The max coordinates of a sprite inside a panel (upper left).
    protected double xMax = 0;
    protected double yMax = 0;
    
    /**
     *  Returns the X coordinate of the sprite (specifically the upper left 
     * corner).
     * 
     * @return  The X coordinate of the sprite.      
     */
    public double getXCoord() {
        return xCoord;
    }
    
    /**
     *  Returns the Y coordinate of the sprite (specifically the upper left 
     * corner).
     * 
     * @return  The Y coordinate of the sprite.      
     */
    public double getYCoord() {
        return yCoord;
    }
    
    /**
     *  Returns the max possible X coordinate of the sprite (specifically the 
     * upper left corner).
     * 
     * @return  The max X coordinate of the sprite.      
     */
    public double getMaxX() {
        return xMax;
    }
    
    /**
     *  Returns the max possible Y coordinate of the sprite (specifically the 
     * upper left corner).
     * 
     * @return  The max Y coordinate of the sprite.      
     */
    public double getMaxY() {
        return yMax;
    }
            
    /**
     *  Sets a new location for the sprite (between the possible boundaries), 
     * changing his coordinates.
     * 
     * @param   _x          The new X coordinate for the sprite.
     * @param   _y          The new Y coordinate for the sprite.
     */
    public void moveTo(double _x, double _y) {
    
        if (_x >= 0 && _x <= xMax) {
            xCoord = _x;
        }
        
        if (_y >= 0 && _y <= yMax) {
            yCoord = _y;
        }
    
    }
    
    /**
     *  Sets the highest possible position for the sprite in the drawable component.
     * 
     * @param   _x          The highest X coordinate possible for the sprite.
     * @param   _y          The highest Y coordinate possible for the sprite.
     */
    public void setMaxPosition(double _x, double _y) {
        xMax = _x;
        yMax = _y;
    }
    
    /**
     *  Returns the width of a frame.
     * 
     * @return  The frame width.      
     */
    public abstract double getFrameWidth();
    
    /**
     *  Returns the height of a frame.
     * 
     * @return  The frame height.      
     */
    public abstract double getFrameHeight();
    
    /**
     *  Draws the sprite inside a panel.
     * 
     * @param   _g          The graphics that belongs to the panel.
     */
    public abstract void draw(Graphics2D _g);
    
}
