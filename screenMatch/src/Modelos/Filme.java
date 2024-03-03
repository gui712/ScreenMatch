package Modelos;

import Calculos.Classificavel;

public class Filme extends Titulo implements Classificavel{
	private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

	@Override
	public int getClassificacao() {
		// TODO Auto-generated method stub
		return (int)pegaMedia() / 2;
	}
	
}
