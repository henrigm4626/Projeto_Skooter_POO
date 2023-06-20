package Modelo;

import Controler.Tela;
import java.io.Serializable;

public class Coletaveis extends Personagem implements Serializable{
    
    public Coletaveis(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = true;
        this.bColetavel = true;
    }
    
    @Override
    public void checkCollision(Personagem pTemp){
        if(pTemp instanceof InimigoGen)
            return;
        if(pTemp != Tela.getTela().getPlayer()){
            pTemp.goToLastPosition();
        }
    }
}