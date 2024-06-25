package br.com.fiap.bean;

//RM:550908- Vinicius Santos Yamashita de Farias
//RM:98460-  Felipe Capriotti da Silva Santos
//RM:98036-  Henrique Pontes Olliveira
//RM:99679-  Gustavo Kawamura Christofani
//RM:99874-  Rafael Carvalho mattos

import javax.swing.JOptionPane;

public class Histerectomia extends Cadastro {
	private int nivelDeDificuldade , nivelDeDetalhes, tempo;
	
	//construtor vazio
	public Histerectomia() {
		
	}
	
	//construtor com passagem de parametro
	public Histerectomia(int tempo, int nivelDeDificuldade, int nivelDeDetalhes) {
		this.tempo = tempo;
		this.nivelDeDificuldade = nivelDeDificuldade;
		this.nivelDeDetalhes = nivelDeDetalhes;
	}

	//getters & setters
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		try {
			if (tempo > 1) {
				this.tempo = tempo;
			} else {
				throw new Exception("Tempo escolhido fora da faixa permitida !!!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public int getNivelDeDificuldade() {
		return nivelDeDificuldade;
	}
	public void setNivelDeDificuldade(int nivelDeDificuldade) {
		try {
			if (nivelDeDificuldade > 0 || nivelDeDificuldade <= 5) {
				this.nivelDeDificuldade = nivelDeDificuldade;
			} else {
				throw new Exception("Nível de dificuldade fora da faixa permitida !!!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public int getNivelDeDetalhes() {
		return nivelDeDetalhes;
	}
	public void setNivelDeDetalhes(int nivelDeDetalhes) {
		try {
			if (nivelDeDetalhes > 0 || nivelDeDetalhes <= 5) {
				this.nivelDeDetalhes = nivelDeDetalhes;
			} else {
				throw new Exception("Nível de detalhes fora da faixa permitida !!!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	//métodos
	public void exibeinformacao() {
		JOptionPane.showMessageDialog(null, "O tempo foi definido em: " + getTempo() +
											"\nO nivel de dificuldade foi definido em: " + getNivelDeDificuldade() + 
											"\nO nidel de detalhes foi definido em: " + getNivelDeDetalhes());
	}
	
	
	
}

