package Controler;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Tela tTela = Tela.getTela();
                tTela.setVisible(true);
                tTela.createBufferStrategy(2);
                tTela.go();
            }
        });
    }
}

