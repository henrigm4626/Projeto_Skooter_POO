package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;


public abstract class Animado extends Personagem{
    protected ImageIcon[] iImages;
    
    public Animado(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bAnimado = true;
        
        // Associa a imagem correta com base na sua direção
        try {
            iImages = new ImageIcon[4];
            char dir = 'A';
            for(int i = 0; i < 4; i++){
                switch (i) {
                    case 0:
                        dir = 'U';
                        break;
                    case 1:
                        dir = 'D';
                        break;
                    case 2:
                        dir = 'L';
                        break;
                    case 3:
                        dir = 'R';
                        break;
                    default:
                        break;
                }
                
                iImages[i] = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG.replace(".", dir + "."));
                Image img = iImages[i].getImage();
                BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                iImages[i] = new ImageIcon(bi);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // Desenha a imagem apropriada
    @Override
    public void autoDesenho(){
        switch (this.getLookingTo()) {
            case 'U':
                Desenho.desenhar(this.iImages[0], pPosition.getColuna(), pPosition.getLinha());
                break;
            case 'D':
                Desenho.desenhar(this.iImages[1], pPosition.getColuna(), pPosition.getLinha());
                break;
            case 'L':
                Desenho.desenhar(this.iImages[2], pPosition.getColuna(), pPosition.getLinha());
                break;
            case 'R':
                Desenho.desenhar(this.iImages[3], pPosition.getColuna(), pPosition.getLinha());
                break;
            default:
                break;
        }
    }
}