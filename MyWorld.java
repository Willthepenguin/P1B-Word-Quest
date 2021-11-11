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
    
    //New GreenfootSound for music
    private GreenfootSound main=new GreenfootSound("P5 OST 02 Phantom.mp3");
    

    

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        //Plays the music
        main.playLoop();
        main.setVolume(50);
        setBackground(drawSpace(800,600,40));
        play = new Button ("Play");
        addObject(play, 400, 500);
        
        
        
        GreenfootImage image = new GreenfootImage("Word.png");
        image.scale(image.getWidth()*8/5, image.getHeight()*6/5);
        getBackground().drawImage(image, 0, 0);

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
        //When you start playing, stop the music and display rules
        if (Greenfoot.mouseClicked(play)){
            main.stop();
            Greenfoot.setWorld(new Rules());
        }
    }
}
