import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rules here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rules extends World
{
    private Button cont;
    private GreenfootImage background;
    
    public Rules()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        GreenfootImage image = new GreenfootImage("Word.png");
        image.scale(image.getWidth()*8/5, image.getHeight()*6/5);
        getBackground().drawImage(image, 0, 0);
        
        
        cont = new Button ("Continue");
        addObject(cont, 400, 500);
        
        getBackground().drawImage(new GreenfootImage("You have 60 seconds to pick up as many letters as possible." ,32, null, null), 50, 100);
        getBackground().drawImage(new GreenfootImage("Use your mouse to click on the letters you want to pick up.", 32, null, null) , 50, 200);
        
        getBackground().drawImage(new GreenfootImage("Hint: Be careful about what letters you pick up!" ,32, null, null), 100, 300);
        
        

    }
    
    public void act (){
        mouseClicked();
    }
    
    private void mouseClicked(){
        if (Greenfoot.mouseClicked(cont)){
            Greenfoot.setWorld(new GameWorld());
        }
    }
    
    public static GreenfootImage drawSpace (int width, int height, int density){
        // Draws the background as gray.
        GreenfootImage world = new GreenfootImage (width, height);
        world.setColor (Color.DARK_GRAY);
        world.fill();
        
        return world;
    }
}
