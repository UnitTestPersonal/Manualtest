package com.br.alvaro.TestesUnitarios.TestesUnitarios;

import com.br.alvaro.TestesUnitarios.TestesUnitarios.Service.LocacaoService;
import com.br.alvaro.TestesUnitarios.TestesUnitarios.entidades.*;
import com.br.alvaro.TestesUnitarios.TestesUnitarios.utils.DataUtils;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Todo este projeto é baseado no curso JUnit na udemy
 * @author Alvaro
 * @link https://www.udemy.com/share/101IDY3@ynzSdsVtQPjONWkiCVzp11aAizIbsTLYw51FEiSKzuqELgqRE-rQoGhOvyFRf4Jv/
 */

@SpringBootApplication
public class TestesUnitariosApplication {

		public static void main(String[] args) {
			SpringApplication.run(TestesUnitariosApplication.class, args);
			
			//cenário.
				Usuario usuario = new Usuario("Alvaro Pereira do Nascimento");
				Filme filme = new Filme("A bela e a Fera", 100, 10.00);
				LocacaoService locacaoService = new LocacaoService();
				//ação.
				Locacao locacao = locacaoService.alugarFilme(usuario, filme);
				//verificação.
				System.out.println(locacao.toString());
				System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
				System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
				System.out.println(locacao.getValor() == 11.0);
		}
		
		@Test
		public void teste(){
			//cenário.
			Usuario usuario = new Usuario("Alvaro Pereira do Nascimento");
			Filme filme = new Filme("A bela e a Fera", 100, 10.00);
			LocacaoService locacaoService = new LocacaoService();
			//ação.
			Locacao locacao = locacaoService.alugarFilme(usuario, filme);
			//verificação.
			System.out.println(locacao.toString());
			Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
			Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
			Assert.assertTrue(locacao.getValor() == 10.0);
		}
}
