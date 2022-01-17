/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.matcher;

import java.util.Date;

/**
 *
 * @author Alvaro
 */
public class matcherProperties {

	public static diaSemanMacther caiEm(Integer diaSemana){
		return  new diaSemanMacther(diaSemana);
	}
	
	public static diferencaDias  eHojeComDiferencaDe1Dia(Date diaSemana){
		return  new diferencaDias(diaSemana , 1);
	}
	
	public static diferencaDias eHoje(){
		return  new diferencaDias(new Date(), 0);
	}
}
