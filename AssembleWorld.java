import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AssembleWorld extends World
{
 
    public final Color streakaddColor = new Color (34, 177, 76);
    public final Color streakminusColor = new Color (255, 0, 0);
    public final Color borderColor = new Color (0, 0, 0);
    
    public final Color timeStillColor = new Color (34, 177, 76);
    public final Color timeLeftColor = new Color (255, 0, 0);
    
    private Button type;
    private Button check;
    
    private int time;
    private int timeRemaining;
    private int spawnTime;
    private int spawnTimeRemaining;
    private int counter = 0;

    
    private int counter2 = 1;
    private int counter3 = 30;
    
    private StatBar timerBar;
    
    private Label label;
    
    Stack<String> letterStorage = new Stack<String>();
    ArrayList<String> verbList = new ArrayList<String>();
    
    ArrayList<String> answerList = new ArrayList<String>();
    
    public AssembleWorld(Stack<String> a)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        GreenfootImage image = new GreenfootImage("Background.png");
        image.scale(image.getWidth()*8/5, image.getHeight()*6/5);
        getBackground().drawImage(image, 0, 0);
          
        Button type = new Button("Enter a word");
        addObject(type, 700, 300);
        
        Button check = new Button("Check my Answer");
        addObject(check, 100, 300);
        
        time = 55*60;
        timeRemaining = time;
        
        timerBar = new StatBar (time, timeRemaining, null, 800, 20, 0, 
        timeStillColor, timeLeftColor, false, borderColor, 2);
        
        addObject (timerBar, 400, 100);
        addObject(new Timer(), 400, 30);
        
        for (String str: a){
            letterStorage.push(str);
        }
        
        
        
        try{
            Reader.readIntoVerb(verbList);
            } catch(Exception e) {
        }
        
                
        
        
        
        
     
    }
    
    
  
    
    public void act(){
        
        if (time != 0){
            timeRemaining = timeRemaining - 1;
            timerBar.update(timeRemaining);

        }
        
        if (timeRemaining == 0){
            Greenfoot.setWorld(new EndScreen());
        }

        if (spawnTime != 10){
            if (counter % 3 != 0){
                counter++;
                
            }
            if (counter % 3 == 0){   
                 spawnLetter();
                 spawnTime += 1;
                }
        }
        
        if(Greenfoot.mouseClicked(type)){
            String input = Greenfoot.ask("Input a Word");
            answerList.add(input);
        }
        
        if(Greenfoot.mouseClicked(check)){
            checkWord();
        }
        
        
        
    }
    
    public void spawnLetter(){
            
        
        counter3 = 50*counter2;
        
        label = new Label (letterStorage.pop());
        
        addObject(label, counter3, 200);
        
        counter2++;
    }
    
    public void checkWord(){
        for (int i = 0; i < answerList.size(); i++){
                for (int j = 0; i < verbList.size(); j++){
                if (answerList.get(i).equals(verbList.get(j))){
                    Score.score++;
                }else {
                    j = 0;
                }
            }
        }
    }
    
    
}
