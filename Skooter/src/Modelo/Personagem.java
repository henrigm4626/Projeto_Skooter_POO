package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Personagem implements Serializable {

    protected ImageIcon iImage;
    public Posicao pPosition;
    protected boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bMortal;       /*Se encostar, morre?*/
    protected boolean bAnimado;
    protected boolean bColetavel;
    protected boolean bDestrutivel;
    protected boolean bMovel;
    protected char lookingTo;
   


    protected Personagem(String sNomeImagePNG) {
        this.pPosition = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bMortal = false;
        this.bAnimado = false;
        this.bColetavel = false;
        this.bDestrutivel = false;
        this.bMovel = false;
        this.lookingTo = 'D';
        try {
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Posicao getPosicao() {
        return pPosition;
    }

    public boolean isbTransponivel() {
        return bTransponivel;
    }

    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }
    
    public boolean isbMortal() {
        return bMortal;
    }

    public boolean isbColetavel() {
        return bColetavel;
    }

    public boolean isbDestrutivel() {
        return bDestrutivel;
    }

    public boolean isbMovel() {
        return bMovel;
    } 
    
    public char getLookingTo(){
        return this.lookingTo;
    }
    
    public void setLookingTo(char direcao){
        this.lookingTo = direcao;
    }

    public void autoDesenho(){
        Desenho.desenhar(this.iImage, this.pPosition.getColuna(), this.pPosition.getLinha());        
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosition.setPosicao(linha, coluna);
    }

    public boolean moveUp() {
        this.setLookingTo('U');
        return this.pPosition.moveUp();
    }

    public boolean moveDown() {
        this.setLookingTo('D');
        return this.pPosition.moveDown();
    }

    public boolean moveRight() {
        this.setLookingTo('R');
        return this.pPosition.moveRight();
    }

    public boolean moveLeft() {
        this.setLookingTo('L');
        return this.pPosition.moveLeft();
    }
    
    public boolean checkPosition(int linha, int coluna) {
        for (Personagem pTemp : Tela.getTela().getArrayPersonagens()){
            if(pTemp != this){
                if (pTemp.pPosition.getLinha() == linha) {
                    if (pTemp.pPosition.getColuna() == coluna) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public abstract void checkCollision(Personagem pTemp);
    
    public char lastPosition() {
        if (this.pPosition.getLinhaAnterior() == this.pPosition.getLinha()) {
            if (this.pPosition.getColuna() < this.pPosition.getColunaAnterior()) {
                return 'R';
            } else if (this.pPosition.getColuna() > this.pPosition.getColunaAnterior()) {
                return 'L';
            }
        } else if (this.pPosition.getColunaAnterior() == this.pPosition.getColuna()) {
            if (this.pPosition.getLinha() < this.pPosition.getLinhaAnterior()) {
                return 'D';
            } else if (this.pPosition.getLinha() > this.pPosition.getLinhaAnterior()) {
                return 'U';
            }
        }
        return 'M';
    }
    
    public boolean goToLastPosition(){
        return this.pPosition.volta();
    }
    
}

