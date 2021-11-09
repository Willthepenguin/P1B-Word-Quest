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
    private GreenfootSound rule=new GreenfootSound("Netzach battle.mp3");
    public Rules()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        rule.playLoop();
        setBackground(drawSpace(800,600,40));
        cont = new Button ("Continue");
        addObject(cont, 400, 500);
    }
    
    public void act (){
        mouseClicked();
    }
    
    private void mouseClicked(){
        if (Greenfoot.mouseClicked(cont)){
            Greenfoot.setWorld(new GameWorld());
            rule.stop();
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
