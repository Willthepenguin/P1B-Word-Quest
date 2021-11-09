import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
import java.util.List;

public class GameWorld extends World
{
    private Button moveOn;

    
    public final Color streakaddColor = new Color (34, 177, 76);
    public final Color streakminusColor = new Color (255, 0, 0);
    public final Color borderColor = new Color (0, 0, 0);
    
    public final Color timeStillColor = new Color (34, 177, 76);
    public final Color timeLeftColor = new Color (255, 0, 0);

    private int time;
    private int timeRemaining;
    
    private int spawnTime;
    private int spawnTimeRemaining;
    
    private StatBar timerBar;
    
    Stack<String> s = new Stack<String>();
    ArrayList<String> theList = new ArrayList<String>();
    
    static Stack<String> storedLetters = new Stack<String>();
    
    
    private LetterButton label;
    
    private int counter = 0;
    public GameWorld()
    {    
        
        super(800, 600, 1); 
     
        moveOn = new Button ("Next");
        addObject(moveOn, 700, 550);
        
              
    
        time = 55*60;
        timeRemaining = time;
        
        spawnTime = 1;
        spawnTimeRemaining = time;
        
        timerBar = new StatBar (time, timeRemaining, null, 800, 20, 0, 
        timeStillColor, timeLeftColor, false, borderColor, 2);
        
        addObject (timerBar, 400, 100);
        addObject(new Timer(), 400, 30);
        
        try{
            Reader.readIntoAlpha(theList);
            } catch(Exception e) {
        }
        
        for(String str: theList){
            s.push(str);
        }
        
        
    }
    
    public void storeLetter(String text)
    {
        storedLetters.push(text);
    }
    
    public void act() {
        mouseClicked();
        
        if (spawnTime != 27){
            if (counter % 3 != 0){
                counter++;
                
            }
            if (counter % 3 == 0){   
                 spawnLetter();
                 spawnTime += 1;
                }
        }
       
        if (time != 0){
            timeRemaining = timeRemaining - 1;
            timerBar.update(timeRemaining);

       }
        
      
       if (storedLetters.getSize() == 10){
            List objects = getObjects(null);
            removeObjects(objects); 
       }
    }
    
    public void spawnLetter(){
        int randX = Greenfoot.getRandomNumber(600);
        int randY = Greenfoot.getRandomNumber(350);
        
        label = new LetterButton (s.pop());
        
        addObject(label, randX + 50, randY + 180);
        
        
    }
    
   
    private void mouseClicked(){
        if (Greenfoot.mouseClicked(moveOn)){
            Greenfoot.setWorld(new Transition1());
        }
    }
    
    
}
