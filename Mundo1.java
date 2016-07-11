import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe para criar o mundo 1.
 * 
 * @author (Jhonatan Morais - jhonatanvinicius@gmail.com | jhonatan@dfjug.org) 
 * @version (1.0)
 */
public class Mundo1 extends World
{
    //Constantes da natureza do mundo
    public static final int LARGURA_CENARIO = 700; 
    public static final int ALTURA_CENARIO = 390; 
    public static final int QUANTIDADE_DE_QUADROS = 350; 
    public static final int TAMANHO_DO_QUADRO = 4; 
    public static final String NOME_ARQUIVO_IMAGEM = "cenarios/mundo1/m1f1_"; 
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png"; 
    
    private int quadroAtual = 1;
    private int cicloAtual = 0;
     /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Mundo1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(LARGURA_CENARIO, ALTURA_CENARIO, 1);
        GreenfootImage cenarioInicial = new GreenfootImage("mundo1.png");
        setBackground(cenarioInicial);
        addObject(new Gato(), 100, 303);
        

    }
    /**
     * Retorna o valor do ciclo atual do jogo
     */
    public int cicloAtual(){
        return cicloAtual;
    }
    
    /**
     * Conta os ciclos do jogo
     */
    private void contaCiclo(){
        cicloAtual++;
        if(cicloAtual > 1000){
            cicloAtual = 0;
        }
        
    }
    
    
    public void act(){
        
        projetor(proximaCena());
        contaCiclo();
    }
    
    
    /**
     *  Solicita que o cenário seja atualizado com a proxima cena
     */
    private void projetor(GreenfootImage novaCena){
        setBackground(novaCena);
    }

    private GreenfootImage proximaCena(){
        GreenfootImage novaCena = filme();

        quadroAtual++;
        if(quadroAtual > QUANTIDADE_DE_QUADROS){
            quadroAtual = 1;
        }
        return novaCena;
    }
    
    /**
     *  Cria a nova cena do jogo de acordo com o quadro atualmente apresentado.
     */
    private GreenfootImage filme(){

        GreenfootImage novaCena  =  new GreenfootImage(LARGURA_CENARIO,ALTURA_CENARIO);
        int posicaoDoQuadro = 0;
        int quadro = quadroAtual;
        while(posicaoDoQuadro < LARGURA_CENARIO ){
            if(quadro > QUANTIDADE_DE_QUADROS){
                quadro = 1;
            }
            novaCena.drawImage(imagemDoNovoQuadro(quadro), posicaoDoQuadro, 0);
            quadro++;
            posicaoDoQuadro += TAMANHO_DO_QUADRO;

        }
        return novaCena;
    }

    
    /**
     * Apenas busca as novas filetas dentro do diretório de imagem
     */
    private GreenfootImage imagemDoNovoQuadro(int proximoQuadro){
        String nomeDoArquivo = NOME_ARQUIVO_IMAGEM + proximoQuadro + EXTENSAO_ARQUIVO_IMAGEM;
        GreenfootImage novoQuadro = new GreenfootImage(nomeDoArquivo );
        return novoQuadro;

    }

    
    
    
    
}
