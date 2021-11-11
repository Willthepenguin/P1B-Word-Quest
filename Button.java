import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    public static final double FONT_RATIO = 0.58;
    private String myText;
    // Constructors for the image and touchingImage objects required to make the button.
    // Declaring drawX and drawY so we can store the coordinates to make the button
    private int drawX;
    private int drawY;
    
    private GreenfootImage image;
    private GreenfootImage touchingImage;
    
    private Font buttonFont = new Font("Courier New",  true,  false,  24);
    
    // Button, Label and LetterButton are very similar code.
    // They are based on this class that Mr.Cohen gave us last year
    // It makes the button, writes the text and make it centered.
    // This class was used to make Buttons with black box and words in middle.
    // In MyWorld, Rules, Transition1
    public Button (String text) {
        image = new GreenfootImage (180, 40);
        touchingImage = new GreenfootImage (180, 40);
        myText = text;
        // Prepare for centering:
        // How many letters?
        int wordLength = myText.length();  
        // How many pixels?
        int wordWidth = (int)(wordLength * buttonFont.getSize() * FONT_RATIO); 
        // Does the math for x and y to ensure it is centered.
        // Get the (image length-length of words)/2 so it draws where at the end will line up.
        drawX = (image.getWidth() - wordWidth)/2;
        // Gets image height - (image height-font size) to get correct height
        drawY = image.getHeight() - (image.getHeight() - buttonFont.getSize()) /2;
        //System.out.println("ww: " + wordWidth + " drawX: " + drawX);
      
        
        
        // Actually draws the button filling background then drawing text.
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
