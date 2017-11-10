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
package libraries;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Josiah Hester
 * @author Carzuilha
 */
public class ImageTool {
    
    /**
     *  Load an image from a file.
     * 
     * @param   _path       The image path on the computer.
     * @return  The loaded image (or null if fails).
     */
    public static BufferedImage loadImage(String _path ){
 
        //  Tries to load an image from the file path; returns null if fails.
        try { 
            return ImageIO.read(new File(_path));
        } catch (IOException e) {
            return null;
        }
    
    }
    
    /**
     *  Makes a certain color in a image transparent.
     * 
     * @param   _path       The image path on the computer.
     * @param   _color      The color that will be replaced.
     * @return  The loaded image with the transparent color.
     */
    public static BufferedImage makeColorTransparent(String _path, Color _color) {
        
        //  Tries to load an image from the file path...
        BufferedImage image = loadImage(_path);
        BufferedImage dimg = 
                new BufferedImage(image.getWidth(), image.getHeight(), 
                                  BufferedImage.TYPE_INT_ARGB);

        //  ...replaces the inputted color with the transparency...
        Graphics2D g = dimg.createGraphics();
        
        g.setComposite(AlphaComposite.Src);
        g.drawImage(image, null, 0, 0);
        g.dispose();
        
        for(int i = 0; i < dimg.getHeight(); i++) {
            for(int j = 0; j < dimg.getWidth(); j++) {
                if(dimg.getRGB(j, i) == _color.getRGB()) {
                    dimg.setRGB(j, i, 0x8F1C1C);
                }
            }
        }
        
        //  ...and returns the edited image.
        return dimg;
        
    }
    
    /**
     *  Splits an image into parts. The image will be splitted up by the number 
     * of rows and columns given.
     * 
     * @param   _image      The loaded image. 
     * @param   _cols       The number of columns used to split the image.
     * @param   _rows       The number of rows used to split the image.
     * @return  An array that contains all the "pieces" of the original image.
     */
    public static BufferedImage[] splitImage(BufferedImage _image, int _cols, int _rows) {
        
        //  Initialize the parameters used in the split...
        int w = _image.getWidth()/_cols;
        int h = _image.getHeight()/_rows;
        int num = 0;
        
        //  ...splits the image in an array of sub-images...
        BufferedImage imgs[] = new BufferedImage[w*h];
        
        for(int y = 0; y < _rows; y++) {            
            for(int x = 0; x < _cols; x++) {
            
                imgs[num] = new BufferedImage(w, h, _image.getType());

                Graphics2D g = imgs[num].createGraphics();
                
                g.drawImage(_image, 0, 0, w, h, w*x, h*y, w*x+w, h*y+h, null);
                g.dispose();
                
                num++;
            }            
        }
        
        //  ...and returns the image set.
        return imgs;
    
    }
    
}
