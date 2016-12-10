import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Spanish Farmer is trying to collect enough seeds to grow
 * food for his new fort on Parris Island
 * 
 * @author Nicholas Pinckney
 * @version 12-12-16
 */
public class Farmer extends Actor
{
    // instamce variables
    private GreenfootImage[] images = new GreenfootImage[4];  
    
    private int frameCount; // keeps track of cycles through act method
    private int imageIndex; // keeps track of the index of images array
    private boolean directionIsLeft; //if true, farmer is facing left
    private int seedsCollected;
    private int score;
    
    
    // constructor
    /**
     * Code from Dr. Canada's Greenfoot Animation Tutorial
     * https://uscb.tegrity.com/#/recording/66e1dae0-0b34-4af2-8324-8bed2c39e2ef?startTime=0
     */
    public Farmer()
    
    {
      // initialize instance variables  
      frameCount = 0;
      imageIndex = 0;
      seedsCollected = 0;
      
      images[0] = new GreenfootImage("frame0.png");  
      images[1] = new GreenfootImage("frame1.png");
      images[2] = new GreenfootImage("frame2.png");
      images[3] = new GreenfootImage("frame3.png");
      //images[4] = new GreenfootImage("frame4.png");
      //images[5] = new GreenfootImage("frame5.png");
      //images[6] = new GreenfootImage("frame6.png");
      //images[7] = new GreenfootImage("frame7.png");
      
      // instantiate the SpriteSheet object
      //spritesheet = new SpriteSheet(); // call the default constructor
     
      // farmer starts off facing left
      directionIsLeft = true;
      
    } // end Farmer constructor
    
    
    /**
     * Act - do whatever the Farmer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // move when the key is pressed
        checkKeyPress(); 

        frameCount++;

        // when the farmer touches the seeds, 
        // seeds disappear
        gatherSeeds(); 
        
        getWorld();
        
        // reverse farmer's direction if farmer is facing left and
        // right key is held down
        if ( Greenfoot.isKeyDown("right") && directionIsLeft )
        {
            // reverse direction
            directionIsLeft = false;
            
            for ( GreenfootImage image : images )
            {
                image.mirrorHorizontally(); // flips image
            } // end for statement
        } // end if
        
        if ( Greenfoot.isKeyDown("left") && !directionIsLeft )
        {
            // reverse direction
            directionIsLeft = true;
            
            for ( GreenfootImage image : images )
            {
                image.mirrorHorizontally(); // flips image
            } // end for statement
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
        
    }
    
    /**
     * Moves the farmer horizontally and vertically
     * Depending on what key you press down on, the image of the 
     * farmer changes
     */
    public void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            move(-2);
            setImage(images[2]);
        }
        else
        {
            move(0);
            setImage(images[0]);
        } // end if
         
        if (Greenfoot.isKeyDown("right"))
        {
            move(2);
            setImage(images[2]);
        }
        else
        {
            move(0);
        } // end if
        
        if ( getImage() == images[2] )
        {
            setImage(images[3]);
        }
        else
        {
            setImage(images[2]);
        }
        
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-2);
        } // end if
         
        
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+2);
        } // end if
      
    } // end checkKeyPress method
    
    /**
     * If the collector collects 10 seeds without dying,
     * you win the game. A text will pop up when the amount of seeds 
     * you collected reaches 10 saying "YOU WIN!"
     * 
     * Code from: Introduction to Programming with Greenfoot 
     * by Michael Kolling pg 71
     */
    public void gatherSeeds()
    {
        if ( isTouching(Seed.class) )
        {
            removeTouching(Seed.class);
            seedsCollected = seedsCollected + 1;
            if (seedsCollected == 10)
            {
                Greenfoot.stop();
                getWorld().showText("YOU WIN!", 300, 200);
            }
        } // end if
       
    } // end gatherSeeds method
   
    
    
} // end class Farmer
