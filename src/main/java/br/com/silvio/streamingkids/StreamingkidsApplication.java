package br.com.silvio.streamingkids;

import br.com.silvio.streamingkids.model.DadosSerie;
import br.com.silvio.streamingkids.service.ConsumoAPI;
import br.com.silvio.streamingkids.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamingkidsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamingkidsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI();
		String busca = "Friends";
		var apiKey = "14c710c0"; //inferencia de tipo var
		String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + apiKey;
		var json = consumoAPI.obterDados(endereco);
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
