package Modelo;

import java.io.Serializable;

public class InimigoAmarelo extends Inimigo implements Serializable{

    public InimigoAmarelo(String sNomeImagePNG, Player img_player) {
        super(sNomeImagePNG);
        this.img_player = img_player;
    }
    
    @Override
    public boolean move(){
        if(irand != 3){
            irand++;
            if(img_player.pPosition.getLinha() > pPosition.getLinha()){
                return moveDown();
            } else if(img_player.pPosition.getLinha() < pPosition.getLinha()){
                return moveUp();
            } else if (img_player.pPosition.getColuna() > pPosition.getColuna()) {
                return moveRight();
            } else if (img_player.pPosition.getColuna() < pPosition.getColuna()) {
                return moveLeft();
            }
        }else{
            irand = 0;
            if (img_player.pPosition.getColuna() > pPosition.getColuna()) {
                return moveRight();
            } else if (img_player.pPosition.getColuna() < pPosition.getColuna()) {
                return moveLeft();
            }
        }
        return false;
    }   
}