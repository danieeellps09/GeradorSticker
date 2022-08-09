package br.com.daniel.imersaoalura;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class GerarSticker {

    public void cria (InputStream inputStream, String nomeArquivo) throws IOException {

        // Leitura da imagem
       // BufferedImage imagemOriginal =  ImageIO.read(new File("imagens/shawshank_redemption.jpg"));
      //  InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
       BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Cria nova imagem em memória e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);


        //Copiar imagem pra nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //Configurar fonte
       var fonte =  new Font(Font.SANS_SERIF,Font.BOLD,32);
       graphics.setFont(fonte);
       graphics.setColor(Color.GREEN);
        //Escrever uma frase na imagem
        graphics.drawString("topzera", 0, novaAltura - 100);
        graphics.setFont(fonte);
        graphics.setColor(Color.BLUE);

        //Escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }



}
