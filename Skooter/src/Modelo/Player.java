package Modelo;

import Controler.Tela;
import java.io.Serializable;
import java.util.ArrayList;

public class Player extends Animado implements Serializable{
    private int qtd_itens_obtidos = 0;
    
    public Player(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }
    
    public int getQtd_itens_obtidos() {
        return qtd_itens_obtidos;
    }
    
    // Sobre o Player
    @Override
    public void checkCollision(Personagem pTemp) {
        if (pTemp.isbColetavel()) {                       
            Tela.getTela().removePersonagem(pTemp);
            this.qtd_itens_obtidos++;
        } else if (pTemp.isbMortal()) {
            // Morrendo
            this.qtd_itens_obtidos = 0;
            Tela.getTela().perdeVida();
            if(Tela.getTela().getVidas() > 0){
                Tela.getTela().reiniciaFase();
            }
        } else if (pTemp.isbMovel()) {  // Sobre blocos moveis
            Blocos blocoTemp = (Blocos) pTemp;
            if(!blocoTemp.move(this.lastPosition())){
                this.goToLastPosition();
            }
        } else if (pTemp.isbTransponivel()) { // Sobre as setas
            Seta setaTemp = (Seta) pTemp;
            if(setaTemp.ehOposto(this)){
                this.goToLastPosition();
            } else{
                pTemp.checkCollision(this);
            }
        } else if (!pTemp.isbTransponivel()) {  // Sobre blocos imoveis
            this.goToLastPosition();
        }
    }
    
    
    public void destroiPersonagem(ArrayList<Personagem> p_aux){
        switch (this.lookingTo) {
            case 'U':
                destroiAux(p_aux, this.pPosition.getColuna(), this.pPosition.getLinha() - 1);
                break;
            case 'D':
                destroiAux(p_aux, this.pPosition.getColuna(), this.pPosition.getLinha() + 1);
                break;
            case 'L':
                destroiAux(p_aux, this.pPosition.getColuna() - 1, this.pPosition.getLinha());
                break;
            case 'R':
                destroiAux(p_aux, this.pPosition.getColuna() + 1, this.pPosition.getLinha());
                break;
            default:
                break;
        }
    }
    
    private void destroiAux(ArrayList<Personagem> p_aux, int col, int lin){
        for(int i = 0; i < p_aux.size(); i++){
            if(p_aux.get(i).pPosition.getColuna() == col){
                if(p_aux.get(i).pPosition.getLinha() == lin){
                    if(p_aux.get(i).isbDestrutivel()){
                        p_aux.remove(i);
                    }
                }
            }
        }
    }
}
