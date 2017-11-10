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
package view;

import control.ControlPanel;
import listeners.SpriteKeyListener;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Carzuilha
 */
public class MainFrame extends JFrame {
    
    //  The title of the application.
    public static String APP_TITLE = "Mario using Keyboard";
    
    //  The width and the height of the frame on screen.
    public static int PANEL_WIDTH = 500;
    public static int PANEL_HEIGHT = 500;
    
    //  The main panel, where all the drawings will be represented.
    private final ControlPanel thePanel;
    
    /**
     *  Class constructor.
     * 
     */
    public MainFrame() {
        
        super();
        
        //  Makes the frame visible, non-resizeable and exiting on close...
        this.setTitle(APP_TITLE);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //  ...sets the panel size and background color...
        this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        this.setBackground(Color.BLACK);
        
        //  ...creates a panel and set its as a content pane...
        this.thePanel = new ControlPanel();        
        this.setContentPane(thePanel);
        
        //  ...and adds a key listener to the frame.
        this.addKeyListener(new SpriteKeyListener(this.thePanel.getAnimatedSprite()));
    
    }
    
    /**
     *  Returns the content panel of the frame.
     * 
     * @return  The content panel.
     */
    public ControlPanel getPanel() {
        return this.thePanel;
    }
    
}
