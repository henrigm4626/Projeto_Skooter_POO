/*Código não utilizado no contexto do Skooter (ver "Inimigo(x).java" para mais informações)
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BichinhoVaiVemHorizontal extends Personagem  implements Serializable{
    private boolean bRight;

    public BichinhoVaiVemHorizontal(String sNomeImagePNG) {
        super(sNomeImagePNG);
        bRight = true;
    }
    public void autoDesenho(){
        if(bRight)
            this.setPosicao(pPosition.getLinha(), pPosition.getColuna()+1);
        else
            this.setPosicao(pPosition.getLinha(), pPosition.getColuna()-1);           

        super.autoDesenho();
        bRight = !bRight;
    }
}
*/