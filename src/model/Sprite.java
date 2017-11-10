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

/**
 *
 * @author Carzuilha
 */
public abstract class Sprite {
    
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
        return this.xCoord;
    }
    
    /**
     *  Returns the Y coordinate of the sprite (specifically the upper left 
     * corner).
     * 
     * @return  The Y coordinate of the sprite.      
     */
    public double getYCoord() {
        return this.yCoord;
    }
    
    /**
     *  Returns the max possible X coordinate of the sprite (specifically the 
     * upper left corner).
     * 
     * @return  The max X coordinate of the sprite.      
     */
    public double getMaxX() {
        return this.xMax;
    }
    
    /**
     *  Returns the max possible Y coordinate of the sprite (specifically the 
     * upper left corner).
     * 
     * @return  The max Y coordinate of the sprite.      
     */
    public double getMaxY() {
        return this.yMax;
    }
            
    /**
     *  Sets a new location for the sprite (between the possible boundaries), 
     * changing his coordinates.
     * 
     * @param   _x          The new X coordinate for the sprite.
     * @param   _y          The new Y coordinate for the sprite.
     */
    public void moveTo(double _x, double _y) {
    
        if (_x >= 0 && _x <= this.xMax) {
            this.xCoord = _x;
        }
        
        if (_y >= 0 && _y <= this.yMax) {
            this.yCoord = _y;
        }
    
    }
    
    /**
     *  Sets the highest possible position for the sprite in the drawable component.
     * 
     * @param   _x          The highest X coordinate possible for the sprite.
     * @param   _y          The highest Y coordinate possible for the sprite.
     */
    public void setMaxPosition(double _x, double _y) {
        this.xMax = _x;
        this.yMax = _y;
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
