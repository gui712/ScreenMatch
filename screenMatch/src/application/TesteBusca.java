package application;
import java.io.IOError;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Modelos.Titulo;
import Modelos.TituloOmdb;

public class TesteBusca {

	public static void main(String[] args) throws IOError, InterruptedException, IOException {
		Scanner leitura = new Scanner(System.in);
		
		System.out.println("Digite um filme para busca");
		var busca = leitura.nextLine();
		
		String endereco = "https://www.omdbapi.com/?t="+ busca + "&apikey=c82fb6b7";
		
		 HttpClient client = HttpClient.newHttpClient();
		   HttpRequest request = HttpRequest.newBuilder()
		         .uri(URI.create(endereco))
		         .build();
		   HttpResponse<String> response = client
                   .send(request, HttpResponse.BodyHandlers.ofString());
		   String json = response.body();
		   System.out.println(json);
		   
		   Gson gson = new GsonBuilder()
				   .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				   .create();
		   //Titulo meuTitulo = gson.fromJson(json, Titulo.class);
		   TituloOmdb meuTitulo = gson.fromJson(json, TituloOmdb.class);
		   System.out.println(meuTitulo);
		   
		  
	}

}