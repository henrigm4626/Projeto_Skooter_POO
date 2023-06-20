package Controler;

import Modelo.Personagem;
//import Modelo.Caveira;
//import Modelo.Skoot;
//import Modelo.BichinhoVaiVemHorizontal;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Auxiliar.Fase;
import Modelo.InimigoGen;
import Modelo.Player;
//import Modelo.ZigueZague;
//import Auxiliar.Posicao;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;


public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {
    
    private static Tela invocada;
    private Player jogador;
    private ArrayList<Personagem> faseAtual;
    private ControleDeJogo cj = new ControleDeJogo();
    private Graphics g2;
    
    // Adicionando atributos
    private boolean await_key = true;
    private boolean loading = false;
    private int vidas = 3;

    public Tela() {
        Desenho.setCenario(this);
        initComponents();
        this.addMouseListener(this); /*mouse*/

        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        faseAtual = new ArrayList<Personagem>(100);

        // Inicia o menu incial do jogo
        this.proximaFase();
        
    }

    /*public boolean ehPosicaoValida(Posicao p){
        Substituída pelo "if" na função paint
    }*/
    
    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }

    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }
    
    // Utilizado na parte de salvar o jogo
    public void arrayReset(){
        faseAtual.clear();
    }
    
    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    public static Tela getTela(){
        if(invocada == null){
            invocada = new Tela();
        }
        
        return invocada;
    }
    
    public static boolean ehInvocada(){
        return (invocada != null);
    }
    
    @Override
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        
        /*************Desenha cenário de fundo**************/
        
        /* Alterou-se o funcionamento de desenhar a tela, uma vez que
        antes eram copiadas várias da mesma imagem para compor o cenário,
        porém, já que temos um menu e tela de game over, essa estratégia não era ideal.
        */
        try {
            
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + Fase.backgroundImg);
            g2.drawImage(newImage, 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Incluindo a condição para o loading
        if (!this.faseAtual.isEmpty() || !loading) {
            this.cj.processaTudo(faseAtual);
            this.cj.desenhaTudo(faseAtual);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }
    
        @Override
    public void keyPressed(KeyEvent e) { 
        if (e.getKeyCode() == KeyEvent.VK_C) {
            this.faseAtual.clear();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            jogador.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jogador.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jogador.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jogador.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_L) {
                loadGame();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
                saveGame();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(await_key){
                this.reiniciaFase();
                setAwait_key(false);
            }
            jogador.destroiPersonagem(faseAtual);
        }
        this.setTitle("-> Cell: " + (jogador.getPosicao().getColuna()) + ", "
        + (jogador.getPosicao().getLinha()));

        //repaint(); /* invoca o paint imediatamente, sem aguardar o refresh */
    }
    
        public void loadGame(){
        if(!this.loading){
            this.arrayReset();
            Salvar.loadGame();
            jogador = (Player) faseAtual.get(0);
        }
    }
    
    public void saveGame(){
        if(!loading){
            System.out.println("Jogo salvo!");
            Salvar.saveGame();
        }
    }
    
    public void proximaFase(){
        Fase.nextFase(faseAtual);
        jogador = (Player) faseAtual.get(0);
    }
    
    public void reiniciaFase(){
        Fase.resetFase(faseAtual);
        jogador = (Player) faseAtual.get(0);
    }
    
    public void gameOver(){
        Fase.gameOver(faseAtual);
        jogador = (Player) faseAtual.get(0);
        this.vidas = 3;
    }
    
    public boolean getLoading(){
        return loading;
    }
    
    public void setLoading(boolean loading){
        this.loading = loading;
    }
    
    public void setAwait_key(boolean esperandoTecla){
        this.await_key = esperandoTecla;
    }
    
    public ArrayList<Personagem> getArrayPersonagens(){
        return faseAtual;
    }
    
    public Player getPlayer(){
        return (Player) faseAtual.get(0);
    }
    
    public int getVidas(){
        return vidas;
    }
    
    public void setVidas(int total_vidas){
        vidas = total_vidas;
    }

    public int perdeVida(){
        vidas--;
        System.out.println("Você perdeu uma vida!");
        if(vidas == 0){
            System.out.println("Que pena, você morreu.");
        } else {
            System.out.println("Vidas: " + Tela.getTela().getVidas());
        }
        return vidas;
    }
    
    public void substituiPersonagem(Personagem p){
        int col = p.pPosition.getColuna();
        int lin = p.pPosition.getLinha();
        
        faseAtual.remove(p);
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File arqPersonagem = null;
         
        this.loading = true;
        int valorRetornado = chooser.showOpenDialog(null);
        if(valorRetornado == JFileChooser.APPROVE_OPTION) {
            arqPersonagem = chooser.getSelectedFile();
        }
        
        if (!arqPersonagem.exists()) {
            System.out.println("Falha em carregar arquivo");
        }
        try{
            FileInputStream fileStream = new FileInputStream(arqPersonagem);
            ObjectInputStream inputStream = new ObjectInputStream(fileStream);
            
            Personagem novoPersonagem = (Personagem) inputStream.readObject();
            novoPersonagem.setPosicao(lin, col);
            if(novoPersonagem instanceof InimigoGen){
                ((InimigoGen) novoPersonagem).resetaImagem();
            }
            faseAtual.add(novoPersonagem);
            
            fileStream.close();
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.loading = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.jogador.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        repaint();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
