/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.servicos.builders;

import br.ce.wcaquino.entidades.Usuario;

/**
 *
 * @author Alvaro
 */
public class usuarioBuilder {

	private Usuario usuario;

	private usuarioBuilder() {
	}

	private usuarioBuilder(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public static usuarioBuilder umUsuarioBuilder(){
		return new usuarioBuilder(new Usuario("Adalberto da Silva Sauro"));
	}
	
	public Usuario agora(){
		return usuario;
	}
	
}
