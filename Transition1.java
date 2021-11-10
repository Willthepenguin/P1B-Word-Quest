import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition1 extends World
{
    private Button confirm;
    
    /**
     * Constructor for objects of class Transition1.
     * 
     */
    public Transition1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        confirm = new Button("I understand");
        addObject(confirm, 700, 550);
    }
    
    public void act(){
        mouseClicked();
    }
    
    private void mouseClicked(){
        if (Greenfoot.mouseClicked(confirm)){
            Greenfoot.setWorld(new AssembleWorld());
            
        }
    }
}
