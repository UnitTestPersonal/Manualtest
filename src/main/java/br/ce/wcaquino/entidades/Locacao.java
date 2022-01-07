package br.ce.wcaquino.entidades;

import java.util.Date;

public class Locacao {

	private Usuario usuario;
	private Filme filme;
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
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
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
		if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
			return false;
		}
		if (this.filme != other.filme && (this.filme == null || !this.filme.equals(other.filme))) {
			return false;
		}
		if (this.dataLocacao != other.dataLocacao && (this.dataLocacao == null || !this.dataLocacao.equals(other.dataLocacao))) {
			return false;
		}
		if (this.dataRetorno != other.dataRetorno && (this.dataRetorno == null || !this.dataRetorno.equals(other.dataRetorno))) {
			return false;
		}
		if (this.valor != other.valor && (this.valor == null || !this.valor.equals(other.valor))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Locacao{" + "usuario=" + usuario + ", filme=" + filme + ", dataLocacao=" + dataLocacao + ", dataRetorno=" + dataRetorno + ", valor=" + valor + '}';
	}
	
	
}