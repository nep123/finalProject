import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * If the Farmer comes into contact with the cannonball,
 * the cannonball will fire in a straight line down to the bottom of the world,
 * a
 * 
 * @author Nicholas Pinckney 
 * @version 12-12-16
 */
public class Cannonball extends Actor
{
    /**
     * The cannonball will fire down in a straight line
     */
    public void act() 
    {
        
        fireCannon();
        
    } // end act method    

    public void fireCannon()
    /**
     * If the farmer touches the cannonball, the cannonball
     * will "fire" and remove any enemies it comes into contact with
     */
    {
   
        if ( isTouching(Farmer.class) )
        {
            setLocation(getX(), getY()+300);
        } // end if
        
        if ( isTouching(Indian.class) )
        {
            removeTouching(Indian.class);
        } // end if
        
        if ( isTouching(French.class) )
        {
            removeTouching(French.class);
        } // end if
        
    } // end fireCannon
    
} // end Cannnonball
