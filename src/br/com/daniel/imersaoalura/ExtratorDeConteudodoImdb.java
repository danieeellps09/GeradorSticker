package br.com.daniel.imersaoalura;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.list;
import static java.util.Collections.replaceAll;

public class ExtratorDeConteudodoImdb implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json) {
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        List<Conteudo> conteudos = new ArrayList<>();

        //popular lista de conteudo
        for (Map<String, String> atributos : listaDeAtributos) {


            String titulo = atributos.get("title");
           // String urlImagem = atributos.get("image");
            String urlImagem = atributos.get("image").replaceAll("(@+)(.+).jpg$", "$1.jpg");

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);

        }
        return conteudos;
    }


}
