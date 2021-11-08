import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AssembleWorld extends World
{
 
    public final Color streakaddColor = new Color (34, 177, 76);
    public final Color streakminusColor = new Color (255, 0, 0);
    public final Color borderColor = new Color (0, 0, 0);
    
    public final Color timeStillColor = new Color (34, 177, 76);
    public final Color timeLeftColor = new Color (255, 0, 0);

    private int time;
    private int timeRemaining;
    
    private StatBar timerBar;
    
    public AssembleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
      
        
        time = 55*60;
        timeRemaining = time;
        
        timerBar = new StatBar (time, timeRemaining, null, 800, 20, 0, 
        timeStillColor, timeLeftColor, false, borderColor, 2);
        
        addObject (timerBar, 400, 100);
        addObject(new Timer(), 400, 30);
    }
    
    public void act(){
        if (time != 0){
            timeRemaining = timeRemaining - 1;
            timerBar.update(timeRemaining);

        }
        
        if (timeRemaining == 0){
            Greenfoot.setWorld(new EndScreen());
        }
    }
}
