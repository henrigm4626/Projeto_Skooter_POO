package Modelo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.Serializable;

public class Seta extends Personagem implements Serializable{
    private char dir;

    public Seta(String sNomeImagePNG, char dir) {
        super(sNomeImagePNG);
        this.dir = dir;
    }
    
    @Override
    public void checkCollision(Personagem pTemp) {
        Robot r;
        try {
            r = new Robot();
            
            // Mexe para a direcao correspondente 
            switch (this.dir) {
                case 'U':
                    r.keyPress(KeyEvent.VK_UP);
                    break;
                case 'D':
                    r.keyPress(KeyEvent.VK_DOWN);
                    break;
                case 'R':
                    r.keyPress(KeyEvent.VK_RIGHT);
                    break;
                case 'L':
                    r.keyPress(KeyEvent.VK_LEFT);
                    break;
                default:
                    break;
            }
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }
    
    // Retorna "true" se tentamos atravessar a seta no sentido oposto
    public boolean ehOposto(Personagem pTemp){
        if(this.dir == 'U' && pTemp.getLookingTo() == 'D'){
            return true;
        } else if(this.dir == 'D' && pTemp.getLookingTo() == 'U'){
            return true;
        } else if(this.dir == 'L' && pTemp.getLookingTo() == 'R'){
            return true;
        } else if(this.dir == 'R' && pTemp.getLookingTo() == 'L'){
            return true;
        }
        return false;
    }
}

