import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Indian here.
 * 
 * @author Nicholas Pinckney
 * @version 12-12-16
 */
public class Indian extends Actor
{
    
    private GreenfootImage[] images = new GreenfootImage[4];
    
    private int frameCount; // keeps track of cycles through act method
    
    private int imageIndex; // keeps track of the index of images array
    
    private int score;
    /**
     * Code from Dr. Canada's Greenfoot Animation Tutorial
     * https://uscb.tegrity.com/#/recording/66e1dae0-0b34-4af2-8324-8bed2c39e2ef?startTime=0
     */
    public Indian()
    {
        frameCount = 0;
      imageIndex = 0;
      
      images[0] = new GreenfootImage("indian0.png");  
      images[1] = new GreenfootImage("indian1.png");
      images[2] = new GreenfootImage("indian2.png");
      images[3] = new GreenfootImage("indian3.png");
    } // end Indian
    
    /**
     * Act - do whatever the Indian wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        frameCount++;
    
        indianDeath(); 

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
    
    public void indianDeath()
    {
        if ( isTouching(Farmer.class) )
        {
            removeTouching(Farmer.class);
            score = score -10;
        } // end if
       
    } // end indianDeath method
    
} // end class Indian
