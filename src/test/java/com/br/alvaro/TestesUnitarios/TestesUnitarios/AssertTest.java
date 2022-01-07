/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.alvaro.TestesUnitarios.TestesUnitarios;


import org.hamcrest.Matchers;
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

@Rule
public  ErrorCollector error  = new ErrorCollector();

@Test
	public void Test(){
		Assert.assertTrue(false);
		error.checkThat(true, Matchers.is(true));
		error.checkThat(false ,Matchers.not(false));
		error.checkThat(1, Matchers.is(2));
		error.checkThat(0.51, Matchers.is(0.51));
	}
}
