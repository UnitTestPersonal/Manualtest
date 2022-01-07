package br.ce.wcaquino.entidades;

public class Filme {

	private String nome;
	private Integer estoque;
	private Double precoLocacao;  
	
	public Filme() {}
	
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
	public int hashCode() {
		int hash = 5;
		hash = 23 * hash + (this.nome != null ? this.nome.hashCode() : 0);
		hash = 23 * hash + (this.estoque != null ? this.estoque.hashCode() : 0);
		hash = 23 * hash + (this.precoLocacao != null ? this.precoLocacao.hashCode() : 0);
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
		if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
			return false;
		}
		if (this.estoque != other.estoque && (this.estoque == null || !this.estoque.equals(other.estoque))) {
			return false;
		}
		if (this.precoLocacao != other.precoLocacao && (this.precoLocacao == null || !this.precoLocacao.equals(other.precoLocacao))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Filme{" + "nome=" + nome + ", estoque=" + estoque + ", precoLocacao=" + precoLocacao + '}';
	}
	
}