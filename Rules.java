import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rules here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rules extends World
{
    // Constructors for this Rules world
    private Button cont;
    private GreenfootImage background;
    
    public Rules()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        // Set image as that picture in images folder, scaled to 800 by 600
        // Then put it at 0,0 so it is new background
        GreenfootImage image = new GreenfootImage("Background.png");
        image.scale(image.getWidth()*8/5, image.getHeight()*6/5);
        getBackground().drawImage(image, 0, 0);
        
        // Initialize button as cont and added it to world
        cont = new Button ("Continue");
        addObject(cont, 400, 500);
        // Added the text to the world at a certain coordinate.
        // null for the colours so the image will match the same colour as background
        getBackground().drawImage(new GreenfootImage("You have 60 seconds to pick up as many letters as possible." ,32, null, null), 50, 100);
        getBackground().drawImage(new GreenfootImage("Use your mouse to click on the letters you want to pick up.", 32, null, null) , 50, 200);
        
        getBackground().drawImage(new GreenfootImage("Hint: Be careful about what letters you pick up!" ,32, null, null), 100, 300);
        
    }
    
    public void act (){
        // Checks the mouse clicks
        mouseClicked();
    }
    
    private void mouseClicked(){
        // If you click on cont button, go to GameWorld.
        if (Greenfoot.mouseClicked(cont)){
            Greenfoot.setWorld(new GameWorld());
        }
    }
    
    
}
