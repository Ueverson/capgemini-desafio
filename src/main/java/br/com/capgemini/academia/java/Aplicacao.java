package br.com.capgemini.academia.java;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.capgemini.academia.java.exception.ConstrutorDeEscadaException;
import br.com.capgemini.academia.java.exception.ValidadorDeSenhaForteException;
import br.com.capgemini.academia.java.model.ConstrutorDeEscada;
import br.com.capgemini.academia.java.model.LocalizadorDeAnagrama;
import br.com.capgemini.academia.java.model.ValidadorSenhaForte;

// TODO: Auto-generated Javadoc
/**
 * Responsavel por inicializar e controlar o fluxo da aplicacao.
 */
public class Aplicacao {

	/** The leitor. */
	private static Scanner leitor;

	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		leitor = new Scanner(System.in);
		StringBuilder construtor = new StringBuilder();
		System.out.println(construtor.toString());
		int opcaoSelecionada = -1;
		
		do {

			try {
				opcaoSelecionada = obterOpcaoDesejada();
				
				switch (opcaoSelecionada) {
				case 1:
					imprimirEscada();
					break;

				case 2:
					validarSenhaForte();
					break;

				case 3:
					localizarAnagrama();
					break;

				case 0:
					encerrarAplicacao();
					break;

				default:
					System.out.println("\nOPS, OPCAO INVALIDA, ESCOLHA NOVAMENTE.");
					break;
				}
				
			} catch (Exception e) {
				System.out.println("\nOPS, OPCAO INVALIDA, ESTAMOS ENCERRANDO A APLICACAO.");
				break;
			}

		} while (opcaoSelecionada != 0);
	}

	
	/**
	 * Localizar anagrama.
	 */
	private static void localizarAnagrama() {
	
		try {
			System.out.print("\nPOR FAVOR, DIGITE A PALAVRA PARA LOCALIZACAO DOS ANAGRAMAS: ");
			String palavra = leitor.next();
			LocalizadorDeAnagrama localizador = new LocalizadorDeAnagrama();
			ArrayList<String> anagramas = localizador.pesquisar(palavra);
			
			if (anagramas.size() <= 0 ) {
				System.out.println("OPS, NENHUM ANAGRAMA FOI LOCALIZADO NESTA PALAVRA");
			
			} else {
				StringBuilder construtor = new StringBuilder("OS ANAGRAMAS LOCALIZADOS FORAM: ");
				for (String anagrama : anagramas) {
					construtor.append("[" + anagrama + "], ");
				}	
				System.out.println(construtor.toString());
			}

		} catch (ValidadorDeSenhaForteException e) {
			System.out.println("OPS, A SUA SENHA DEVE SER MELHORADA, " + e.getMessage());
		}

	}

	
	/**
	 * Validar senha forte.
	 */
	private static void validarSenhaForte() {
		
		try {
			System.out.print("\nPOR FAVOR, DIGITE A SENHA PARA VALIDACAO: ");
			String senha = leitor.next();
			ValidadorSenhaForte validador = new ValidadorSenhaForte();
			if(validador.executar(senha)) {
				System.out.println("PARABÉNS, VOCE ACABOU DE DIGITAR UMA SENHA FORTE!!");
			}

		} catch (ValidadorDeSenhaForteException e) {
			System.out.println("OPS, A SUA SENHA DEVE SER MELHORADA, " + e.getMessage());
		}

	}

	/**
	 * Imprimir escada.
	 */
	private static void imprimirEscada() {

		try {
			System.out.print("\nPOR FAVOR, DIGITE O NUMERO DE DEGRAUS DA SUA ESCADA: ");
			int qtdDegraus = leitor.nextInt();
			ConstrutorDeEscada construtor = new ConstrutorDeEscada();
			String escada = construtor.construir(qtdDegraus);
			System.out.println(escada);

		} catch (ConstrutorDeEscadaException e) {
			System.out.println("OPS, TIVEMOS UM PROBLEMA DURANTE: " + e.getMessage());
		}

	}

	/**
	 * Obter opcao desejada.
	 *
	 * @return a opcao selecionada pelo usuario
	 */
	private static int obterOpcaoDesejada() {

		StringBuilder construtor = new StringBuilder();
		construtor.append("\n**************************************************************************************");
		construtor.append("\n*********************** CAPGEMINI - ACADEMIA JAVA 2022 *******************************");
		construtor.append("\n**************************************************************************************");
		construtor.append("\nDIGITE 1 PARA REALIZAR A IMPRESSAO DE UMA ESCADA NO CONSOLE");
		construtor.append("\nDIGITE 2 PARA REALIZAR A VALIDACAO DE UMA SENHA FORTE");
		construtor.append("\nDIGITE 3 PARA REALIZAR LOCALIZAR OS ANAGRAMAS CONTIDOS EM UMA PALAVRA INFORMADA");
		construtor.append("\nDIGITE 0 PARA REALIZAR ENCERRAR A APLICACAO");
		construtor.append("\nOPCAO DESEJADA: ");
		String opcoesMenu = construtor.toString();

		System.out.print(opcoesMenu);
		int opcaoDesejada = leitor.nextInt();

		return opcaoDesejada;
	}

	/**
	 * Encerrar aplicacao.
	 */
	private static void encerrarAplicacao() {
		StringBuilder construtor = new StringBuilder();
		construtor.append("\n**************************************************************************************");
		construtor.append("\n******************** OBRIGADO PELA OPORTUNIDADE CAPGEMINI ****************************");
		construtor.append("\n**************************************************************************************");
		System.out.println(construtor.toString());
		leitor.close();
	}
}
