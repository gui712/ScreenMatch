package Modelos;

public class Filme {
	public String nome;
	public int anoDeLancamento;
	public boolean incluidoNoPlano;
	public double somaDasavaliacoes;
	public int totalAvaliacoes;
	public int duracaoEmMinutos;
	
	public void exibeFichaTecnica() {
		System.out.println("Nome do Filme: " + nome);
		System.out.println("Ano de lançamento: " + anoDeLancamento);
	}
	
	public void avalia(double nota) {
		somaDasavaliacoes += nota;
		totalAvaliacoes++;
	}
	
	public double pegaMedia() {
		return somaDasavaliacoes / totalAvaliacoes;
	}

}
