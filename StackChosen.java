import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StackABC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackChosen extends Stack
{
    public void input(int item){
        Stack<> chosen = new Stack<String>();
        String temp = ArrayABC.alpha(item);
        chosen.push(temp);
    
    }
}
