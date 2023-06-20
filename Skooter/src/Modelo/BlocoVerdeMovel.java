package Modelo;

import java.io.Serializable;

public class BlocoVerdeMovel extends BlocoVerdeEstatico implements Serializable{
    
    public BlocoVerdeMovel(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMovel = true;
    }  
}