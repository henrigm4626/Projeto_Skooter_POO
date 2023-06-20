// Inspirado no código de "ZigueZague.java", originalmente fornecido no código modelo
package Modelo;


import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class InimigoVerde extends Inimigo implements Serializable{

    public InimigoVerde(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }
    
    @Override
    public boolean move() {
        int direcao_rand = ThreadLocalRandom.current().nextInt(1, 5);
        if(direcao_rand == 1){
            return moveUp();
        } else if(direcao_rand == 2){
            return moveDown();
        } else if(direcao_rand == 3){
            return moveRight();
        } else if(direcao_rand == 4){
            return moveLeft();
        } else { 
            return false;
        }
    }
}
