/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.alvaro.TestesUnitarios.TestesUnitarios;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Alvaro
 */
@SpringBootTest()
public class AssertTest {
	public void Test(){
		Assert.assertTrue(false);
		Assert.assertFalse(true);
		Assert.assertEquals(1, 2);
		Assert.assertEquals(0.51, 0.51, 0.01);
		Assert.assertThat(this, matcher);
	}
}
