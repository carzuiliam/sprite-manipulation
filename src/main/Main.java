package main;

import view.MainFrame;

/**
 *  The entry point of the application.
 * 
 * @author      Carlos de Carvalho (Carzuilha).
 */
public class Main {

    /**
     *  The main method of the application.
     * 
     * @param   args        The command line arguments.
     */
    public static void main(String[] args) {

        MainFrame theFrame = new MainFrame();

        while (true) {
            
            theFrame.repaint();
            
            try { 
                Thread.sleep(100); 
            } catch (InterruptedException ex) { 
                ex.printStackTrace();
            }
        }
        
    }
    
}
