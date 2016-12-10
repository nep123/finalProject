import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fort here.
 * 
 * @author Nicholas Pinckney
 * @version (a version number or a date)
 */
public class Fort extends Actor
{
    /**
     * Act - do whatever the Fort wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        powerUp();
        World world;
        world = getWorld();
        //getWorld();removeObjects(getObject(Indian.class));
    } // end act method   
    
    /**
     * This was supposed to act as a cheat of sorts, where if
     * the Farmer touches the fort, the fort will clear the enemies
     */
    public void powerUp()
    {
        if (isTouching(Farmer.class) )
        {
            //getWorld().removeObject(Indian.class);
        } // end if
    
    } // end powerUp    
    
} // end Fort
