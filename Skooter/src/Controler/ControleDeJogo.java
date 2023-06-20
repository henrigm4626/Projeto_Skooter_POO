package Controler;
//TODO
import Modelo.Blocos;
import Modelo.Inimigo;
import Modelo.Personagem;
import Modelo.Player;
import auxiliar.Posicao;
import java.util.ArrayList;

public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Personagem> e){
        for(int i = 0; i < e.size(); i++){
            Personagem p_aux = e.get(i);
            
            // Se uma seta estiver na mesma posição do heroi, desenha-se a seta e depois o heroi
            if(!p_aux.isbMovel() && !p_aux.isbMortal() && !p_aux.isbDestrutivel() && p_aux.getPosicao().igual(e.get(0).getPosicao()) && !p_aux.isbColetavel()){
                p_aux.autoDesenho();
                e.get(0).autoDesenho();
            }
            else{
                e.get(i).autoDesenho();
            }
        }
    }
    
    public void processaTudo(ArrayList<Personagem> umaFase){
        Personagem p1;
        Personagem p2;
        
        for(int i = 0; i < umaFase.size(); i++){
            p1 = umaFase.get(i);
            for(int j = i+1; j < umaFase.size(); j++){
                p2 = umaFase.get(j);
                if((j != i) && p1.getPosicao().igual(p2.getPosicao())){
                    // Sobre o player
                    if(i == 0){
                        Player player_aux = (Player) p1;
                        player_aux.checkCollision(p2);
                        
                        // Caso o player colete todos os itens, vai para a próxima fase
                        if(player_aux.getQtd_itens_obtidos() >= 4){
                            Tela.getTela().proximaFase();
                            return;
                        }
                        // Se as vidas do player acabarem -> Game Over
                        if(Tela.getTela().getVidas() <= 0){
                            Tela.getTela().gameOver();
                            return;
                        }
                        
                    // Sobre os inimigos
                    }else if(p1.isbMortal()){
                        p1 = (Inimigo) p1;
                        p1.checkCollision(p2);
                        
                    // Sobre os blocos
                    } else if(!p1.isbTransponivel()){
                        p1 = (Blocos) p1;
                        p1.checkCollision(p2);
                    }
                }
            }
        }
    }
    
    /*public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p){
        No fim, não foi necessário utilizar
    }*/
}
