package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Cadastro {
    private String nome;
    private int idade;
    private int crm;
    private boolean validado;

    private int tempo;
    private int nivelDeDificuldade;
    private int nivelDeDetalhes;

    // Construtor vazio
    public Cadastro() {
    }

    // Construtor com passagem de parâmetros
    public Cadastro(String nome, int idade, int crm) {
        this.nome = nome;
        this.idade = idade;
        this.crm = crm;
        this.validado = true;
    }

    public boolean isValidado() {
        return validado;
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
    	try {
			if (nome != null) {
				this.nome = nome;
			} else {
				throw new Exception("Não é possivel prosseguir sem um nome");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        try {
            if (idade >= 1) {
                this.idade = idade;
            } else {
                throw new Exception("Valor inválido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        try {
            if (crm >= 1) {
                this.crm = crm;
            } else {
                throw new Exception("Valor inválido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getNivelDeDificuldade() {
        return nivelDeDificuldade;
    }

    public void setNivelDeDificuldade(int nivelDeDificuldade) {
        this.nivelDeDificuldade = nivelDeDificuldade;
    }

    public int getNivelDeDetalhes() {
        return nivelDeDetalhes;
    }

    public void setNivelDeDetalhes(int nivelDeDetalhes) {
        this.nivelDeDetalhes = nivelDeDetalhes;
    }

    // Métodos
    public void validaCadastro() {
        if (getNome() == null || getNome().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            validado = false;
        } else if (getIdade() < 24) {
            JOptionPane.showMessageDialog(null, "Você é muito jovem!");
            validado = false;
        } else if (getCrm() < 1 || getCrm() > 999999) {
            JOptionPane.showMessageDialog(null, "CRM inválido. Deve estar entre 1 e 999999.");
            validado = false;
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            validado = true;
        }
    }

    public void realizarCadastro() {
        setNome(JOptionPane.showInputDialog("Digite seu nome: "));
        try {
            setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade: ")));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Idade inválida. Digite um número.");
            validado = false;
            return;
        }
        try {
            setCrm(Integer.parseInt(JOptionPane.showInputDialog("Digite seu CRM: ")));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CRM inválido. Digite um número.");
            validado = false;
            return;
        }
        validaCadastro();
    }
}
