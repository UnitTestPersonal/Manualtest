/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.matcher;

import br.ce.wcaquino.utils.DataUtils;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import java.util.Date;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 *
 * @author Alvaro
 */
public class diferencaDias extends TypeSafeMatcher<Date>{

	Date diferencasDias;
	
	Integer dias;

	public diferencaDias(Date diferencasDias, int dias) {
		this.diferencasDias = diferencasDias;
		this.dias = dias;
	}
	
	
	@Override
	protected boolean matchesSafely(Date item) {
		return  DataUtils.isMesmaData(item, obterDataComDiferencaDias(dias));
	}

	@Override
	public void describeTo(Description description) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}


}
