import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the title screen.
 * Once you click on the world the game will start
 * 
 * @author Nicholas Pinckney
 * @version 12-12-16
 */
public class Title extends World
{

    /**
     * Constructor for objects of class Title.
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    } // end constructor 
    
    /**
     * Allows the player to start the game
     * Code from Dr. Canada's tutorial TitleAndGameOverScreens
     * https://uscb.tegrity.com/#/recording/4ad5bd8f-1d18-4c8d-9111-d3dbffa360a6?startTime=0
     */
    public void act()
    {
        if ( Greenfoot.mouseClicked( this ) )
        {
            ParrisIsland parrisIsland = new ParrisIsland();
            Greenfoot.setWorld( parrisIsland );
        }
    }// end act method 
    
} // end class
