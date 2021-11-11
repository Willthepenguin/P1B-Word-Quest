import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LetterButton extends Actor
{
    // Constructors for objects in this class
    public static final double FONT_RATIO = 0.58;
    private String text;
    private String text1;

    private int drawX;
    private int drawY;
    
    private GreenfootImage image;
    private GreenfootImage touchingImage;
    
    private Font buttonFont = new Font("Courier New",  true,  false,  24);
    // counter variable so only 10 letters can be picked up.
    private int counter = 10;
    
    private int timeReset = 0;
    //Creates a new GreenfootSound for clicking sound.
    private GreenfootSound click = new GreenfootSound("mixkit-video-game-retro-click-237.wav");
    
    public LetterButton (String text) {
        image = new GreenfootImage (40, 40);
        touchingImage = new GreenfootImage (180, 40);
        this.text = text;
        // Prepare for centering:
        // How many letters?
        int wordLength = text.length();  
        // How many pixels?
        int wordWidth = (int)(wordLength * buttonFont.getSize() * FONT_RATIO); 
        drawX = (image.getWidth() - wordWidth)/2;
        drawY = image.getHeight() - (image.getHeight() - buttonFont.getSize()) /2;
        //System.out.println("ww: " + wordWidth + " drawX: " + drawX);
      
        
        
        draw();
        setImage (image);
        
    }
    
    public void act() 
    {
        // If mouse got clicked and you still have letters to pick up.
        if(Greenfoot.mouseClicked(this) && counter != 0)
        {
            //Plays the clicking sound whenever you take a letter.
            click.setVolume(100);
            click.play();
            GameWorld thisWorld = (GameWorld) getWorld();
            thisWorld.storeLetter(text);
            // When you click, store letter and remove object and minus counter
            // So it know how many letters are picked up.
           
            thisWorld.removeObject(this);
            counter--;
        }
        
        
        
        
        
    }
    
    // addedToWorld so it is automatically applied so you don't need to manually call it.
    protected void addedToWorld(World GameWorld)
     {
         // While it is touching another letterButton class, give it random cooridantes again
        while(isTouching(LetterButton.class))
        {
            int tempX = Greenfoot.getRandomNumber(600);
            int tempY = Greenfoot.getRandomNumber(350);
            // Give it random location so no overlap or covering letters.
            // while loop so it can repeat multiple times if necessary.
            tempX += 50;
            tempY += 180;
            setLocation(tempX, tempY);
            
            
        }
        
    }
    
    
    
    private void draw () {
        image.setColor(Color.WHITE);
        image.fill();
        image.setColor(Color.BLUE);
        image.setFont (buttonFont);
        image.drawString (text, drawX, drawY);
    }
}
