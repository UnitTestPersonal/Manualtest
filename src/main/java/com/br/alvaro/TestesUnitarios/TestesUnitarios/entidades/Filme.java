/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.alvaro.TestesUnitarios.TestesUnitarios.entidades;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *  Classe de filmesque mostra o nome a quantidade de estoue e o preço da locação.
 * @author Alvaro
 */
public class Filme {
	private String nome;
	private Integer estoque;
	private Double precoLocacao;  

	public Filme(String nome, Integer estoque, Double precoLocacao) {
		this.nome = nome;
		this.estoque = estoque;
		this.precoLocacao = precoLocacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Double getPrecoLocacao() {
		return precoLocacao;
	}

	public void setPrecoLocacao(Double precoLocacao) {
		this.precoLocacao = precoLocacao;
	}

	@Override
	public String toString() {
		return "Filme{" + "nome=" + nome + ", estoque=" + estoque + ", precoLocacao=" + precoLocacao + '}';
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.nome);
		hash = 79 * hash + Objects.hashCode(this.estoque);
		hash = 79 * hash + Objects.hashCode(this.precoLocacao);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Filme other = (Filme) obj;
		if (!Objects.equals(this.nome, other.nome)) {
			return false;
		}
		if (!Objects.equals(this.estoque, other.estoque)) {
			return false;
		}
		return Objects.equals(this.precoLocacao, other.precoLocacao);
	}
	
	private static final Logger LOG = Logger.getLogger(Filme.class.getName());
	 
	
	
}
