import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition1 extends World
{
    private Button confirm;
    //stores music file in GreenfootSound
    private GreenfootSound transition=new GreenfootSound("P5 OST 09 Beneath the Mask  Instrumental Version.mp3");
    
    // Creating the store stack
    Stack<String> store = new Stack<String>();
    // Code very similar to rules world.
    public Transition1(Stack<String> s)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        //Plays music
        transition.setVolume(50);
        transition.playLoop();
        GreenfootImage image = new GreenfootImage("Background.png");
        image.scale(image.getWidth()*8/5, image.getHeight()*6/5);
        getBackground().drawImage(image, 0, 0);
        
        confirm = new Button("I understand");
        addObject(confirm, 700, 550);
        // Fix formating
        getBackground().drawImage(new GreenfootImage("Form as many words as possible using the letters " ,32, null, null), 100, 100);
        getBackground().drawImage(new GreenfootImage("collected related to any type of verb." ,32, null, null), 150, 150);
        getBackground().drawImage(new GreenfootImage("You will be given points based on the number of " ,32, null, null), 100, 300);
        getBackground().drawImage(new GreenfootImage("words you create." ,32, null, null), 300, 350);
        getBackground().drawImage(new GreenfootImage("There is a time limit of 60 seconds", 32, null, null), 200, 400);
        // Pushed the s stack containing the letters into new stack called store
        for (String str : s){
            store.push(str);
        }
    }
    
    public void act(){
        mouseClicked();
    }
    
    private void mouseClicked(){
    //Once you click on confirm, stop the music and move on to next world
        if (Greenfoot.mouseClicked(confirm)){
            transition.stop();
            // Go to AssembleWorld if button is clicked and giving it store stack
            Greenfoot.setWorld(new AssembleWorld(store));
        }
    }
}
