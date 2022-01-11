/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.servicos;

import br.ce.wcaquino.exceptions.naoPodeDividirPorZeroException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Alvaro
 */
public class CalculadoraTest {
	
	
		private static  Calculadora calculadora;

		@Before
		public void setup(){
			calculadora = new Calculadora();
		}
	@Test
	public void deveSomarDoisValores(){
		//cenário
		 int a = 5;
		 int b = 3;
		//ação
		int result = calculadora.somar(a,b);
		
		//teste
		Assert.assertEquals(8, result);
	}
	
	@Test
	public void deveSubtrairDoisValores(){
		//cenário
		 int a = 5;
		 int b = 3;
		 
		//ação
		int result = calculadora.subtrair(a,b);
		
		//teste
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void deveDividirDoisValores(){
		//cenário
		 int a = 6;
		 int b = 3;
		//ação
		int result = calculadora.dividir(a,b);
		
		//teste
		Assert.assertEquals(2, result);
	}
	
	@Test(expected = naoPodeDividirPorZeroException.class)
	public void deveDividirPorZeroValores(){
		//cenário
		 int a = 6;
		 int b = 0;
		 
		//ação
		int result = calculadora.dividir(a,b);
		
		Assert.assertEquals(2, result);
		//teste
	}
}
