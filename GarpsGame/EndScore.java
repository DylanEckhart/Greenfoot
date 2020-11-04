        import greenfoot.*;
        import greenfoot.GreenfootImage;
        import java.awt.Font;
            /**
             * @author (Dylan Eckhart) 
             * @version (05-11-2020)
            **/
        public class EndScore extends Actor {
            private long startTime = System.currentTimeMillis();
    
            public EndScore() {
            }
            public void setEndImage(int score) {
                int hoogte = 200;
                int breedte = 500;
                String resultaat;
                if (score == 10) {
                    resultaat = "Je hebt gewonnen..!";
                } else {
                    resultaat = "Je hebt verloren..!";
                }
                String scoreText = "Aantal verzamelde diamanten: " + score;
                String duur = this.getElapsedTime();
                GreenfootImage image = new GreenfootImage(breedte, hoogte);
                image.setColor(new Color(125, 125, 125, 100));
                image.fillRect(0, 0, breedte, hoogte);
                image.setColor(new Color(255, 255, 255, 100));
                image.fillRect(0, 0, breedte - 5, hoogte - 5);
                this.setImage(image);
                hoogte = hoogte - 30;
                Font font = image.getFont();
                font = font.Font(1, 30.0F);
                image.setFont(font);
                image.setColor(Color.BLUE);
                image.drawString("Einde spel", image.getWidth() / 2 - 60, 30);
                font = font.Font(0, 20.0F);
                image.setFont(font);
                image.drawString(resultaat, 10, hoogte - 60);
                image.drawString(duur, 10, hoogte - 30);
                image.drawString(scoreText, 10, hoogte);
            }
            public String getElapsedTime() {
                long duration = System.currentTimeMillis() - this.startTime;
                int seconden = (int)(duration / 1000L);
                int uren = seconden / 3600;
                seconden %= 3600;
                int minuten = seconden / 60;
                seconden %= 60;
                String duur = String.format("Duur van het spel: %02d:%02d:%02d", uren, minuten, seconden);
                return duur;
            }
            public void act() {}
        }    
