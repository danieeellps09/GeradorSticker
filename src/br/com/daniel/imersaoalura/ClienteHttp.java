package br.com.daniel.imersaoalura;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;



public class ClienteHttp {
    public String buscaDados (String url) {
        try {   //Fazer conexão API com top 250 filmes
            // conceitos: url,httpClient,http


            URI endereco = URI.create(url);
            var cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            return body;
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);

        }


    }
}
