/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Alvaro
 */
@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {

	@Parameter(value = 0)
	public HashSet<Filme> filmes;
	
	@Parameter(value = 1)
	public double valorLocacao;
	
	@Parameter(value = 2)
	public String nomeTeste;
	
	private LocacaoService service;
	
	private static final Filme filme  = new Filme("Filme 1", 1, 4.0);
	private static final Filme filme2 = new Filme("Filme 2", 1, 4.0);
	private static final Filme filme3 = new Filme("Filme 3", 1, 4.0);
	private static final Filme filme4 = new Filme("Filme 4", 1, 4.0);
	private static final Filme filme5 = new Filme("Filme 5", 1, 4.0);
	private static final Filme filme6 = new Filme("Filme 6", 1, 4.0);
	
	@Parameters(name = "{2}")
	public static Collection<Object[]> getParametros(){
		return  Arrays.asList(new Object[][]{
			{new HashSet<>(Arrays.asList(
					filme,
					filme2)),8.0,"2 filmes sem desconto"},
			{new HashSet<>(Arrays.asList(
					filme,
					filme2,
					filme3)),11.0,"3 filmes desconto 25%"},
			{new HashSet<>(Arrays.asList(
					filme,
					filme2,
					filme3,
					filme4)),13.0,"4 filmes desconto 50%"},
			{new HashSet<>(Arrays.asList(
						filme,
						filme2,
						filme3,
						filme4,
						filme5)),14.0,"5 filmes desconto 55%"},
			{new HashSet<>(Arrays.asList(
						filme,
						filme2,
						filme3,
						filme4,
						filme5,
						filme6)),14.0,"6 filmes desconto 100%"},
			});
	}
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup(){
		 service = new LocacaoService();
	}	
	
	@Test
  public void deveCalcularValorLocacao() throws Exception {
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
//		LinkedHashSet<Filme> filme = new LinkedHashSet<>(
//				Arrays.asList(
//						filme,
//						filme2,
//						filme3
//				));
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filmes);
			
		//verificacao
		Assert.assertThat(locacao.getValor(), CoreMatchers.is(valorLocacao));
	}
	
	@Test
	public void imprimeTeste(){
		System.out.println(valorLocacao);
	}
}
