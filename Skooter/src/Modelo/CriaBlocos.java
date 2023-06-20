package Modelo;

public class CriaBlocos {
    
    public static Blocos criaBloco(String tipo){
        if(tipo.equalsIgnoreCase("verde")){
            return new BlocoVerdeEstatico("blocoVerde.png");
        } else if(tipo.equals("verdeMovel")){
            return new BlocoVerdeMovel("blocoVerdeMovel.png");
        } else if(tipo.equals("vermelho")){
            return new BlocoVermelhoEstatico("blocoVermelho.png");
        } else if(tipo.equals("vermelhoMovel")){
            return new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        } else{
            return null;
        }
    }
}
