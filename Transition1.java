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
    
    Stack<String> store = new Stack<String>();
    public Transition1(Stack<String> s)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        confirm = new Button("I understand");
        addObject(confirm, 700, 550);
        
        for (String str : s){
            store.push(str);
        }
    }
    
    public void act(){
        mouseClicked();
    }
    
    private void mouseClicked(){
        if (Greenfoot.mouseClicked(confirm)){
            Greenfoot.setWorld(new AssembleWorld(store));
        }
    }
}
