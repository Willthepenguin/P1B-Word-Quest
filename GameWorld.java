import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GameWorld extends World
{
    private Button moveOn;
    private SimplePlayer sp;
    
    
    
    public GameWorld()
    {    
        
        super(800, 600, 1); 
     
        moveOn = new Button ("Next");
        addObject(moveOn, 700, 550);
        
        sp = new SimplePlayer();
        addObject (sp, 400, 300);                
        
    }
    
    public void act() {
        mouseClicked();
        
    }
    
    private void mouseClicked(){
        if (Greenfoot.mouseClicked(moveOn)){
            Greenfoot.setWorld(new Transition1());
        }
    }
}
