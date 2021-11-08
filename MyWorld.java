import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  This world is intended to demonstrate AnimatedCharacter.
 *  
 *  Please see the documentation of the AnimatedCharacter for API and for
 *  detailed instructions on how to get started.
 */

public class MyWorld extends World
{
    
    private GreenfootImage background;
    private Button play;
    private Button settings;
    
    

    

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        setBackground(drawSpace(800,600,40));
        play = new Button ("Play");
        addObject(play, 200, 400);
        
        settings = new Button("Settings");
        addObject(settings, 600, 400);
        

    }

    public void act ()
    {
        mouseClicked();
    }
    
    public static GreenfootImage drawSpace (int width, int height, int density){
        // Draws the background as gray.
        GreenfootImage world = new GreenfootImage (width, height);
        world.setColor (Color.BLUE);
        world.fill();
        
        return world;
    }
    
    private void mouseClicked(){
        if (Greenfoot.mouseClicked(play)){
            Greenfoot.setWorld(new Rules());
        }
    }
}
