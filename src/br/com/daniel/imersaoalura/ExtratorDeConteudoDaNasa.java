package br.com.daniel.imersaoalura;

import br.com.daniel.imersaoalura.Conteudo;
import br.com.daniel.imersaoalura.JsonParser;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements  ExtratorDeConteudo {

    @Override
    public List<Conteudo> extraiConteudos(String json) {

        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        List<Conteudo> conteudos = new ArrayList<>();

        //popular lista de conteudo
        for (Map<String, String> atributos : listaDeAtributos) {


            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);

        }
        return conteudos;
    }
}









