package Modelo;

import Controler.Tela;
import java.io.Serializable;


public class InimigoGen extends Inimigo implements Serializable{
    int tipoMov = 0;
    public InimigoGen(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.timer = 5;
    }
    
    public void resetaImagem(){
        this.img_player = Tela.getTela().getPlayer();
    }
    
    @Override
    public boolean move(){
        if(tipoMov == 0){
            tipoMov = 1;
            if (img_player.pPosition.getColuna() > pPosition.getColuna()) {
                return moveRight();
            } else if(img_player.pPosition.getColuna() < pPosition.getColuna()){
                return moveLeft();
            } else if(img_player.pPosition.getLinha() > pPosition.getLinha()){
                return moveDown();
            } else if(img_player.pPosition.getLinha() < pPosition.getLinha()){
                return moveUp();
            }
        } else {
            tipoMov = 0;
            if(img_player.pPosition.getLinha() > pPosition.getLinha()){
                return moveDown();
            } else if(img_player.pPosition.getLinha() < pPosition.getLinha()){
                return moveUp();
            } else if (img_player.pPosition.getColuna() > pPosition.getColuna()) {
                return moveRight();
            } else if (img_player.pPosition.getColuna() < pPosition.getColuna()) {
                return moveLeft();
            }
        }
        return false;
    }
}
