import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ParrisIsland here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParrisIsland extends World
{
    // instance variable
    private Farmer farmer;
    private Fort fort;
    private Indian indian;
    private Cannonball cannonball;
    private int score; // keeps track of how many seeds collected
    
    
    /**
     * Constructor for objects of class ParrisIsland.
     * 
     */
    public ParrisIsland()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // spawns characters in new world
        newWorld(); 
    
        // shows how many seeds collected
        score = 0;
        
        
        
    } // end constructor
    
    
    /**
     * Adds characters and sprites to the world
     * Code for spawning characters was taken from
     */
    private void newWorld()
    {
        // create Farmer and add it to the world
        farmer = new Farmer();
        addObject( farmer, 300, 200 );
        
        // create a Fort and add it to the world
        fort = new Fort();
        addObject( fort, 300, 50);
        
        // create cannonballs and add it to the world
        Cannonball cannonball = new Cannonball();
        addObject( cannonball, 300, 100);
        
        Cannonball cannonball2 = new Cannonball();
        addObject( cannonball2, 350, 70);
        
        Cannonball cannonball3 = new Cannonball();
        addObject( cannonball3, 260, 70);
        
        // create Indians and add it to the world in random locations
        Indian indian = new Indian();
        addObject(new Indian(), Greenfoot.getRandomNumber(599), Greenfoot.getRandomNumber(399));
                  
        Indian indian2 = new Indian();
        addObject(new Indian(), Greenfoot.getRandomNumber(599), Greenfoot.getRandomNumber(399));
                  
        // create French soldiers and add it to the world in random locations
        French french = new French();
        addObject(new French(), Greenfoot.getRandomNumber(599), Greenfoot.getRandomNumber(399));
                  
        French french2 = new French();
        addObject(new French(), Greenfoot.getRandomNumber(599), Greenfoot.getRandomNumber(399));
         
        
    } // end newWorld
 
    public void showText()
    {
        showText("Seeds: " + score, 300, 200);
    } // end showText
    
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < .1)
        {
            // adds seeds to the world at random intervals 
            // at random locations
            addObject(new Seed(), Greenfoot.getRandomNumber(599), 
            Greenfoot.getRandomNumber(399));
        } // end if
    
        if (Greenfoot.isKeyDown("q") )
        {
            beginGameOver();
        }

    } // end act method

    /**
     * Switches the world to Game Over screen
     */
   
    public void beginGameOver()
    {
        GameOver gameover = new GameOver();
        Greenfoot.setWorld( gameover );
        
        if (Farmer.class!=null)
        {
            beginGameOver();
        }
    } // end beginGameOver
    
} // end class ParrisIsland
