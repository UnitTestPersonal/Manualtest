/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.servicos;

import br.ce.wcaquino.exceptions.naoPodeDividirPorZeroException;

/**
 *
 * @author Alvaro
 */
public class Calculadora {

	public int somar (int a, int b){
		return a+b;
	}

	int subtrair(int a, int b) {
		return a - b;
	}

	int dividir(int a, int b) throws naoPodeDividirPorZeroException{
		if(b == 0 ) throw  new naoPodeDividirPorZeroException("valor não pode ser divido por zero.");
		return a / b;
	}
}
