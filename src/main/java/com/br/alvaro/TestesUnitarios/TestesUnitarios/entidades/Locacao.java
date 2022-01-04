/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.alvaro.TestesUnitarios.TestesUnitarios.entidades;

import java.util.Date;
import java.util.Objects;

/**
 * Classe de relacionamento entre usuário e filme alugado.
 * @author Alvaro
 */
public class Locacao {
	private Usuario usuario;
	private Filme filme;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valor;

	public Locacao() {
	}

	
	
	public Locacao(Usuario usuario, Filme filme, Date dataLocacao, Date dataRetorno, Double valor) {
		this.usuario = usuario;
		this.filme = filme;
		this.dataLocacao = dataLocacao;
		this.dataRetorno = dataRetorno;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.usuario);
		hash = 89 * hash + Objects.hashCode(this.filme);
		hash = 89 * hash + Objects.hashCode(this.dataLocacao);
		hash = 89 * hash + Objects.hashCode(this.dataRetorno);
		hash = 89 * hash + Objects.hashCode(this.valor);
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
		final Locacao other = (Locacao) obj;
		if (!Objects.equals(this.usuario, other.usuario)) {
			return false;
		}
		if (!Objects.equals(this.filme, other.filme)) {
			return false;
		}
		if (!Objects.equals(this.dataLocacao, other.dataLocacao)) {
			return false;
		}
		if (!Objects.equals(this.dataRetorno, other.dataRetorno)) {
			return false;
		}
		if (!Objects.equals(this.valor, other.valor)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Locacao{" + "usuario=" + usuario + ", filme=" + filme + ", dataLocacao=" + dataLocacao + ", dataRetorno=" + dataRetorno + ", valor=" + valor + '}';
	}
	
	
}
