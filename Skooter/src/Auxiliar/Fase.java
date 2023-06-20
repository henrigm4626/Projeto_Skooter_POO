package Auxiliar;

import Controler.Tela;
import Modelo.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Fase {
    public static int fase_atual = 0;
    public static String backgroundImg;
    public static ArrayList<String> mudancas;
    
    public static void nextFase(ArrayList<Personagem> pPersonagens) {
        if(fase_atual == 0){
            Fase.criaTransicoes();
        }
        pPersonagens.clear();
        Fase.changeFase(pPersonagens, mudancas.get(fase_atual));
        fase_atual++;
    }
    
    public static void resetFase(ArrayList<Personagem> pPersonagens){
        pPersonagens.clear();
        Fase.startFase(fase_atual, pPersonagens);
    }
    
    public static void gameOver(ArrayList<Personagem> pPersonagens) {
        pPersonagens.clear();
        backgroundImg = "game_over.png";
        
        Player p_player = new Player("");
        pPersonagens.add(p_player);
        
        Tela.getTela().setAwait_key(true);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                fase_atual = 0;
                Fase.nextFase(pPersonagens);
            }
        }, 5000);
    }
    
    private static void startFase(int numFase, ArrayList<Personagem> faseAtual){
        if(numFase == 1)
            faseAtual.addAll(primeiraFase());
        if(numFase == 2)
            faseAtual.addAll(segundaFase());
        if(numFase == 3)
            faseAtual.addAll(terceiraFase());
        if(numFase == 4)
            faseAtual.addAll(quartaFase());
        if(numFase == 5)
            faseAtual.addAll(quintaFase());
    }
    
    private static void criaTransicoes(){
        mudancas = new ArrayList<>();
        mudancas.add("main_menu.png");
        mudancas.add("loading_screen1.png");
        mudancas.add("loading_screen2.png");
        mudancas.add("loading_screen3.png");
        mudancas.add("loading_screen4.png");
        mudancas.add("victory_screen.png");
    }
    
    //Cria uma fase vazia e sem musica so com o background de transicao
    private static void changeFase(ArrayList<Personagem> pPersonagens, String telaTransicao){
        backgroundImg = telaTransicao;
        int delay;
        
        Player p_player = new Player("");
        pPersonagens.add(p_player);
        
        if(fase_atual > 0){
            Tela.getTela().setLoading(true);
            delay = 3000;
            
            if(fase_atual == 5){
                delay += 5000;
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    if(fase_atual == 6){
                        System.exit(0);
                    }else{
                        pPersonagens.clear();
                        Fase.startFase(fase_atual, pPersonagens);
                        Tela.getTela().setLoading(false);
                        Tela.getTela().reiniciaFase();
                    }
                }
            }, delay);
        }
    }
    
    // DECLARANDO AS FASES
    private static ArrayList<Personagem> primeiraFase() {
        backgroundImg = "background1.png";

        ArrayList<Personagem> fase1 = new ArrayList<>();
        
        // PLAYER
        Player p_player = new Player("skooter.png");
        p_player.setPosicao(4, 4);
        fase1.add(p_player);
        
        // INIMIGOS
        InimigoRosa inimigo_Rosa1 = new InimigoRosa("inimigo_rosa.png", p_player);
        inimigo_Rosa1.setPosicao(10, 1);
        fase1.add(inimigo_Rosa1);

        InimigoRosa inimigo_Rosa2 = new InimigoRosa("inimigo_rosa.png", p_player);
        inimigo_Rosa2.setPosicao(0, 9);
        fase1.add(inimigo_Rosa2);

        InimigoAzul inimigo_Azul1 = new InimigoAzul("inimigo_azul.png", p_player);
        inimigo_Azul1.setPosicao(2, 0);
        fase1.add(inimigo_Azul1);

        InimigoAmarelo inimigo_Amarelo1 = new InimigoAmarelo("inimigo_amarelo.png", p_player);
        inimigo_Amarelo1.setPosicao(10, 9);
        fase1.add(inimigo_Amarelo1);

        // BLOCOS ESTATICOS
        Blocos blocoImovel1 = CriaBlocos.criaBloco("vermelho");
        blocoImovel1.setPosicao(1, 1);
        fase1.add(blocoImovel1);

        Blocos blocoImovel2 = CriaBlocos.criaBloco("vermelho");
        blocoImovel2.setPosicao(1, 3);
        fase1.add(blocoImovel2);

        Blocos blocoImovel3 = CriaBlocos.criaBloco("vermelho");
        blocoImovel3.setPosicao(1, 5);
        fase1.add(blocoImovel3);

        Blocos blocoImovel4 = CriaBlocos.criaBloco("vermelho");
        blocoImovel4.setPosicao(1, 7);
        fase1.add(blocoImovel4);

        Blocos blocoImovel5 = CriaBlocos.criaBloco("vermelho");
        blocoImovel5.setPosicao(1, 9);
        fase1.add(blocoImovel5);

        Blocos blocoImovel6 = CriaBlocos.criaBloco("vermelho");
        blocoImovel6.setPosicao(3, 1);
        fase1.add(blocoImovel6);

        Blocos blocoImovel7 = CriaBlocos.criaBloco("vermelho");
        blocoImovel7.setPosicao(3, 3);
        fase1.add(blocoImovel7);

        Blocos blocoImovel8 = CriaBlocos.criaBloco("vermelho");
        blocoImovel8.setPosicao(3, 5);
        fase1.add(blocoImovel8);

        Blocos blocoImovel9 = CriaBlocos.criaBloco("vermelho");
        blocoImovel9.setPosicao(3, 7);
        fase1.add(blocoImovel9);

        Blocos blocoImovel10 = CriaBlocos.criaBloco("vermelho");
        blocoImovel10.setPosicao(3, 9);
        fase1.add(blocoImovel10);

        Blocos blocoImovel11 = CriaBlocos.criaBloco("vermelho");
        blocoImovel11.setPosicao(5, 1);
        fase1.add(blocoImovel11);

        Blocos blocoImovel12 = CriaBlocos.criaBloco("vermelho");
        blocoImovel12.setPosicao(5, 3);
        fase1.add(blocoImovel12);

        Blocos blocoImovel13 = CriaBlocos.criaBloco("vermelho");
        blocoImovel13.setPosicao(5, 5);
        fase1.add(blocoImovel13);

        Blocos blocoImovel14 = CriaBlocos.criaBloco("vermelho");
        blocoImovel14.setPosicao(5, 7);
        fase1.add(blocoImovel14);

        Blocos blocoImovel15 = CriaBlocos.criaBloco("vermelho");
        blocoImovel15.setPosicao(5, 9);
        fase1.add(blocoImovel15);

        Blocos blocoImovel16 = CriaBlocos.criaBloco("vermelho");
        blocoImovel16.setPosicao(7, 1);
        fase1.add(blocoImovel16);

        Blocos blocoImovel17 = CriaBlocos.criaBloco("vermelho");
        blocoImovel17.setPosicao(7, 3);
        fase1.add(blocoImovel17);

        Blocos blocoImovel18 = CriaBlocos.criaBloco("vermelho");
        blocoImovel18.setPosicao(7, 5);
        fase1.add(blocoImovel18);

        Blocos blocoImovel19 = CriaBlocos.criaBloco("vermelho");
        blocoImovel19.setPosicao(7, 9);
        fase1.add(blocoImovel19);

        Blocos blocoImovel20 = CriaBlocos.criaBloco("vermelho");
        blocoImovel20.setPosicao(9, 1);
        fase1.add(blocoImovel20);

        Blocos blocoImovel21 = CriaBlocos.criaBloco("vermelho");
        blocoImovel21.setPosicao(9, 3);
        fase1.add(blocoImovel21);

        Blocos blocoImovel22 = CriaBlocos.criaBloco("vermelho");
        blocoImovel22.setPosicao(9, 5);
        fase1.add(blocoImovel22);

        Blocos blocoImovel23 = CriaBlocos.criaBloco("vermelho");
        blocoImovel23.setPosicao(9, 7);
        fase1.add(blocoImovel23);

        Blocos blocoImovel24 = CriaBlocos.criaBloco("vermelho");
        blocoImovel24.setPosicao(9, 9);
        fase1.add(blocoImovel24);

        Blocos blocoImovel25 = CriaBlocos.criaBloco("vermelho");
        blocoImovel25.setPosicao(7, 7);
        fase1.add(blocoImovel25);

        
        // BLOCOS MOVEIS
        Blocos blocoMovel1 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel1.setPosicao(3, 0);
        fase1.add(blocoMovel1);

        Blocos blocoMovel2 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel2.setPosicao(9, 0);
        fase1.add(blocoMovel2);

        Blocos blocoMovel3 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel3.setPosicao(0, 1);
        fase1.add(blocoMovel3);

        Blocos blocoMovel4 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel4.setPosicao(2, 1);
        fase1.add(blocoMovel4);

        Blocos blocoMovel5 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel5.setPosicao(4, 1);
        fase1.add(blocoMovel5);

        Blocos blocoMovel6 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel6.setPosicao(8, 3);
        fase1.add(blocoMovel6);

        Blocos blocoMovel7 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel7.setPosicao(1, 2);
        fase1.add(blocoMovel7);

        Blocos blocoMovel8 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel8.setPosicao(5, 2);
        fase1.add(blocoMovel8);

        Blocos blocoMovel9 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel9.setPosicao(9, 2);
        fase1.add(blocoMovel9);

        Blocos blocoMovel10 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel10.setPosicao(0, 5);
        fase1.add(blocoMovel10);

        Blocos blocoMovel11 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel11.setPosicao(2, 5);
        fase1.add(blocoMovel11);

        Blocos blocoMovel13 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel13.setPosicao(6, 5);
        fase1.add(blocoMovel13);

        Blocos blocoMovel14 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel14.setPosicao(9, 6);
        fase1.add(blocoMovel14);

        Blocos blocoMovel15 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel15.setPosicao(1, 10);
        fase1.add(blocoMovel15);

        Blocos blocoMovel16 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel16.setPosicao(7, 10);
        fase1.add(blocoMovel16);

        Blocos blocoMovel17 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel17.setPosicao(4, 9);
        fase1.add(blocoMovel17);

        Blocos blocoMovel18 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel18.setPosicao(9, 8);
        fase1.add(blocoMovel18);

        Blocos blocoMovel19 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel19.setPosicao(6, 7);
        fase1.add(blocoMovel19);

        Blocos blocoMovel21 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel21.setPosicao(8, 9);
        fase1.add(blocoMovel21);

        Blocos blocoMovel22 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel22.setPosicao(10, 7);
        fase1.add(blocoMovel22);

        Blocos blocoMovel23 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel23.setPosicao(5, 6);
        fase1.add(blocoMovel23);

        Blocos blocoMovel24 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel24.setPosicao(7, 8);
        fase1.add(blocoMovel24);

        Blocos blocoMovel25 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel25.setPosicao(3, 8);
        fase1.add(blocoMovel25);

        Blocos blocoMovel26 = CriaBlocos.criaBloco("verdeMovel");
        blocoMovel26.setPosicao(1, 8);
        fase1.add(blocoMovel26);

        
        // COLETAVEIS
        Coletaveis cereja = new Coletaveis("c_cereja.png");
        cereja.setPosicao(10, 10);
        fase1.add(cereja);

        Coletaveis limao = new Coletaveis("c_limao.png");
        limao.setPosicao(0, 10);
        fase1.add(limao);

        Coletaveis morango = new Coletaveis("c_morango.png");
        morango.setPosicao(10, 0);
        fase1.add(morango);

        Coletaveis uva = new Coletaveis("c_uva.png");
        uva.setPosicao(0, 0);
        fase1.add(uva);

        return fase1;
    }
    
    public static ArrayList<Personagem> segundaFase() {
        backgroundImg = "background2.png";

        ArrayList<Personagem> fase2 = new ArrayList<>();
        
        // PLAYER
        Player p_player = new Player("skooter.png");
        p_player.setPosicao(5, 5);
        fase2.add(p_player);

        // INIMIGOS
        InimigoVerde inimigo_verde1 = new InimigoVerde("inimigo_verde.png");
        inimigo_verde1.setPosicao(1, 1);
        fase2.add(inimigo_verde1);

        InimigoAmarelo inimigo_amarelo1 = new InimigoAmarelo("inimigo_amarelo.png", p_player);
        inimigo_amarelo1.setPosicao(1, 9);
        fase2.add(inimigo_amarelo1);

        InimigoAzul inimigo_azul1 = new InimigoAzul("inimigo_azul.png", p_player);
        inimigo_azul1.setPosicao(9, 9);
        fase2.add(inimigo_azul1);

        InimigoRosa inimigo_rosa1 = new InimigoRosa("inimigo_rosa.png", p_player);
        inimigo_rosa1.setPosicao(9, 1);
        fase2.add(inimigo_rosa1);

        // SETAS PARA CIMA
        Seta setaCima1 = new Seta("arrow_up.png", 'U');
        setaCima1.setPosicao(3, 0);
        fase2.add(setaCima1);

        Seta setaCima2 = new Seta("arrow_up.png", 'U');
        setaCima2.setPosicao(4, 0);
        fase2.add(setaCima2);

        Seta setaCima3 = new Seta("arrow_up.png", 'U');
        setaCima3.setPosicao(5, 0);
        fase2.add(setaCima3);

        Seta setaCima4 = new Seta("arrow_up.png", 'U');
        setaCima4.setPosicao(6, 0);
        fase2.add(setaCima4);

        Seta setaCima5 = new Seta("arrow_up.png", 'U');
        setaCima5.setPosicao(7, 0);
        fase2.add(setaCima5);

        Seta setaCima6 = new Seta("arrow_up.png", 'U');
        setaCima6.setPosicao(3, 8);
        fase2.add(setaCima6);

        Seta setaCima7 = new Seta("arrow_up.png", 'U');
        setaCima7.setPosicao(4, 8);
        fase2.add(setaCima7);

        Seta setaCima8 = new Seta("arrow_up.png", 'U');
        setaCima8.setPosicao(3, 6);
        fase2.add(setaCima8);

        Seta setaCima9 = new Seta("arrow_up.png", 'U');
        setaCima9.setPosicao(7, 6);
        fase2.add(setaCima9);

        Seta setaCima10 = new Seta("arrow_up.png", 'U');
        setaCima10.setPosicao(7, 8);
        fase2.add(setaCima10);

        Seta setaCima11 = new Seta("arrow_up.png", 'U');
        setaCima11.setPosicao(7, 10);
        fase2.add(setaCima11);

        // SETAS PARA BAIXO
        Seta setaBaixo1 = new Seta("arrow_down.png", 'D');
        setaBaixo1.setPosicao(3, 2);
        fase2.add(setaBaixo1);

        Seta setaBaixo2 = new Seta("arrow_down.png", 'D');
        setaBaixo2.setPosicao(7, 2);
        fase2.add(setaBaixo2);

        Seta setaBaixo3 = new Seta("arrow_down.png", 'D');
        setaBaixo3.setPosicao(3, 10);
        fase2.add(setaBaixo3);

        Seta setaBaixo4 = new Seta("arrow_down.png", 'D');
        setaBaixo4.setPosicao(3, 4);
        fase2.add(setaBaixo4);

        Seta setaBaixo5 = new Seta("arrow_down.png", 'D');
        setaBaixo5.setPosicao(7, 4);
        fase2.add(setaBaixo5);

        Seta setaBaixo6 = new Seta("arrow_down.png", 'D');
        setaBaixo6.setPosicao(2, 4);
        fase2.add(setaBaixo6);

        // SETAS PARA DIREITA
        Seta setaDireita1 = new Seta("arrow_right.png", 'R');
        setaDireita1.setPosicao(0, 3);
        fase2.add(setaDireita1);

        Seta setaDireita2 = new Seta("arrow_right.png", 'R');
        setaDireita2.setPosicao(2, 3);
        fase2.add(setaDireita2);

        Seta setaDireita3 = new Seta("arrow_right.png", 'R');
        setaDireita3.setPosicao(4, 3);
        fase2.add(setaDireita3);

        Seta setaDireita4 = new Seta("arrow_right.png", 'R');
        setaDireita4.setPosicao(6, 3);
        fase2.add(setaDireita4);

        Seta setaDireita5 = new Seta("arrow_right.png", 'R');
        setaDireita5.setPosicao(8, 3);
        fase2.add(setaDireita5);

        Seta setaDireita6 = new Seta("arrow_right.png", 'R');
        setaDireita6.setPosicao(0, 7);
        fase2.add(setaDireita6);

        Seta setaDireita7 = new Seta("arrow_right.png", 'R');
        setaDireita7.setPosicao(4, 7);
        fase2.add(setaDireita7);

        Seta setaDireita8 = new Seta("arrow_right.png", 'R');
        setaDireita8.setPosicao(8, 7);
        fase2.add(setaDireita8);

        Seta setaDireita9 = new Seta("arrow_right.png", 'R');
        setaDireita9.setPosicao(10, 7);
        fase2.add(setaDireita9);

        // SETAS PARA ESQUERDA
        Seta setaEsquerda1 = new Seta("arrow_left.png", 'L');
        setaEsquerda1.setPosicao(10, 3);
        fase2.add(setaEsquerda1);

        Seta setaEsquerda2 = new Seta("arrow_left.png", 'L');
        setaEsquerda2.setPosicao(2, 7);
        fase2.add(setaEsquerda2);

        Seta setaEsquerda3 = new Seta("arrow_left.png", 'L');
        setaEsquerda3.setPosicao(6, 7);
        fase2.add(setaEsquerda3);

        Seta setaEsquerda4 = new Seta("arrow_left.png", 'L');
        setaEsquerda4.setPosicao(4, 9);
        fase2.add(setaEsquerda4);

        Seta setaEsquerda5 = new Seta("arrow_left.png", 'L');
        setaEsquerda5.setPosicao(4, 10);
        fase2.add(setaEsquerda5);

        Seta setaEsquerda6 = new Seta("arrow_left.png", 'L');
        setaEsquerda6.setPosicao(2, 5);
        fase2.add(setaEsquerda6);

        Seta setaEsquerda7 = new Seta("arrow_left.png", 'L');
        setaEsquerda7.setPosicao(2, 6);
        fase2.add(setaEsquerda7);
        
        // BLOCOS ESTATICOS
        Blocos blocoImovel1 = CriaBlocos.criaBloco("vermelho");
        blocoImovel1.setPosicao(3, 1);
        fase2.add(blocoImovel1);

        Blocos blocoImovel2 = CriaBlocos.criaBloco("vermelho");
        blocoImovel2.setPosicao(7, 1);
        fase2.add(blocoImovel2);

        Blocos blocoImovel3 = CriaBlocos.criaBloco("vermelho");
        blocoImovel3.setPosicao(3, 5);
        fase2.add(blocoImovel3);

        Blocos blocoImovel4 = CriaBlocos.criaBloco("vermelho");
        blocoImovel4.setPosicao(7, 5);
        fase2.add(blocoImovel4);

        Blocos blocoImovel5 = CriaBlocos.criaBloco("vermelho");
        blocoImovel5.setPosicao(3, 9);
        fase2.add(blocoImovel5);

        Blocos blocoImovel6 = CriaBlocos.criaBloco("vermelho");
        blocoImovel6.setPosicao(7, 9);
        fase2.add(blocoImovel6);

        Blocos blocoImovel7 = CriaBlocos.criaBloco("vermelho");
        blocoImovel7.setPosicao(1, 3);
        fase2.add(blocoImovel7);

        Blocos blocoImovel8 = CriaBlocos.criaBloco("vermelho");
        blocoImovel8.setPosicao(3, 3);
        fase2.add(blocoImovel8);

        Blocos blocoImovel9 = CriaBlocos.criaBloco("vermelho");
        blocoImovel9.setPosicao(5, 3);
        fase2.add(blocoImovel9);

        Blocos blocoImovel9_ = CriaBlocos.criaBloco("vermelho");
        blocoImovel9_.setPosicao(7, 3);
        fase2.add(blocoImovel9_);

        Blocos blocoImovel10 = CriaBlocos.criaBloco("vermelho");
        blocoImovel10.setPosicao(9, 3);
        fase2.add(blocoImovel10);

        Blocos blocoImovel11 = CriaBlocos.criaBloco("vermelho");
        blocoImovel11.setPosicao(1, 7);
        fase2.add(blocoImovel11);

        Blocos blocoImovel12 = CriaBlocos.criaBloco("vermelho");
        blocoImovel12.setPosicao(3, 7);
        fase2.add(blocoImovel12);

        Blocos blocoImovel13 = CriaBlocos.criaBloco("vermelho");
        blocoImovel13.setPosicao(5, 7);
        fase2.add(blocoImovel13);

        Blocos blocoImovel14 = CriaBlocos.criaBloco("vermelho");
        blocoImovel14.setPosicao(7, 7);
        fase2.add(blocoImovel14);

        Blocos blocoImovel15 = CriaBlocos.criaBloco("vermelho");
        blocoImovel15.setPosicao(9, 7);
        fase2.add(blocoImovel15);

        // FRUTAS
        Coletaveis cereja = new Coletaveis("c_cereja.png");
        cereja.setPosicao(9, 5);
        fase2.add(cereja);

        Coletaveis morango = new Coletaveis("c_morango.png");
        morango.setPosicao(5, 9);
        fase2.add(morango);

        Coletaveis uva = new Coletaveis("c_uva.png");
        uva.setPosicao(1, 5);
        fase2.add(uva);

        Coletaveis limao = new Coletaveis("c_limao.png");
        limao.setPosicao(5, 1);
        fase2.add(limao);

        return fase2;
    }

    public static ArrayList<Personagem> terceiraFase() {
        backgroundImg = "background3.png";
        
        ArrayList<Personagem> fase3 = new ArrayList<>();
        
        // PLAYER
        Player p_player = new Player("skooter.png");
        p_player.setPosicao(5, 5);
        fase3.add(p_player);
        
        // BLOCOS VERMELHOS MÓVEIS
        Blocos blocoMovel1 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel1.setPosicao(1, 1);
        fase3.add(blocoMovel1);
        
        Blocos blocoMovel2 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel2.setPosicao(1, 2);
        fase3.add(blocoMovel2);
        
        Blocos blocoMovel3 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel3.setPosicao(1, 3);
        fase3.add(blocoMovel3);
        
        Blocos blocoMovel4 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel4.setPosicao(1, 4);
        fase3.add(blocoMovel4);
        
        Blocos blocoMovel5 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel5.setPosicao(1, 5);
        fase3.add(blocoMovel5);
        
        Blocos blocoMovel6 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel6.setPosicao(1, 6);
        fase3.add(blocoMovel6);
        
        Blocos blocoMovel7 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel7.setPosicao(1, 7);
        fase3.add(blocoMovel7);
        
        Blocos blocoMovel8 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel8.setPosicao(1, 8);
        fase3.add(blocoMovel8);
        
        Blocos blocoMovel9 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel9.setPosicao(1, 9);
        fase3.add(blocoMovel9);
        
        Blocos blocoMovel10 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel10.setPosicao(2, 1);
        fase3.add(blocoMovel10);
        
        Blocos blocoMovel11 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel11.setPosicao(3, 1);
        fase3.add(blocoMovel11);
        
        Blocos blocoMovel12 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel12.setPosicao(4, 1);
        fase3.add(blocoMovel12);
        
        Blocos blocoMovel13 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel13.setPosicao(5, 1);
        fase3.add(blocoMovel13);
        
        Blocos blocoMovel14 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel14.setPosicao(6, 1);
        fase3.add(blocoMovel14);
        
        Blocos blocoMovel15 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel15.setPosicao(7, 1);
        fase3.add(blocoMovel15);
        
        Blocos blocoMovel16 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel16.setPosicao(8, 1);
        fase3.add(blocoMovel16);
        
        Blocos blocoMovel17 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel17.setPosicao(9, 1);
        fase3.add(blocoMovel17);
        
        Blocos blocoMovel18 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel18.setPosicao(9, 2);
        fase3.add(blocoMovel18);
        
        Blocos blocoMovel19 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel19.setPosicao(9, 3);
        fase3.add(blocoMovel19);
        
        Blocos blocoMovel20 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel20.setPosicao(9, 4);
        fase3.add(blocoMovel20);
        
        Blocos blocoMovel21 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel21.setPosicao(9, 5);
        fase3.add(blocoMovel21);
        
        Blocos blocoMovel22 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel22.setPosicao(9, 6);
        fase3.add(blocoMovel22);
        
        Blocos blocoMovel23 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel23.setPosicao(9, 7);
        fase3.add(blocoMovel23);
        
        Blocos blocoMovel24 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel24.setPosicao(9, 8);
        fase3.add(blocoMovel24);
        
        Blocos blocoMovel25 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel25.setPosicao(9, 9);
        fase3.add(blocoMovel25);
        
        Blocos blocoMovel26 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel26.setPosicao(2, 9);
        fase3.add(blocoMovel26);
        
        Blocos blocoMovel27 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel27.setPosicao(3, 9);
        fase3.add(blocoMovel27);
        
        Blocos blocoMovel28 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel28.setPosicao(4, 9);
        fase3.add(blocoMovel28);
        
        Blocos blocoMovel29 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel29.setPosicao(5, 9);
        fase3.add(blocoMovel29);
        
        Blocos blocoMovel30 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel30.setPosicao(6, 9);
        fase3.add(blocoMovel30);
        
        Blocos blocoMovel31 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel31.setPosicao(7, 9);
        fase3.add(blocoMovel31);
        
        Blocos blocoMovel32 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel32.setPosicao(8, 9);
        fase3.add(blocoMovel32);
        
        Blocos blocoMovel33 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel33.setPosicao(3, 3);
        fase3.add(blocoMovel33);
        
        Blocos blocoMovel34 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel34.setPosicao(3, 4);
        fase3.add(blocoMovel34);
        
        Blocos blocoMovel35 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel35.setPosicao(3, 5);
        fase3.add(blocoMovel35);
        
        Blocos blocoMovel36 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel36.setPosicao(3, 6);
        fase3.add(blocoMovel36);
        
        Blocos blocoMovel37 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel37.setPosicao(3, 7);
        fase3.add(blocoMovel37);
                
        Blocos blocoMovel38 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel38.setPosicao(4, 7);
        fase3.add(blocoMovel38);
        
        Blocos blocoMovel39 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel39.setPosicao(5, 7);
        fase3.add(blocoMovel39);
        
        Blocos blocoMovel40 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel40.setPosicao(6, 7);
        fase3.add(blocoMovel40);
        
        Blocos blocoMovel41 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel41.setPosicao(7, 7);
        fase3.add(blocoMovel41);
        
        Blocos blocoMovel42 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel42.setPosicao(7, 6);
        fase3.add(blocoMovel42);
        
        Blocos blocoMovel43 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel43.setPosicao(7, 5);
        fase3.add(blocoMovel43);
        
        Blocos blocoMovel44 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel44.setPosicao(7, 4);
        fase3.add(blocoMovel44);
        
        Blocos blocoMovel45 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel45.setPosicao(7, 3);
        fase3.add(blocoMovel45);
        
        Blocos blocoMovel46 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel46.setPosicao(6, 3);
        fase3.add(blocoMovel46);
        
        Blocos blocoMovel47 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel47.setPosicao(5, 3);
        fase3.add(blocoMovel47);
        
        Blocos blocoMovel48 = CriaBlocos.criaBloco("vermelhoMovel");
        blocoMovel48.setPosicao(4, 3);
        fase3.add(blocoMovel48);
        
        
        // COLETAVEIS
        Coletaveis lampada = new Coletaveis("c_lampada.png");
        lampada.setPosicao(5, 8);
        fase3.add(lampada);
        
        Coletaveis lanterna = new Coletaveis("c_lanterna.png");
        lanterna.setPosicao(5, 10);
        fase3.add(lanterna);
        
        Coletaveis sol = new Coletaveis("c_sol.png");
        sol.setPosicao(5, 0);
        fase3.add(sol);
        
        Coletaveis vela = new Coletaveis("c_vela.png");
        vela.setPosicao(5, 2);
        fase3.add(vela);
        
        
        // INIMIGOS
        InimigoRosa inimigo_rosa1 = new InimigoRosa("inimigo_rosa.png", p_player);
        inimigo_rosa1.setPosicao(2, 5);
        fase3.add(inimigo_rosa1);
        
        InimigoRosa inimigo_rosa2 = new InimigoRosa("inimigo_rosa.png", p_player);
        inimigo_rosa2.setPosicao(8, 5);
        fase3.add(inimigo_rosa2);
        
        InimigoAzul inimigo_azul1 = new InimigoAzul("inimigo_azul.png", p_player);
        inimigo_azul1.setPosicao(0, 5);
        fase3.add(inimigo_azul1);
        
        InimigoAzul inimigo_azul2 = new InimigoAzul("inimigo_azul.png", p_player);
        inimigo_azul2.setPosicao(10, 5);
        fase3.add(inimigo_azul2);
        
        return fase3;
    }

    public static ArrayList<Personagem> quartaFase() {
        backgroundImg = "background4.png";
        
        ArrayList<Personagem> fase4 = new ArrayList<>();
        
        // PLAYER
        Player p_player = new Player("skooter.png");
        p_player.setPosicao(4, 5);
        fase4.add(p_player);
        
        // BLOCOS ESTATICOS
        Blocos blocoImovel1 = CriaBlocos.criaBloco("vermelho");
        blocoImovel1.setPosicao(1, 0);
        fase4.add(blocoImovel1);
        
        Blocos blocoImovel2 = CriaBlocos.criaBloco("vermelho");
        blocoImovel2.setPosicao(7, 0);
        fase4.add(blocoImovel2);

        Blocos blocoImovel3 = CriaBlocos.criaBloco("vermelho");
        blocoImovel3.setPosicao(8, 1);
        fase4.add(blocoImovel3);
        
        Blocos blocoImovel4 = CriaBlocos.criaBloco("vermelho");
        blocoImovel4.setPosicao(10, 1);
        fase4.add(blocoImovel4);

        Blocos blocoImovel5 = CriaBlocos.criaBloco("vermelho");
        blocoImovel5.setPosicao(3, 2);
        fase4.add(blocoImovel5);
        
        Blocos blocoImovel6 = CriaBlocos.criaBloco("vermelho");
        blocoImovel6.setPosicao(5, 2);
        fase4.add(blocoImovel6);

        Blocos blocoImovel7 = CriaBlocos.criaBloco("vermelho");
        blocoImovel7.setPosicao(0, 3);
        fase4.add(blocoImovel7);
        
        Blocos blocoImovel8 = CriaBlocos.criaBloco("vermelho");
        blocoImovel8.setPosicao(6, 3);
        fase4.add(blocoImovel8);

        Blocos blocoImovel9 = CriaBlocos.criaBloco("vermelho");
        blocoImovel9.setPosicao(2, 5);
        fase4.add(blocoImovel9);
        
        Blocos blocoImovel10 = CriaBlocos.criaBloco("vermelho");
        blocoImovel10.setPosicao(0, 7);
        fase4.add(blocoImovel10);

        Blocos blocoImovel11 = CriaBlocos.criaBloco("vermelho");
        blocoImovel11.setPosicao(8, 7);
        fase4.add(blocoImovel11);
        
        Blocos blocoImovel12 = CriaBlocos.criaBloco("vermelho");
        blocoImovel12.setPosicao(1, 8);
        fase4.add(blocoImovel12);

        Blocos blocoImovel13 = CriaBlocos.criaBloco("vermelho");
        blocoImovel13.setPosicao(5, 8);
        fase4.add(blocoImovel13);
        
        Blocos blocoImovel14 = CriaBlocos.criaBloco("vermelho");
        blocoImovel14.setPosicao(3, 10);
        fase4.add(blocoImovel14);
        
        Blocos blocoImovel15 = CriaBlocos.criaBloco("vermelho");
        blocoImovel15.setPosicao(8, 10);
        fase4.add(blocoImovel15);
        
        Blocos blocoVerde1 = CriaBlocos.criaBloco("verde");
        blocoVerde1.setPosicao(1, 1);
        fase4.add(blocoVerde1);
        
        Blocos blocoVerde2 = CriaBlocos.criaBloco("verde");
        blocoVerde2.setPosicao(3, 1);
        fase4.add(blocoVerde2);

        Blocos blocoVerde3 = CriaBlocos.criaBloco("verde");
        blocoVerde3.setPosicao(5, 1);
        fase4.add(blocoVerde3);

        Blocos blocoVerde4 = CriaBlocos.criaBloco("verde");
        blocoVerde4.setPosicao(7, 1);
        fase4.add(blocoVerde4);

        Blocos blocoVerde5 = CriaBlocos.criaBloco("verde");
        blocoVerde5.setPosicao(9, 1);
        fase4.add(blocoVerde5);

        Blocos blocoVerde6 = CriaBlocos.criaBloco("verde");
        blocoVerde6.setPosicao(2,2 );
        fase4.add(blocoVerde6);

        Blocos blocoVerde7 = CriaBlocos.criaBloco("verde");
        blocoVerde7.setPosicao(4, 2);
        fase4.add(blocoVerde7);

        Blocos blocoVerde8 = CriaBlocos.criaBloco("verde");
        blocoVerde8.setPosicao(6, 2);
        fase4.add(blocoVerde8);

        Blocos blocoVerde9 = CriaBlocos.criaBloco("verde");
        blocoVerde9.setPosicao(8, 2);
        fase4.add(blocoVerde9);

        Blocos blocoVerde10 = CriaBlocos.criaBloco("verde");
        blocoVerde10.setPosicao(1, 3);
        fase4.add(blocoVerde10);

        Blocos blocoVerde11 = CriaBlocos.criaBloco("verde");
        blocoVerde11.setPosicao(3, 3);
        fase4.add(blocoVerde11);

        Blocos blocoVerde12 = CriaBlocos.criaBloco("verde");
        blocoVerde12.setPosicao(5, 3);
        fase4.add(blocoVerde12);

        Blocos blocoVerde13 = CriaBlocos.criaBloco("verde");
        blocoVerde13.setPosicao(7, 3);
        fase4.add(blocoVerde13);

        Blocos blocoVerde14 = CriaBlocos.criaBloco("verde");
        blocoVerde14.setPosicao(9, 3);
        fase4.add(blocoVerde14);

        Blocos blocoVerde15 = CriaBlocos.criaBloco("verde");
        blocoVerde15.setPosicao(2, 4);
        fase4.add(blocoVerde15);

        Blocos blocoVerde16 = CriaBlocos.criaBloco("verde");
        blocoVerde16.setPosicao(4, 4);
        fase4.add(blocoVerde16);

        Blocos blocoVerde17 = CriaBlocos.criaBloco("verde");
        blocoVerde17.setPosicao(6, 4);
        fase4.add(blocoVerde17);

        Blocos blocoVerde18 = CriaBlocos.criaBloco("verde");
        blocoVerde18.setPosicao(8, 4);
        fase4.add(blocoVerde18);

        Blocos blocoVerde19 = CriaBlocos.criaBloco("verde");
        blocoVerde19.setPosicao(1, 5);
        fase4.add(blocoVerde19);

        Blocos blocoVerde20 = CriaBlocos.criaBloco("verde");
        blocoVerde20.setPosicao(3, 5);
        fase4.add(blocoVerde20);

        Blocos blocoVerde21 = CriaBlocos.criaBloco("verde");
        blocoVerde21.setPosicao(5, 5);
        fase4.add(blocoVerde21);

        Blocos blocoVerde22 = CriaBlocos.criaBloco("verde");
        blocoVerde22.setPosicao(7, 5);
        fase4.add(blocoVerde22);
        
        Blocos blocoVerde22_ = CriaBlocos.criaBloco("verde");
        blocoVerde22_.setPosicao(9, 5);
        fase4.add(blocoVerde22_);

        Blocos blocoVerde23 = CriaBlocos.criaBloco("verde");
        blocoVerde23.setPosicao(2, 6);
        fase4.add(blocoVerde23);

        Blocos blocoVerde24 = CriaBlocos.criaBloco("verde");
        blocoVerde24.setPosicao(4, 6);
        fase4.add(blocoVerde24);

        Blocos blocoVerde25 = CriaBlocos.criaBloco("verde");
        blocoVerde25.setPosicao(6, 6);
        fase4.add(blocoVerde25);

        Blocos blocoVerde26 = CriaBlocos.criaBloco("verde");
        blocoVerde26.setPosicao(8, 6);
        fase4.add(blocoVerde26);

        Blocos blocoVerde27 = CriaBlocos.criaBloco("verde");
        blocoVerde27.setPosicao(1, 7);
        fase4.add(blocoVerde27);

        Blocos blocoVerde28 = CriaBlocos.criaBloco("verde");
        blocoVerde28.setPosicao(3, 7);
        fase4.add(blocoVerde28);

        Blocos blocoVerde29 = CriaBlocos.criaBloco("verde");
        blocoVerde29.setPosicao(5, 7);
        fase4.add(blocoVerde29);

        Blocos blocoVerde30 = CriaBlocos.criaBloco("verde");
        blocoVerde30.setPosicao(7, 7);
        fase4.add(blocoVerde30);

        Blocos blocoVerde31 = CriaBlocos.criaBloco("verde");
        blocoVerde31.setPosicao(9, 7);
        fase4.add(blocoVerde31);

        Blocos blocoVerde32 = CriaBlocos.criaBloco("verde");
        blocoVerde32.setPosicao(2, 8);
        fase4.add(blocoVerde32);

        Blocos blocoVerde33 = CriaBlocos.criaBloco("verde");
        blocoVerde33.setPosicao(4, 8);
        fase4.add(blocoVerde33);

        Blocos blocoVerde34 = CriaBlocos.criaBloco("verde");
        blocoVerde34.setPosicao(6, 8);
        fase4.add(blocoVerde34);

        Blocos blocoVerde35 = CriaBlocos.criaBloco("verde");
        blocoVerde35.setPosicao(8, 8);
        fase4.add(blocoVerde35);

        Blocos blocoVerde36 = CriaBlocos.criaBloco("verde");
        blocoVerde36.setPosicao(1, 9);
        fase4.add(blocoVerde36);

        Blocos blocoVerde37 = CriaBlocos.criaBloco("verde");
        blocoVerde37.setPosicao(3, 9);
        fase4.add(blocoVerde37);

        Blocos blocoVerde38 = CriaBlocos.criaBloco("verde");
        blocoVerde38.setPosicao(5, 9);
        fase4.add(blocoVerde38);

        Blocos blocoVerde39 = CriaBlocos.criaBloco("verde");
        blocoVerde39.setPosicao(7, 9);
        fase4.add(blocoVerde39);

        Blocos blocoVerde40 = CriaBlocos.criaBloco("verde");
        blocoVerde40.setPosicao(9, 9);
        fase4.add(blocoVerde40);

        
        // COLETAVEIS
        Coletaveis sol = new Coletaveis("c_sol.png");
        sol.setPosicao(0, 0);
        fase4.add(sol);
        
        Coletaveis lampada = new Coletaveis("c_lampada.png");
        lampada.setPosicao(0, 10);
        fase4.add(lampada);
        
        Coletaveis lanterna = new Coletaveis("c_lanterna.png");
        lanterna.setPosicao(10, 10);
        fase4.add(lanterna);
        
        Coletaveis vela = new Coletaveis("c_vela.png");
        vela.setPosicao(10, 0);
        fase4.add(vela);
        
        
        // INIMIGOS
        InimigoAmarelo inimigo_amarelo1 = new InimigoAmarelo("inimigo_amarelo.png", p_player);
        inimigo_amarelo1.setPosicao(10, 5);
        fase4.add(inimigo_amarelo1);

        InimigoAmarelo inimigo_amarelo2 = new InimigoAmarelo("inimigo_amarelo.png", p_player);
        inimigo_amarelo2.setPosicao(0, 5);
        fase4.add(inimigo_amarelo2);

        InimigoVerde inimigo_verde1 = new InimigoVerde("inimigo_verde.png");
        inimigo_verde1.setPosicao(5, 0);
        fase4.add(inimigo_verde1);

        InimigoRosa inimigo_rosa1 = new InimigoRosa("inimigo_rosa.png", p_player);
        inimigo_rosa1.setPosicao(5, 10);
        fase4.add(inimigo_rosa1);

        return fase4;
    }
    
    private static ArrayList<Personagem> quintaFase() {
        backgroundImg = "background5.png";

        ArrayList<Personagem> fase5 = new ArrayList<>();
        
        // PLAYER
        Player p_player = new Player("skooter.png");
        p_player.setPosicao(6, 4);
        fase5.add(p_player);
        
        // INIMIGOS
        InimigoVerde inimigo_verde1 = new InimigoVerde("inimigo_verde.png");
        inimigo_verde1.setPosicao(5, 8);
        fase5.add(inimigo_verde1);

        InimigoRosa inimigo_rosa1 = new InimigoRosa("inimigo_rosa.png", p_player);
        inimigo_rosa1.setPosicao(5, 2);
        fase5.add(inimigo_rosa1);

        InimigoAzul inimigo_azul1 = new InimigoAzul("inimigo_azul.png", p_player);
        inimigo_azul1.setPosicao(8, 5);
        fase5.add(inimigo_azul1);

        InimigoAmarelo inimigo_amarelo1 = new InimigoAmarelo("inimigo_amarelo.png", p_player);
        inimigo_amarelo1.setPosicao(2, 5);
        fase5.add(inimigo_amarelo1);

        // BLOCOS ESTATICOS
        Blocos blocoImovel1 = CriaBlocos.criaBloco("vermelho");
        blocoImovel1.setPosicao(1, 1);
        fase5.add(blocoImovel1);
        
        Blocos blocoImovel2 = CriaBlocos.criaBloco("vermelho");
        blocoImovel2.setPosicao(1, 3);
        fase5.add(blocoImovel2);

        Blocos blocoImovel3 = CriaBlocos.criaBloco("vermelho");
        blocoImovel3.setPosicao(1, 5);
        fase5.add(blocoImovel3);

        Blocos blocoImovel4 = CriaBlocos.criaBloco("vermelho");
        blocoImovel4.setPosicao(1, 7);
        fase5.add(blocoImovel4);

        Blocos blocoImovel5 = CriaBlocos.criaBloco("vermelho");
        blocoImovel5.setPosicao(1, 9);
        fase5.add(blocoImovel5);

        Blocos blocoImovel6 = CriaBlocos.criaBloco("vermelho");
        blocoImovel6.setPosicao(3, 1);
        fase5.add(blocoImovel6);

        Blocos blocoImovel7 = CriaBlocos.criaBloco("vermelho");
        blocoImovel7.setPosicao(3, 3);
        fase5.add(blocoImovel7);

        Blocos blocoImovel8 = CriaBlocos.criaBloco("vermelho");
        blocoImovel8.setPosicao(3, 5);
        fase5.add(blocoImovel8);

        Blocos blocoImovel9 = CriaBlocos.criaBloco("vermelho");
        blocoImovel9.setPosicao(3, 7);
        fase5.add(blocoImovel9);

        Blocos blocoImovel10 = CriaBlocos.criaBloco("vermelho");
        blocoImovel10.setPosicao(3, 9);
        fase5.add(blocoImovel10);

        Blocos blocoImovel11 = CriaBlocos.criaBloco("vermelho");
        blocoImovel11.setPosicao(5, 1);
        fase5.add(blocoImovel11);

        Blocos blocoImovel12 = CriaBlocos.criaBloco("vermelho");
        blocoImovel12.setPosicao(5, 3);
        fase5.add(blocoImovel12);
        
        Blocos blocoImovel13 = CriaBlocos.criaBloco("vermelho");
        blocoImovel13.setPosicao(5, 5);
        fase5.add(blocoImovel13);

        Blocos blocoImovel14 = CriaBlocos.criaBloco("vermelho");
        blocoImovel14.setPosicao(5, 7);
        fase5.add(blocoImovel14);

        Blocos blocoImovel15 = CriaBlocos.criaBloco("vermelho");
        blocoImovel15.setPosicao(5, 9);
        fase5.add(blocoImovel15);

        Blocos blocoImovel16 = CriaBlocos.criaBloco("vermelho");
        blocoImovel16.setPosicao(7, 1);
        fase5.add(blocoImovel16);

        Blocos blocoImovel17 = CriaBlocos.criaBloco("vermelho");
        blocoImovel17.setPosicao(7, 3);
        fase5.add(blocoImovel17);
        
        Blocos blocoImovel18 = CriaBlocos.criaBloco("vermelho");
        blocoImovel18.setPosicao(7, 5);
        fase5.add(blocoImovel18);

        Blocos blocoImovel19 = CriaBlocos.criaBloco("vermelho");
        blocoImovel19.setPosicao(7, 7);
        fase5.add(blocoImovel19);

        Blocos blocoImovel20 = CriaBlocos.criaBloco("vermelho");
        blocoImovel20.setPosicao(7, 9);
        fase5.add(blocoImovel20);

        Blocos blocoImovel21 = CriaBlocos.criaBloco("vermelho");
        blocoImovel21.setPosicao(9, 1);
        fase5.add(blocoImovel21);

        Blocos blocoImovel22 = CriaBlocos.criaBloco("vermelho");
        blocoImovel22.setPosicao(9, 3);
        fase5.add(blocoImovel22);

        Blocos blocoImovel23 = CriaBlocos.criaBloco("vermelho");
        blocoImovel23.setPosicao(9, 5);
        fase5.add(blocoImovel23);

        Blocos blocoImovel24 = CriaBlocos.criaBloco("vermelho");
        blocoImovel24.setPosicao(9, 7);
        fase5.add(blocoImovel24);

        Blocos blocoImovel25 = CriaBlocos.criaBloco("vermelho");
        blocoImovel25.setPosicao(9, 9);
        fase5.add(blocoImovel25);
        
        // SETAS PARA CIMA
        Seta setaCima1 = new Seta("arrow_up.png", 'U');
        setaCima1.setPosicao(0, 3);
        fase5.add(setaCima1);
        
        Seta setaCima2 = new Seta("arrow_up.png", 'U');
        setaCima2.setPosicao(1, 0);
        fase5.add(setaCima2);
        
        Seta setaCima3 = new Seta("arrow_up.png", 'U');
        setaCima3.setPosicao(1, 6);
        fase5.add(setaCima3);
        
        Seta setaCima5 = new Seta("arrow_up.png", 'U');
        setaCima5.setPosicao(3, 4);
        fase5.add(setaCima5);
        
        Seta setaCima6 = new Seta("arrow_up.png", 'U');
        setaCima6.setPosicao(3, 10);
        fase5.add(setaCima6);
        
        Seta setaCima7 = new Seta("arrow_up.png", 'U');
        setaCima7.setPosicao(5, 4);
        fase5.add(setaCima7);
        
        Seta setaCima9 = new Seta("arrow_up.png", 'U');
        setaCima9.setPosicao(7, 4);
        fase5.add(setaCima9);
        
        Seta setaCima10 = new Seta("arrow_up.png", 'U');
        setaCima10.setPosicao(7, 6);
        fase5.add(setaCima10);
        
        Seta setaCima11 = new Seta("arrow_up.png", 'U');
        setaCima11.setPosicao(7, 10);
        fase5.add(setaCima11);
        
        Seta setaCima13 = new Seta("arrow_up.png", 'U');
        setaCima13.setPosicao(10, 1);
        fase5.add(setaCima13);
        
        Seta setaCima14 = new Seta("arrow_up.png", 'U');
        setaCima14.setPosicao(10, 7);
        fase5.add(setaCima14);
        
        
        // SETAS PARA BAIXO
        Seta setaBaixo1 = new Seta("arrow_down.png", 'D');
        setaBaixo1.setPosicao(0, 5);
        fase5.add(setaBaixo1);
        
        Seta setaBaixo2 = new Seta("arrow_down.png", 'D');
        setaBaixo2.setPosicao(0, 9);
        fase5.add(setaBaixo2);
        
        Seta setaBaixo3 = new Seta("arrow_down.png", 'D');
        setaBaixo3.setPosicao(1, 2);
        fase5.add(setaBaixo3);
        
        Seta setaBaixo4 = new Seta("arrow_down.png", 'D');
        setaBaixo4.setPosicao(1, 4);
        fase5.add(setaBaixo4);
        
        Seta setaBaixo5 = new Seta("arrow_down.png", 'D');
        setaBaixo5.setPosicao(3, 0);
        fase5.add(setaBaixo5);
        
        Seta setaBaixo6 = new Seta("arrow_down.png", 'D');
        setaBaixo6.setPosicao(3, 2);
        fase5.add(setaBaixo6);
        
        Seta setaBaixo7 = new Seta("arrow_down.png", 'D');
        setaBaixo7.setPosicao(3, 8);
        fase5.add(setaBaixo7);
        
        Seta setaBaixo8 = new Seta("arrow_down.png", 'D');
        setaBaixo8.setPosicao(4, 7);
        fase5.add(setaBaixo8);
        
        Seta setaBaixo9 = new Seta("arrow_down.png", 'D');
        setaBaixo9.setPosicao(5, 6);
        fase5.add(setaBaixo9);
        
        Seta setaBaixo10 = new Seta("arrow_down.png", 'D');
        setaBaixo10.setPosicao(7, 2);
        fase5.add(setaBaixo10);
        
        Seta setaBaixo11 = new Seta("arrow_down.png", 'D');
        setaBaixo11.setPosicao(7, 8);
        fase5.add(setaBaixo11);
        
        Seta setaBaixo12 = new Seta("arrow_down.png", 'D');
        setaBaixo12.setPosicao(9, 0);
        fase5.add(setaBaixo12);
        
        Seta setaBaixo13 = new Seta("arrow_down.png", 'D');
        setaBaixo13.setPosicao(9, 4);
        fase5.add(setaBaixo13);
        
        Seta setaBaixo14 = new Seta("arrow_down.png", 'D');
        setaBaixo14.setPosicao(9, 6);
        fase5.add(setaBaixo14);
        
        Seta setaBaixo15 = new Seta("arrow_down.png", 'D');
        setaBaixo15.setPosicao(9, 8);
        fase5.add(setaBaixo15);
        
        Seta setaBaixo16 = new Seta("arrow_down.png", 'D');
        setaBaixo16.setPosicao(1, 8);
        fase5.add(setaBaixo16);
        
        Seta setaBaixo17 = new Seta("arrow_down.png", 'D');
        setaBaixo17.setPosicao(7, 0);
        fase5.add(setaBaixo17);
        
        Seta setaBaixo18 = new Seta("arrow_down.png", 'D');
        setaBaixo18.setPosicao(9, 2);
        fase5.add(setaBaixo18);
        
        Seta setaBaixo19 = new Seta("arrow_down.png", 'D');
        setaBaixo19.setPosicao(10, 3);
        fase5.add(setaBaixo19);
        
        
        // SETAS PARA DIREITA
        Seta setaDireita1 = new Seta("arrow_right.png", 'R');
        setaDireita1.setPosicao(0, 1);
        fase5.add(setaDireita1);
        
        Seta setaDireita2 = new Seta("arrow_right.png", 'R');
        setaDireita2.setPosicao(2, 3);
        fase5.add(setaDireita2);
        
        Seta setaDireita3 = new Seta("arrow_right.png", 'R');
        setaDireita3.setPosicao(2, 7);
        fase5.add(setaDireita3);
        
        Seta setaDireita4 = new Seta("arrow_right.png", 'R');
        setaDireita4.setPosicao(2, 9);
        fase5.add(setaDireita4);
        
        Seta setaDireita5 = new Seta("arrow_right.png", 'R');
        setaDireita5.setPosicao(5, 0);
        fase5.add(setaDireita5);
        
        Seta setaDireita6 = new Seta("arrow_right.png", 'R');
        setaDireita6.setPosicao(5, 10);
        fase5.add(setaDireita6);
        
        Seta setaDireita7 = new Seta("arrow_right.png", 'R');
        setaDireita7.setPosicao(6, 5);
        fase5.add(setaDireita7);
        
        Seta setaDireita8 = new Seta("arrow_right.png", 'R');
        setaDireita8.setPosicao(6, 7);
        fase5.add(setaDireita8);
        
        Seta setaDireita9 = new Seta("arrow_right.png", 'R');
        setaDireita9.setPosicao(8, 1);
        fase5.add(setaDireita9);
        
        Seta setaDireita10 = new Seta("arrow_right.png", 'R');
        setaDireita10.setPosicao(8, 3);
        fase5.add(setaDireita10);
        
        Seta setaDireita11 = new Seta("arrow_right.png", 'R');
        setaDireita11.setPosicao(8, 7);
        fase5.add(setaDireita11);
        
        Seta setaDireita12 = new Seta("arrow_right.png", 'R');
        setaDireita12.setPosicao(10, 5);
        fase5.add(setaDireita12);
        
        Seta setaDireita13 = new Seta("arrow_right.png", 'R');
        setaDireita13.setPosicao(10, 9);
        fase5.add(setaDireita13);
        
        Seta setaDireita14 = new Seta("arrow_right.png", 'R');
        setaDireita14.setPosicao(4, 5);
        fase5.add(setaDireita14);
        
        
        
        // SETAS PARA ESQUERDA
        Seta setaEsquerda1 = new Seta("arrow_left.png", 'L');
        setaEsquerda1.setPosicao(2, 1);
        fase5.add(setaEsquerda1);
        
        Seta setaEsquerda2 = new Seta("arrow_left.png", 'L');
        setaEsquerda2.setPosicao(0, 7);
        fase5.add(setaEsquerda2);
        
        Seta setaEsquerda3 = new Seta("arrow_left.png", 'L');
        setaEsquerda3.setPosicao(1, 10);
        fase5.add(setaEsquerda3);
        
        Seta setaEsquerda4 = new Seta("arrow_left.png", 'L');
        setaEsquerda4.setPosicao(4, 1);
        fase5.add(setaEsquerda4);
        
        Seta setaEsquerda5 = new Seta("arrow_left.png", 'L');
        setaEsquerda5.setPosicao(4, 3);
        fase5.add(setaEsquerda5);
        
        Seta setaEsquerda7 = new Seta("arrow_left.png", 'L');
        setaEsquerda7.setPosicao(4, 9);
        fase5.add(setaEsquerda7);
        
        Seta setaEsquerda8 = new Seta("arrow_left.png", 'L');
        setaEsquerda8.setPosicao(6, 1);
        fase5.add(setaEsquerda8);
        
        Seta setaEsquerda9 = new Seta("arrow_left.png", 'L');
        setaEsquerda9.setPosicao(6, 3);
        fase5.add(setaEsquerda9);
        
        Seta setaEsquerda10 = new Seta("arrow_left.png", 'L');
        setaEsquerda10.setPosicao(6, 9);
        fase5.add(setaEsquerda10);
        
        Seta setaEsquerda11 = new Seta("arrow_left.png", 'L');
        setaEsquerda11.setPosicao(8, 9);
        fase5.add(setaEsquerda11);
        
        Seta setaEsquerda12 = new Seta("arrow_left.png", 'L');
        setaEsquerda12.setPosicao(9, 10);
        fase5.add(setaEsquerda12);
        
        Seta setaEsquerda15 = new Seta("arrow_left.png", 'L');
        setaEsquerda15.setPosicao(3, 6);
        fase5.add(setaEsquerda15);

        // COLETAVEIS
        Coletaveis cereja = new Coletaveis("c_cereja.png");
        cereja.setPosicao(2, 2);
        fase5.add(cereja);

        Coletaveis limao = new Coletaveis("c_limao.png");
        limao.setPosicao(2, 8);
        fase5.add(limao);

        Coletaveis morango = new Coletaveis("c_morango.png");
        morango.setPosicao(8, 2);
        fase5.add(morango);

        Coletaveis uva = new Coletaveis("c_uva.png");
        uva.setPosicao(8, 8);
        fase5.add(uva);

        return fase5;
    }
}
