package br.com.daniel.imersaoalura;

import java.util.List;

public interface ExtratorDeConteudo {
    List<Conteudo> extraiConteudos(String json);
}