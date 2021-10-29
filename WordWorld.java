import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class WordWorld extends World
{
    // Only 20 buttons max are on screen at once
    public static final int totalButtonsOn = 20;
    // Each button only there for 10 seconds
    public static final int buttonsOnTime = 600;
    public int lettersOn = 1;
    
    private int buttonsOn;
    private int timeOn;
    
    private int letterRandom;
    
    
    public WordWorld()
    {    
        
        super(800, 600, 1); 
        buttonsOn = totalButtonsOn;
        timeOn = buttonsOnTime;
        
        
    }
    
    public void act() {
        spawn();
        timeOn++;
        
    }
    
    private void spawn(){
        letterRandom = Greenfoot.getRandomNumber(25);
        lettersOn++;
    }
}
