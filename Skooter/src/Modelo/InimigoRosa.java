package Modelo;

import java.io.Serializable;

public class InimigoRosa extends Inimigo implements Serializable{
    int tentativa  = 0;

    public InimigoRosa(String sNomeImagePNG, Player img_player) {
        super(sNomeImagePNG);
        this.img_player = img_player;
    }
    
    @Override
    public boolean move(){
        if (img_player.pPosition.getLinha() > pPosition.getLinha() && tentativa < 1) {
            if(!moveDown()){
                tentativa = 1;
                this.move();
            }
        } else if (img_player.pPosition.getLinha() < pPosition.getLinha() && tentativa < 2) {
            if(!moveUp()){
                tentativa = 2;
                this.move();
            }
        } else if (img_player.pPosition.getColuna() > pPosition.getColuna() && tentativa < 3) {
            if(!moveRight()){
                tentativa = 3;
                this.move();
            }
        } else if (img_player.pPosition.getColuna() < pPosition.getColuna() && tentativa < 4) {
            if(!moveLeft()){
                tentativa = 4;
                this.move();
            }
        }
        tentativa = 0;
        
        return true;
    }
    
    @Override
    public boolean moveUp() {
        if (this.checkPosition(this.pPosition.getLinha() - 1, this.pPosition.getColuna())) {
            return super.moveUp();
        } else {
            return false;
        }
    }

    @Override
    public boolean moveDown() {
        if (this.checkPosition(this.pPosition.getLinha() + 1, this.pPosition.getColuna())) {
            return super.moveDown();
        } else {
            return false;
        }
    }

    @Override
    public boolean moveRight() {
        if (this.checkPosition(this.pPosition.getLinha(), this.pPosition.getColuna() + 1)) {
            return super.moveRight();
        } else {
            return false;
        }
    }

    @Override
    public boolean moveLeft() {
        if (this.checkPosition(this.pPosition.getLinha(), this.pPosition.getColuna() - 1)) {
            return super.moveLeft();
        } else {
            return false;
        }
    }
}