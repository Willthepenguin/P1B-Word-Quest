import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;


public class AssembleWorld extends World 
{
    //Private variables
    public final Color streakaddColor = new Color (34, 177, 76);
    public final Color streakminusColor = new Color (255, 0, 0);
    public final Color borderColor = new Color (0, 0, 0);
    public final Color timeStillColor = new Color (34, 177, 76);
    public final Color timeLeftColor = new Color (255, 0, 0);
    private Button type;
    private Button check;
    
    //Time, counter, and spawning time variables
    private int time;
    private int timeRemaining;
    private int spawnTime;
    private int spawnTimeRemaining;
    private int counter = 0;
    private int checkCounter = 0;
    private int counter2 = 1;
    private int counter3 = 30;
    
    //Statbar for time
    private StatBar timerBar;
    //Label to output text on screen
    private Label label;
    
    //Strings that will take values from user input and conversion 
    private String input;
    private String stringLetter;
    private String convertChar;
    //Keeping track of score
    private Score score;
    //Stores letters imported from GameWorld
    Stack<String> letterStorage = new Stack<String>();
    //Stores letters converted from the stack letterStorage
    ArrayList<String> letterStorageString = new ArrayList<String>();
    //Importing the verb list from url using reader
    ArrayList<String> verbList = new ArrayList<String>();
    
    //stores letters converted from string into character
    ArrayList<Character> storeLetters2 = new ArrayList<Character>();
    
    public AssembleWorld(Stack<String> a) 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        //Sets background
        GreenfootImage image = new GreenfootImage("Background.png");
        image.scale(image.getWidth()*8/5, image.getHeight()*6/5);
        getBackground().drawImage(image, 0, 0);
        
        //Button that will tell user to click below button
        Button type = new Button("Click below");
        addObject(type, 400, 400);

        //Time ticks
        time = 55*60;
        timeRemaining = time;
        timerBar = new StatBar (time, timeRemaining, null, 800, 20, 0, 
        timeStillColor, timeLeftColor, false, borderColor, 2);
        addObject (timerBar, 400, 100);
        addObject(new Timer(), 400, 30);
        
        //Initializes score and keeps track of it
        score = new Score();
        addObject(score, 400, 300);
        
        //Sets score zero everytime the world is initialized
        Score.score = 0;
        
        
        //Reader things (importing list from a link)
        for (String str: a){
            letterStorage.push(str);
        }
        try{
            Reader.readIntoVerb(verbList);
            } catch(Exception e) {
        }
        
                
        
        
        
        
     
    }
    
    
  
    
    public void act(){
        //Updates timer and timer statbar
        if (time != 0){
            timeRemaining = timeRemaining - 1;
            timerBar.update(timeRemaining);

        }
        //if Time runs out brings player to the ending screen
        if (timeRemaining == 0){
            Greenfoot.setWorld(new EndScreen());
        }
        //Spawns the letters that the player has chosen
        if (spawnTime != 10){
            if (counter % 3 != 0){
                counter++;
                
            }
            if (counter % 3 == 0){   
                 spawnLetter();
                 spawnTime += 1;
                }
        }
        
       
        //If anywhere below the button is clicked player will be prompted to create a verb from words they choose
        if(Greenfoot.mouseClicked(this)){
            input = Greenfoot.ask("Input a Word");
            //charCheck(); and checkWord(); check the user input to ensure accuracy
            charCheck();
            checkWord();
            
            
        }     
    }
    
    //Spawns the letters on the screen in a straight evenly spaced line
    public void spawnLetter() {
        counter3 = 50*counter2;
        String words = letterStorage.pop();
        letterStorageString.add(words);
        label = new Label (words);
        addObject(label, counter3, 200);
        counter2++;
    }
    //Checks for if word input is a verb
    public void checkWord(){
        for (int i = 0; i < verbList.size(); i++){
            if (input.equals(verbList.get(i))){
                Score.score += 1;
            
            }
        }
    }
    //checks if the character input is matching with the characters selected previously
    public void charCheck(){
        char[] chars = input.toCharArray();
        
        //converts the string into chars
        for (int i = 0; i < letterStorageString.size(); i++){
            convertChar = letterStorageString.get(i);
            for(char c: convertChar.toCharArray()){
                 storeLetters2.add(c);
            }
        }
        //scoring system based on if it is correct or not (closely tied with checkWord();)
        for(int i = 0; i < chars.length; i++){
            if (input.equals(storeLetters2.get(i))){
             Score.score += 0;
             
            } else{
                checkCounter++;
                
            }
            
            if ( checkCounter == 10){
                Score.score -= 1;
                i = chars.length;
                checkCounter = 0;
            }
        }
   
    
 
    }
}
