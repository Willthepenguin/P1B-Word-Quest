import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  This world is intended to demonstrate AnimatedCharacter.
 *  
 *  Please see the documentation of the AnimatedCharacter for API and for
 *  detailed instructions on how to get started.
 */

public class MyWorld extends World
{
    // Constructors for objects in MyWorld
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
        // Change the background to blue
        setBackground(drawSpace(800,600,40));
        // Create a button called play and add the button to the world.
        play = new Button ("Play");
        addObject(play, 200, 500);
        // Made a button called settings and placed it in the world.
        settings = new Button("Settings");
        addObject(settings, 600, 500);
        // So image is the picture, scaled it to 800 by 600 pixels
        // and then added the picture to the image at 0,0 so it fully covers old background.
        GreenfootImage image = new GreenfootImage("Word.png");
        image.scale(image.getWidth()*8/5, image.getHeight()*6/5);
        getBackground().drawImage(image, 0, 0);

    }

    public void act ()
    {
        // Checks if someone clicks the buttons
        mouseClicked();
    }
    
    public static GreenfootImage drawSpace (int width, int height, int density){
        // Draws the background as blue at specific width and height.
        GreenfootImage world = new GreenfootImage (width, height);
        world.setColor (Color.BLUE);
        world.fill();
        
        return world;
    }
    // Method to see if mouse clicked on a button
    private void mouseClicked(){
        // If it clicked the play buttons, go to Rules world
        if (Greenfoot.mouseClicked(play)){
            Greenfoot.setWorld(new Rules());
        }
        // If it clicks the settings button, go to Settings world.
        if(Greenfoot.mouseClicked(settings)){
            Greenfoot.setWorld(new Settings());
        }
    }
}
