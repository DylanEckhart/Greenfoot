import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Garp here.
 * 
 * @author (Dylan Eckhart) 
 * @version (1-11-20120)
 */
public class Garp extends Actor
{
    private GreenfootImage imageLeft;
    private GreenfootImage imageRight;
    public Garp() {
        imageLeft = new GreenfootImage("GarpLeft.png");
        imageRight = new GreenfootImage("GarpRight.png");
        setImage(imageRight);
    }
    /**
     * Act - do whatever the Garp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
    if(Greenfoot.isKeyDown("Right")) {
        if(getImage() == imageLeft) {
            setImage(imageRight);
        }
        setRotation(0);
        move(5);
    }
    if(Greenfoot.isKeyDown("Left")) {
        if(getImage() == imageRight) {
            setImage(imageLeft);
        }
        setRotation(0);
        move(-5);
    }
    if(Greenfoot.isKeyDown("Up")) {
        setRotation(-90);
        move(5);
    }
    if(Greenfoot.isKeyDown("Down")) {
        setRotation(90);
        move(5);
    }
}
}
    
   
