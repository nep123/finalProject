import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The French Soldier attacks the Spanish Farmer and his fort
 * 
 * @author Nicholas Pinckney 
 * @version 12-12-16
 */
public class French extends Actor
{
    
    private GreenfootImage[] images = new GreenfootImage[4];
    
    // keeps track of cycles through act method
    private int frameCount; 
    
    // keeps track of the index of images array
    private int imageIndex; 
    
    // keeps track of score
    private int score;
    
    /**
     * These are the animations used for the French Soldier
     * Each image is a different frame for the soldier
     * 
     * Code from Dr. Canada's Greenfoot Animation Tutorials
     * https://uscb.tegrity.com/#/recording/66e1dae0-0b34-4af2-8324-8bed2c39e2ef?startTime=0
     * 
     */
    public French()
    {
      frameCount = 0;
      imageIndex = 0;
      
      images[0] = new GreenfootImage("knight0.png");  
      images[1] = new GreenfootImage("knight1.png");
      images[2] = new GreenfootImage("knight2.png");
      images[3] = new GreenfootImage("knight3.png");
    } // end French
    
    /**
     * The French Soldier moves horizontally
     * if the soldier reaches the edge of the screen he
     * will flip over and go the opposite direction
     */
    public void act() 
    {
      
        frameCount++; 
        
        frenchDeath(); 
  
        move(3);
        
        if ( isAtEdge() )
        {
           
            turn(180);
 
        } // end if
        
        if ( frameCount == 4 )
        {
            // update the image
            updateImage();
            
            // reset frameCount to zero
            frameCount = 0;
        } // end if
        
    } // end act method
    
    /**
     * When this methhod is called, it updates the actors object's image
     * Code and Notes from Dr. Canada's Greenfoot Animation Tutorial
     * https://uscb.tegrity.com/#/recording/66e1dae0-0b34-4af2-8324-8bed2c39e2ef?startTime=0
     */
    public void updateImage()
    {
        // imageIndex is the array index that corresponds to
        // the current image we want to display
        setImage( images[imageIndex] );
        
        // We pre-increment imageIndex
        // then we check to see if the incremented value of imageIndex
        // is greater than the highest aailable index in the
        // images array 
        if ( ++imageIndex > (images.length - 1) )
        {
            imageIndex = 0; // reset to 0
        } // end if
        
    } // end updateImage
    
    /**
     * If the French soldier touches the Farmer, the Farmer dies
     */
    public void frenchDeath()
    {
        if ( isTouching(Farmer.class) )
        {
            removeTouching(Farmer.class);
            score = score -10;
        } // end if
       
    } // end frenchDeath method
    
} // end class French
