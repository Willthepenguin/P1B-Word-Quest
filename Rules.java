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
    //New Greenfootsound for music
    private GreenfootSound rule=new GreenfootSound("Netzach battle.mp3");
    public Rules()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        //Plays music
        rule.setVolume(50);
        rule.playLoop();
        GreenfootImage image = new GreenfootImage("Background.png");
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
        //Once you click on continue, stop the music and start the game.
        if (Greenfoot.mouseClicked(cont)){
            rule.stop();
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
