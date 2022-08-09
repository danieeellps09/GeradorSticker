package br.com.daniel.imersaoalura;
    import java.io.IOException;
    import java.io.InputStream;
    import java.net.URI;
    import java.net.URL;
    import  java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;
    import java.util.List;
    import java.util.Map;



    public class Principal {
        public static void main(String[] args) throws IOException, InterruptedException {



           //  String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
           //ExtratorDeConteudo extrator = new ExtratorDeConteudodoImdb();


           // String url = "https://api.nasa.gov/planetary/apod?api_key=bsTC3HV9p1dY9I4a2YahIF7IJ6fTihNMResmo1PZ";
           // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
            //Testando API
            String url = "https://api-de-linguagem.herokuapp.com/linguagens";
            ExtratorDeConteudo extrator = new ExtratorDeConteudodoImdb();

            var http = new ClienteHttp();
            String json = http.buscaDados(url );

            //Exibir e manipular os dados
            var parser = new JsonParser();

            List <Conteudo> conteudos = extrator.extraiConteudos(json);



            var gerador = new GerarSticker();
            for (int i = 0; i< 3; i++) {

              //String urlImagem = conteudo.get("image");
              Conteudo conteudo = conteudos.get(i);
                InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

               String nomeArquivo = "saida/" + conteudo.getTitulo() + ".jpg";

                gerador.cria(inputStream, nomeArquivo);

             //   System.out.println(filme.get("title"));
              //  System.out.println(filme.get("imDbRating"));
            }

        }
    }