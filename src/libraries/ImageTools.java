package libraries;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *  Contains a set of useful methods to work with images. These codes are based
 * on the sources given by Josiah Hester, and available on the following link:
 * <https://www.javalobby.org//articles/ultimate-image/>.
 * 
 * @author      Josiah Hester
 * @author      Carlos de Carvalho (Carzuilha).
 */
public class ImageTools {
    
    /**
     *  Loads an image from a file.
     * 
     * @param   _path       The image path.
     * @return  The corresponding image (or null if fails).
     */
    public static BufferedImage load(String _path ){
 
        //  Tries to load an image from the file path; returns null if fails.
        try { 
            return ImageIO.read(new File(_path));
        } catch (IOException e) {
            return null;
        }
    
    }
    
    /**
     *  Makes a specific color inside an image transparent.
     * 
     * @param   _path       The image path.
     * @param   _color      The color that will be replaced.
     * @return  The same input image, but with transparency.
     */
    public static BufferedImage makeTransparent(String _path, Color _color) {

        BufferedImage image = load(_path);
        BufferedImage dimg = 
                new BufferedImage(image.getWidth(), image.getHeight(), 
                                  BufferedImage.TYPE_INT_ARGB);

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

        return dimg;
        
    }
    
    /**
     *  Splits an image into parts. The image will be split up by the given number 
     * of rows and columns.
     * 
     * @param   _image      The loaded image. 
     * @param   _cols       The number of columns used to split the image.
     * @param   _rows       The number of rows used to split the image.
     * @return  An array that contains all the "pieces" of the original image.
     */
    public static BufferedImage[] split(BufferedImage _image, int _cols, int _rows) {
        
        int w = _image.getWidth()/_cols;
        int h = _image.getHeight()/_rows;
        int num = 0;

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

        return imgs;
    
    }
    
}
