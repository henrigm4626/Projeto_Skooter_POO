package Controler;

import Auxiliar.Fase;
import Modelo.Personagem;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Salvar {
    
    // Salvando o jogo em um .zip file
    public static void saveGame(){
        File save = new File("save.zip");
        if (save.exists()) {
            try {
                save.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            FileOutputStream fileStream = new FileOutputStream(save);
            GZIPOutputStream compactor = new GZIPOutputStream(fileStream);
            ObjectOutputStream objectStream = new ObjectOutputStream(compactor);
        
            objectStream.writeObject(Fase.fase_atual);
            objectStream.writeObject(Fase.backgroundImg);
            objectStream.writeObject(Fase.mudancas);
            objectStream.writeObject(Tela.getTela().getVidas());
            
            for(Personagem p1 : Tela.getTela().getArrayPersonagens()){
                objectStream.writeObject(p1);
            }

            objectStream.close();
            compactor.close();
            fileStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Carregando um save existente a partir do .zip file
    public static void loadGame(){
        File save = new File("save.zip");
        if (!save.exists()) {
            System.out.println("Erro ao carregar arquivo");
        }
        try{
            FileInputStream fileStream = new FileInputStream(save);  
            GZIPInputStream descompactor = new GZIPInputStream(fileStream);
            ObjectInputStream inputStream = new ObjectInputStream(descompactor);
            
            Fase.fase_atual = (int) inputStream.readObject();
            Fase.backgroundImg = (String) inputStream.readObject();
            Fase.mudancas = (ArrayList<String>) inputStream.readObject();
            Tela.getTela().setVidas((int) inputStream.readObject());
            
            try{
                while(true){
                    Tela.getTela().addPersonagem((Personagem) inputStream.readObject());
                }
            } catch(EOFException eof){}
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
