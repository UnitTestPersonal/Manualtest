/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.servicos;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Alvaro
 */
public class OrdemTest extends Object {

	public static int counter = 0;
	
	//teste pode acusar erro devido a problema de ordem
	//@Test
	public void inicia(){
		counter ++;
		Assert.assertEquals(1, counter);
	}
	
	//teste pode acusar erro devido a problema de ordem
	//@Test
	public void verifica(){
		counter++;
		Assert.assertEquals(2, counter);
	}
	
	//força odenação de teste mas gera problema de rastreabilidade.
	@Test
	public void testeGeral(){
		inicia();
		verifica();
	}
}
