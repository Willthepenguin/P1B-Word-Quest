import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GameWorld extends World
{
    private Button moveOn;
    private SimplePlayer sp;
    
    public final Color streakaddColor = new Color (34, 177, 76);
    public final Color streakminusColor = new Color (255, 0, 0);
    public final Color borderColor = new Color (0, 0, 0);
    
    public final Color timeStillColor = new Color (34, 177, 76);
    public final Color timeLeftColor = new Color (255, 0, 0);

    private int time;
    private int timeRemaining;
    
    private StatBar timerBar;
    
    public GameWorld()
    {    
        
        super(800, 600, 1); 
     
        moveOn = new Button ("Next");
        addObject(moveOn, 700, 550);
        
        sp = new SimplePlayer();
        addObject (sp, 400, 300);                
    
        time = 55*60;
        timeRemaining = time;
        
        timerBar = new StatBar (time, timeRemaining, null, 800, 20, 0, 
        timeStillColor, timeLeftColor, false, borderColor, 2);
        
        addObject (timerBar, 400, 100);
        addObject(new Timer(), 400, 30);
    }
    
    public void act() {
        mouseClicked();
        
        if (time != 0){
            timeRemaining = timeRemaining - 1;
            timerBar.update(timeRemaining);

        }
        
        if (timeRemaining == 0){
            Greenfoot.setWorld(new Transition1());
        }
    }
    
    private void mouseClicked(){
        if (Greenfoot.mouseClicked(moveOn)){
            Greenfoot.setWorld(new Transition1());
        }
    }
}
