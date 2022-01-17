/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.matcher;

import br.ce.wcaquino.utils.DataUtils;
import java.util.Date;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 *
 * @author Alvaro
 */
public class diaSemanMacther extends TypeSafeMatcher<Date>{

	private Integer diaSemana;
	
	public diaSemanMacther(Integer diaSemana){
		this.diaSemana = diaSemana;
	}
	
	@Override
	protected boolean matchesSafely(Date item) {
		return  DataUtils.verificarDiaSemana(item, diaSemana);
	}

	@Override
	public void describeTo(Description description) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
