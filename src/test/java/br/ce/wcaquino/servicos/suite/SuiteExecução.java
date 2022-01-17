/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.servicos.suite;

import br.ce.wcaquino.servicos.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 *
 * @author Alvaro
 */
@RunWith(Suite.class)
@SuiteClasses({
	Calculadora.class,
	CalculoValorLocacaoTest.class,
	LocacaoServiceTest.class,
	OrdemTest.class
})
public class SuiteExecução {

}
