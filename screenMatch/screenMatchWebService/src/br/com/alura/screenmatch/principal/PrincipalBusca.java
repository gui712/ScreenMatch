package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome de um Filme: ");
        try {
            var busca = leitura.nextLine();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=c82fb6b7"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmdb meuTituloOmbdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmbdb);

            Titulo meuTitulo = new Titulo(meuTituloOmbdb);
            System.out.println("Titulo convertido");
            System.out.println(meuTitulo);
        }catch(NumberFormatException e){
            System.out.println("Aconteceu um erro");
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Algum erro de argumento, verifique a busca");
        }catch (ErroDeConversaoException e){
            System.out.println(e.getMessage());
        }

        System.out.println("O Programa foi finalizado!!");



        leitura.close();
    }
}
