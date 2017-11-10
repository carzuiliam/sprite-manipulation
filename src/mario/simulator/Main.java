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
package mario.simulator;

import view.MainFrame;

/**
 *
 * @author Carzuilha
 */
public class Main {

    /**
     *  The main method of the application.
     * 
     * @param   args    The command line arguments.
     */
    public static void main(String[] args) {
        
        //  Creates a new main frame...
        MainFrame theFrame = new MainFrame();
        
        //  ...and draws it while it's open.
        while (true) {
            theFrame.repaint();
            try { Thread.sleep(100); } catch (InterruptedException ex) { }
        }
        
    }
    
}
