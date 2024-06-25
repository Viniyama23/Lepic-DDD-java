package br.com.fiap.main;

// RM:550908- Vinicius Santos Yamashita de Farias
// RM:98460- Felipe Capriotti da Silva Santos
// RM:98036- Henrique Pontes Olliveira
// RM:99679- Gustavo Kawamura Christofani
// RM:99874- Rafael Carvalho mattos

import br.com.fiap.bean.Apendicectomia;
import br.com.fiap.bean.Bariatrica;
import br.com.fiap.bean.Cadastro;
import br.com.fiap.bean.Colecistectomia;
import br.com.fiap.bean.Esplenectomia;
import br.com.fiap.bean.Histerectomia;
import br.com.fiap.bean.Pancreatectomia;
import br.com.fiap.bean.Pancreatoduodenectomia;
import br.com.fiap.bean.Prostatectomia;

import javax.swing.JOptionPane;

public class UsaCirurgia {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try {
            Cadastro cadastro = new Cadastro();

            // Obtém os dados do usuário
            	String nome = JOptionPane.showInputDialog("Digite seu nome:");
                cadastro.setNome(nome);

            try {
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade: "));
                cadastro.setIdade(idade);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Certifique-se de digitar um número para idade.");
                return;
            }

            try {
                int crm = Integer.parseInt(JOptionPane.showInputDialog("Digite seu CRM: "));
                cadastro.setCrm(crm);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Certifique-se de digitar um número para CRM.");
                return;
            }

            cadastro.setValidado(true);

            // Se o cadastro for válido, permite escolher os dados da cirurgia
            if (cadastro.isValidado()) {
                // Menu de opções para escolha da cirurgia
                String[] cirurgias = {
                        "Bariátrica",
                        "Apendicectomia",
                        "Colecistectomia",
                        "Esplenectomia",
                        "Histerectomia",
                        "Pancreatectomia",
                        "Pancreatoduodenectomia",
                        "Prostatectomia"
                };
                String escolha = (String) JOptionPane.showInputDialog(
                        null,
                        "Escolha a cirurgia:",
                        "Tipo de Cirurgia",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        cirurgias,
                        cirurgias[0]
                );

                if (escolha != null) {
                    // Define a cirurgia escolhida
                    Object cirurgia = null;
                    switch (escolha) {
                        case "Bariátrica":
                            cirurgia = new Bariatrica();
                            break;
                        case "Apendicectomia":
                            cirurgia = new Apendicectomia();
                            break;
                        case "Colecistectomia":
                            cirurgia = new Colecistectomia();
                            break;
                        case "Esplenectomia":
                            cirurgia = new Esplenectomia();
                            break;
                        case "Histerectomia":
                            cirurgia = new Histerectomia();
                            break;
                        case "Pancreatectomia":
                            cirurgia = new Pancreatectomia();
                            break;
                        case "Pancreatoduodenectomia":
                            cirurgia = new Pancreatoduodenectomia();
                            break;
                        case "Prostatectomia":
                            cirurgia = new Prostatectomia();
                            break;
                    }

                    try {
                        int tempo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo necessário da cirurgia (em minutos): "));
                        // Definindo o tempo diretamente na classe `Cadastro`
                        cadastro.setTempo(tempo);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Certifique-se de digitar um número para o tempo.");
                        return;
                    }

                    try {
                        int nivelDeDificuldade = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível de dificuldade da cirurgia (de 1 a 5): "));
                        cadastro.setNivelDeDificuldade(nivelDeDificuldade);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Certifique-se de digitar um número para o nível de dificuldade.");
                        return;
                    }

                    try {
                        int nivelDeDetalhes = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível de detalhes da cirurgia (de 1 a 5): "));
                        cadastro.setNivelDeDetalhes(nivelDeDetalhes);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Certifique-se de digitar um número para o nível de detalhes.");
                        return;
                    }

                    // Exibe os dados escolhidos
                    JOptionPane.showMessageDialog(null, "Dados da cirurgia:\n" +
                            "Tipo: " + escolha + "\n" +
                            "Tempo necessário: " + cadastro.getTempo() + " minutos\n" +
                            "Nível de dificuldade: " + cadastro.getNivelDeDificuldade() + "\n" +
                            "Nível de detalhes: " + cadastro.getNivelDeDetalhes());
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Certifique-se de digitar números para idade, CRM, tempo, nível de dificuldade e nível de detalhes.");
        }
    }
}
