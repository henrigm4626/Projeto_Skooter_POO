package Modelo;

import java.io.Serializable;

public abstract class Blocos extends Personagem implements Serializable {

    protected Blocos(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
    }

    @Override
    public void checkCollision(Personagem pTemp) {
        if(pTemp instanceof InimigoGen)
            return;
        if (this.isbMovel()) {
            // Sobre o bloco movel
            if (!pTemp.isbTransponivel() || pTemp.isbColetavel()) {
                this.goToLastPosition();
            } else if (pTemp.isbMortal()) {
                pTemp.goToLastPosition();
            }
        } else {
            //Sobre bloco imovel
            pTemp.goToLastPosition();
        }
    }

    public boolean move(char lastDirPlayer) {
        switch (lastDirPlayer) {
            case 'R':
                return this.moveLeft();
            case 'L':
                return this.moveRight();
            case 'U':
                return this.moveDown();
            case 'D':
                return this.moveUp();
            default:
                break;
        }
        return false;
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
