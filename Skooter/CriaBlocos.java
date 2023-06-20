package Modelo;

public class CriaBlocos {
    
    public static Blocos criaBloco(String tipo){
        if(tipo.equalsIgnoreCase("verde")){
            return new BlocoVerdeEstatico("bloco_verde.png");
        } else if(tipo.equals("verdeMovel")){
            return new BlocoVerdeMovel("bloco_verde_movel.png");
        } else if(tipo.equals("vermelho")){
            return new BlocoVermelhoEstatico("bloco_vermelho.png");
        } else if(tipo.equals("vermelhoMovel")){
            return new BlocoVermelhoMovel("bloco_vermelho_movel.png");
        } else{
            return null;
        }
    }
}
