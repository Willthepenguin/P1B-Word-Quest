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
        
        GreenfootImage image = new GreenfootImage("Word.png");
        image.scale(image.getWidth()*8/5, image.getHeight()*6/5);
        getBackground().drawImage(image, 0, 0);
        
        confirm = new Button("I understand");
        addObject(confirm, 700, 550);
        // Fix formating
        getBackground().drawImage(new GreenfootImage("Form as many words as possible using the letters " ,32, null, null), 100, 100);
        getBackground().drawImage(new GreenfootImage("collected related to the given topic." ,32, null, null), 150, 150);
        getBackground().drawImage(new GreenfootImage("You will be given points based on the number of " ,32, null, null), 100, 300);
        getBackground().drawImage(new GreenfootImage("words you create." ,32, null, null), 300, 350);
        
        
        
        
        
        


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
