import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Letters extends Actor
{
    public static final double FONT_RATIO = 0.58;
    private String myText;

    private int drawX;
    private int drawY;
    
    private GreenfootImage image;
    private GreenfootImage touchingImage;
    
    private Font buttonFont = new Font("Courier New",  true,  false,  14);
    
    
    //Different from main menu Button as we need to delete buttons
    // After 10 Seconds
    
    protected boolean removeMe;
    protected int lettersOn;
    
    
    
    public Letters (String text) {
        image = new GreenfootImage (20, 20);
        touchingImage = new GreenfootImage (20, 20);
        myText = text;
        // Prepare for centering:
        // How many letters?
        int wordLength = myText.length();  
        // How many pixels?
        int wordWidth = (int)(wordLength * buttonFont.getSize() * FONT_RATIO); 
        drawX = (image.getWidth() - wordWidth)/2;
        drawY = image.getHeight() - (image.getHeight() - buttonFont.getSize()) /2;
        //System.out.println("ww: " + wordWidth + " drawX: " + drawX);
      
        
        
        draw();
        setImage (image);
        // Adding this for counting letters in world and for deleting
        removeMe = false;
        
        
        
    }
    
    public void act() 
    {
        setImage(image);
        if(removeMe){
            getWorld().removeObject(this);
            lettersOn--;
        }
    }
    
    private void draw () {
        image.setColor(Color.BLACK);
        image.fill();
        image.setColor(Color.WHITE);
        image.setFont (buttonFont);
        image.drawString (myText, drawX, drawY);
    }    
}
