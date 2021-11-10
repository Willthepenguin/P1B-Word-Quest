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
    private GreenfootSound click=new GreenfootSound("mixkit-video-game-retro-click-237.wav");
    
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
            click.setVolume(50);
            click.play();
            GameWorld thisWorld = (GameWorld) getWorld();
            thisWorld.storeLetter(text);
           
            thisWorld.removeObject(this);
            counter--;
        }
        
        
        
        
        
    }
    
     
    protected void addedToWorld(World GameWorld)
     {
        while(isTouching(LetterButton.class))
        {
            int tempX = Greenfoot.getRandomNumber(600);
            int tempY = Greenfoot.getRandomNumber(350);
            
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
