import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GarpsWorld here.
 * 
 * @author (Dylan Eckhart) 
 * @version (03-11-2020)
 */
public class GarpsWorld extends World {
    private GreenfootSound sound;
    private EndScore endScore;
    public static int score = 0;
    /**
     * Constructor for objects of class GarpsWorld.
     * 
     */
    public GarpsWorld() {
        super(700, 500, 1); 
        populateTheWorld();
    }
    public void act() {
        showText("Score: " + score, 50, 470);
    }
    protected void populateTheWorld() {
        addObject(new Garp(), 350, 250);
        addObject(new Gnomus(), Greenfoot.getRandomNumber(670) + 15 , Greenfoot.getRandomNumber(470) + 15);
        sound = new GreenfootSound("Zelda.mp3");
        for (int teller = 0; teller < 4; teller++) {
            addObject(new Bomb(), Greenfoot.getRandomNumber(700), Greenfoot.getRandomNumber(500));
        }
        for (int teller = 0; teller < 10; teller++) {
            addObject(new Diamond(), Greenfoot.getRandomNumber(700), Greenfoot.getRandomNumber(500));
        }
        for (int teller = 0; teller < 6; teller++) {
            addObject(new Rock(), Greenfoot.getRandomNumber(700), Greenfoot.getRandomNumber(500));
        }
        setPaintOrder(EndScore.class, Garp.class, Gnomus.class, Diamond.class, Bomb.class, Rock.class);
    }
    public void started() {
        sound.playLoop();
        endScore = new EndScore();
    }
    public void stopped() {
        sound.stop();
        score = 0;
        this.endScore.setEndImage(this.score);
        this.addObject(this.endScore, this.getWidth() / 2, this.getHeight() / 2);
    }
}