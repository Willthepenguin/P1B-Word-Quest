import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Label extends Actor
{
    //Instance Variables
    public static final double FONT_RATIO = 0.42;
    
    private boolean touching;
    
    private String myText;
    
    private int drawX;
    private int drawY;
    
    private GreenfootImage image;

    // Change the font as this is used for AssembleWorld with bigger font.
    private Font buttonFont = new Font("Calibri", true, false, 60);
    
    public Label(String text)
    {
        image = new GreenfootImage (1800, 200);

        myText = text;
        
        //Count how many letters and centre in middle
        
        int wordLength = myText.length();
        
        //Count pixels
        
        int wordWidth = (int)(wordLength * buttonFont.getSize() * FONT_RATIO);
        drawX = (image.getWidth() - wordWidth) / 2;
        drawY = image.getHeight() - (image.getHeight() - buttonFont.getSize()) / 2;
        
        draw();
        setImage(image);
    }
    
    private void draw () {
        
 
        image.setColor(Color.BLACK);
        image.setFont (buttonFont);
        image.drawString (myText, drawX, drawY);


    } 
}
