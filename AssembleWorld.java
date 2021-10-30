import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AssembleWorld extends World
{
    private SimplePlayer sp;
    
    public AssembleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        sp = new SimplePlayer();
        addObject (sp, 400, 300);
    }
}
