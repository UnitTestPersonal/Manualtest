/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.alvaro.TestesUnitarios.TestesUnitarios.entidades;

import java.util.Objects;

/**
 * Classe de determina o nome do Usuario que fará a locação do filme.
 * @author Alvaro
 */
public class Usuario {
	private String nome;

	public Usuario() {
	}
	
	public Usuario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53 * hash + Objects.hashCode(this.nome);
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
		final Usuario other = (Usuario) obj;
		if (!Objects.equals(this.nome, other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Usuario{" + "nome=" + nome + '}';
	}
	
	
}
