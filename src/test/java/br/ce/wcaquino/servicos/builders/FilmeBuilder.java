/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.servicos.builders;

import br.ce.wcaquino.entidades.Filme;

/**
 *
 * @author Alvaro
 */
public class FilmeBuilder {
	
	private Filme filme;

	private FilmeBuilder(Filme filme) {
		this.filme = filme;
	}

	private FilmeBuilder() {
	}
	
	public static FilmeBuilder umFilme(){
		return new FilmeBuilder(new Filme("Filme 1", 1, 4.0));
	}
	
	public Filme agora(){
		return filme;
	}
	public FilmeBuilder emEstoque(int quantidade){
		this.filme.setEstoque(quantidade);
		return this;
	}
	public FilmeBuilder comValor(double valor){
		this.filme.setPrecoLocacao(valor);
		return this;
	}
	public FilmeBuilder comNome(String nome){
		this.filme.setNome(nome);
		return this;
	}
}
