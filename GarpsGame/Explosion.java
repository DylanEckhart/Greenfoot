import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor {
    private GreenfootImage[] images;
    private GreenfootImage baseImage;
    private boolean geluid;
    private int action = 0;
    private int increment;
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Explosion() {
        int size = 0, baseSize, verschil, teller;
        
        baseImage = new GreenfootImage("explosion.png");
        baseSize = baseImage.getWidth();
        images = new GreenfootImage[8];
        verschil = baseSize / 8;
        increment = 1;
        size = 0;
        geluid = true;
        for (teller = 0; teller < 8; teller++) {
            size += verschil;
            images[teller] = new GreenfootImage(baseImage);
            images[teller].scale(size, size);
        }
    }    
    public void act() {
        setImage(images[action]);
        action += increment;
        if (geluid) {
            Greenfoot.playSound("explosion.wav");
            geluid = false;
        }
        if (action > 7) {
            increment = -1;
            action += increment;
        }
        if (action < 0) {
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
}