import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{

    private GreenfootImage background;
    private Button play;
    private Button settings;
    
    // Temporary for temp character to work
    //public static final int PLAYER_WIDTH = 64;
    //public static final int PLAYER_HEIGHT = 64;
    //public static final int PLAYER_BASE_SPEED = 3;
    //private int playerDirection;
    //private int playerSpeed
    public MyWorld()
    {    
        
        super(800, 600, 1); 
        setBackground(drawSpace(800,600,40));
        play = new Button ("Play");
        addObject(play, 200, 400);
        
        settings = new Button("Settings");
        addObject(settings, 600, 400);
        
    }
    // Constantly checks if player clicked a button
    public void act () {
        checkKeys();
        
    }
    // Temporary Background can change colour
    public static GreenfootImage drawSpace (int width, int height, int density){
        // Draws the background as gray.
        GreenfootImage world = new GreenfootImage (width, height);
        world.setColor (Color.DARK_GRAY);
        world.fill();
        
        return world;
    }
    // Method to go to WordWorld when press key on button
    private void checkKeys() {
        
        
    }
}
