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
		//cen�rio
		 int a = 5;
		 int b = 3;
		//a��o
		int result = calculadora.somar(a,b);
		
		//teste
		Assert.assertEquals(8, result);
	}
	
	@Test
	public void deveSubtrairDoisValores(){
		//cen�rio
		 int a = 5;
		 int b = 3;
		 
		//a��o
		int result = calculadora.subtrair(a,b);
		
		//teste
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void deveDividirDoisValores(){
		//cen�rio
		 int a = 6;
		 int b = 3;
		//a��o
		int result = calculadora.dividir(a,b);
		
		//teste
		Assert.assertEquals(2, result);
	}
	
	@Test(expected = naoPodeDividirPorZeroException.class)
	public void deveDividirPorZeroValores(){
		//cen�rio
		 int a = 6;
		 int b = 0;
		 
		//a��o
		int result = calculadora.dividir(a,b);
		
		Assert.assertEquals(2, result);
		//teste
	}
}
