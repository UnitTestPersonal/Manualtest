package br.ce.wcaquino.entidades;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class Locacao {

	private Usuario usuario;
	private Set<Filme> filme;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valor;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Set<Filme> getFilme() {
		return filme;
	}

	public void setFilme(Set<Filme> filme) {
		this.filme = filme;
	}
	

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 19 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
		hash = 19 * hash + (this.filme != null ? this.filme.hashCode() : 0);
		hash = 19 * hash + (this.dataLocacao != null ? this.dataLocacao.hashCode() : 0);
		hash = 19 * hash + (this.dataRetorno != null ? this.dataRetorno.hashCode() : 0);
		hash = 19 * hash + (this.valor != null ? this.valor.hashCode() : 0);
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