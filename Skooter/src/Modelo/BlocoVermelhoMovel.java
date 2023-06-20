package Modelo;

import java.io.Serializable;

public class BlocoVermelhoMovel extends BlocoVermelhoEstatico implements Serializable{
    
    public BlocoVermelhoMovel(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMovel = true;
    }  
}