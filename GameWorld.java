import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
import java.util.List;

public class GameWorld extends World
{
    //Private variables
    public final Color streakaddColor = new Color (34, 177, 76);
    public final Color streakminusColor = new Color (255, 0, 0);
    public final Color borderColor = new Color (0, 0, 0);
    public final Color timeStillColor = new Color (34, 177, 76);
    public final Color timeLeftColor = new Color (255, 0, 0);
    
    //Time Variable (Responsible for the time portion of this game)
    private int time;
    private int timeRemaining;
    private int spawnTime;
    private int spawnTimeRemaining;
    //Statbar that updates as time decreases
    private StatBar timerBar;
    
    //Generic Stack to store Strings from the theList
    Stack<String> s = new Stack<String>();
    //Arraylist to store strings from the reader
    ArrayList<String> theList = new ArrayList<String>();
    //Storage system that will store the letters of whatever the player clicks
    static Stack<String> storedLetters = new Stack<String>();
    
    //Creates new Greenfootsound for music.
    private GreenfootSound play=new GreenfootSound("Drive Me Wild.mp3");
    //"Button" that the player will see as letters where he/she will click them
    private LetterButton label;
    //Counter for game tracking purposes
    private int counter = 0;
    public GameWorld()
    {    
        //Initializing the world in a 800 x 600
        super(800, 600, 1);
        //Plays the music
        play.setVolume(50);
        play.playLoop();
        
        //Setting the background image
        GreenfootImage image = new GreenfootImage("Background.png");
        image.scale(image.getWidth()*8/5, image.getHeight()*6/5);
        getBackground().drawImage(image, 0, 0);
        
              
        //setting time to match tick speed, setting up base variables 
        time = 55*60;
        timeRemaining = time;
        spawnTime = 1;
        spawnTimeRemaining = time;
        
        //adding updating time statbar and adding the physical timer that players can refer to 
        timerBar = new StatBar (time, timeRemaining, null, 800, 20, 0, 
        timeStillColor, timeLeftColor, false, borderColor, 2);
        addObject (timerBar, 400, 100);
        addObject(new Timer(), 400, 30);
        
        //Reader things (importing list from a link)
        try{
            Reader.readIntoAlpha(theList);
            } catch(Exception e) {
        }
        for(String str: theList){
            s.push(str);
        }
        
        
    }
    
    //method to store letters the player clicks 
    public void storeLetter(String text)
    {
        storedLetters.push(text);
        
    }
    
    public void act() {
       
        //spawning the letters on the screen for players to click
        if (spawnTime != 27){
            if (counter % 3 != 0){
                counter++;
                
            }
            if (counter % 3 == 0){   
                 spawnLetter();
                 spawnTime += 1;
                }
        }
       //continuously updating the time and timer statbar
        if (time != 0){
            timeRemaining = timeRemaining - 1;
            timerBar.update(timeRemaining);

       }
        
       //checking for when player clicked enough letters
       if (storedLetters.getSize() == 10){
           //When you've fetched enough letters, stop the music and move on to the next world.
            Greenfoot.setWorld(new Transition1(storedLetters));
            play.stop();
       }
    }
    
    //Method to spawn letters in the world
    public void spawnLetter(){
        int randX = Greenfoot.getRandomNumber(600);
        int randY = Greenfoot.getRandomNumber(350);
        
        label = new LetterButton (s.pop());
        
        addObject(label, randX + 50, randY + 180);
        
        
    }
    
   
    
    
    
}
