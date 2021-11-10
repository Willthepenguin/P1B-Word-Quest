import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Settings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Settings extends World
{

    private Button 
    public Settings()
    {    
        
        super(800, 600, 1); 
    }
    
    public void act()
    {
        mouseClicked();
    }
    
    private void mouseClicked(){
        if (Greenfoot.mouseClicked(play)){
            Greenfoot.setWorld(new Rules());
        }
        if(Greenfoot.mouseClicked(settings)){
            Greenfoot.setWorld(new Settings());
        }
    }
    
    
}
