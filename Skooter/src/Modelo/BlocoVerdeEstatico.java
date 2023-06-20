package Modelo;

import java.io.Serializable;

public class BlocoVerdeEstatico extends Blocos implements Serializable{
    
    public BlocoVerdeEstatico(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bDestrutivel = true;
    }
}
