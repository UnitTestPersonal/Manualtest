/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.servicos;

import junit.framework.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Alvaro
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTest extends Object {

	public static int counter = 0;
	
	@Test
	public void inicia(){
		counter ++;
		Assert.assertEquals(1, counter);
	}
	
	@Test
	public void verifica(){
		counter++;
		Assert.assertEquals(2, counter);
	}
}
