package Modelo;

import java.io.Serializable;

public class BlocoVermelhoEstatico extends Blocos implements Serializable{
    
    public BlocoVermelhoEstatico(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bDestrutivel = false;
    }
}