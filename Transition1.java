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
        // Fix formating
        getBackground().drawImage(new GreenfootImage("Form as many words as possible using the letters collected related to the given topic." ,32, null, null), 0, 100);
        
        getBackground().drawImage(new GreenfootImage("You will be given points according to how many words you assemble." ,32, null, null), 50, 200);


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
