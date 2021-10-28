import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class WordWorld extends World
{
    public static final int totalButtonsOn = 20;
    public static final int buttonsOnTime = 600;
    public int lettersOn = 1;
    
    private int buttonsOn;
    
    
    public WordWorld()
    {    
        
        super(800, 600, 1); 
        buttonsOn = totalButtonsOn;
        
        
    }
    
    public void act() {
        spawn();
        
    }
    
    private void spawn(){
        
        lettersOn++;
    }
}
