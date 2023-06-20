package Modelo;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Inimigo extends Animado implements Serializable {
    Player img_player;
    int timer;
    int irand = 0;
    long qtd_frames_inimigo = -10;
    
    public Inimigo(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
        this.timer = 10;
    }
    
    @Override
    public void autoDesenho(){
        super.autoDesenho();
        if(!Tela.getTela().getLoading()){
            if(qtd_frames_inimigo >= timer){
                move();
                qtd_frames_inimigo = 0;
            } else{
                qtd_frames_inimigo++;
            }
        }
    }
    
    @Override
    public void checkCollision(Personagem pTemp) {
        if(pTemp instanceof InimigoGen)
            return;
        if (pTemp != Tela.getTela().getPlayer()) {
            this.goToLastPosition();                
        }
    }
    
    @Override
    public boolean checkPosition(int linha, int coluna) {
        for (Personagem pTemp : Tela.getTela().getArrayPersonagens()){
            if(pTemp != this){
                if (pTemp.pPosition.getLinha() == linha) {
                    if (pTemp.pPosition.getColuna() == coluna) {
                        if(pTemp == Tela.getTela().getPlayer()){
                            return true;
                        } else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public abstract boolean move();
}
