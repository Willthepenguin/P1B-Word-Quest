import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LetterButton extends Actor
{
    public static final double FONT_RATIO = 0.58;
    private String text;

    private int drawX;
    private int drawY;
    
    private GreenfootImage image;
    private GreenfootImage touchingImage;
    
    private Font buttonFont = new Font("Courier New",  true,  false,  24);
    
    private int counter = 10;
    
    private int timeReset = 0;
    // This class was used for the letters you picked up in GameWorld.
    
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
        if(Greenfoot.mouseClicked(this) && counter != 0)
        {
            
            GameWorld thisWorld = (GameWorld) getWorld();
            thisWorld.storeLetter(text);
          
            thisWorld.removeObject(this);
            counter--;
        }
        
        
        
        
        
    }
    
    // Added the addedToWorld which automatically does the stuff inside without manually calling it. 
    protected void addedToWorld(World GameWorld)
     {
        // So when the letters in GameWorld spawn, if they touch or overlap each other.
        while(isTouching(LetterButton.class))
        {
            int tempX = Greenfoot.getRandomNumber(600);
            int tempY = Greenfoot.getRandomNumber(350);
            // Assigns new random coordinates
            // It's while loop so it can repeat multiple times if necessary.
            tempX += 50;
            tempY += 180;
            setLocation(tempX, tempY);
            
            
        }
        
    }
    
    
    // White background and blue font this time.
    private void draw () {
        image.setColor(Color.WHITE);
        image.fill();
        image.setColor(Color.BLUE);
        image.setFont (buttonFont);
        image.drawString (text, drawX, drawY);
    }
}
