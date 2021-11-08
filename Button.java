import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    public static final double FONT_RATIO = 0.58;
    private String myText;

    private int drawX;
    private int drawY;
    
    private GreenfootImage image;
    private GreenfootImage touchingImage;
    
    private Font buttonFont = new Font("Courier New",  true,  false,  24);
    
    
    public Button (String text) {
        image = new GreenfootImage (180, 40);
        touchingImage = new GreenfootImage (180, 40);
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
        
    }
    
    public void act() 
    {
        setImage(image);
        
    }
    
    private void draw () {
        image.setColor(Color.BLACK);
        image.fill();
        image.setColor(Color.WHITE);
        image.setFont (buttonFont);
        image.drawString (myText, drawX, drawY);
    }
}
