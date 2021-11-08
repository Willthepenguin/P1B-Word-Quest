import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class LetOut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scramble extends Actor
{
    Stack<String> s = new Stack<String>();
    
    ArrayList<String> theList = new ArrayList<String>();
    
    private Label label;
    
    public Scramble(){
        try{
            Reader.readIntoAlpha(theList);
            } catch(Exception e) {
        }
        
        for(String str: theList){
            s.push(str);
        }
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }  
    
    public void addLetter(){
        int randX = Greenfoot.getRandomNumber(700);
        int randY = Greenfoot.getRandomNumber(420);
        addObject(label, randX + 50, randY + 180);
        label = new Label (s.pop());
    }
}
