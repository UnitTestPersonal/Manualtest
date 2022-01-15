package br.ce.wcaquino.servicos;



import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;
import static br.ce.wcaquino.utils.DataUtils.adicionarDias;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashSet;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

public class LocacaoServiceTest {

	private static int counter = 0;
	private LocacaoService service;
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

  @Before
	public void setup(){
    System.out.println("antes");
		 service = new LocacaoService();
    System.out.println(++counter);
	}

  @After
	public void tearDown(){
    System.out.println("depois.");
	}

	
	private static final Filme filme1 = new Filme("Filme 1", 1, 4.0);
	private static final Filme filme2 = new Filme("Filme 2", 1, 5.0);
	private static final Filme filme3 = new Filme("Filme 3", 1, 6.0);
	private static final Filme filme4 = new Filme("Filme 4", 1, 7.0);
	private static final Filme filme5 = new Filme("Filme 5", 1, 8.0);
	private static final Filme filme6 = new Filme("Filme 6", 1, 9.0);
	
	  @BeforeClass
		public static  void setupClass(){
			System.out.println("antes Class");
		}

		@AfterClass
		public static void tearDownClass(){
			System.out.println("depois Class.");
		}
	
  @Test
  public void testeLocacao() throws FilmeSemEstoqueException, LocadoraException  {
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		LinkedHashSet<Filme> filme = new LinkedHashSet<>(
				Arrays.asList(
						filme1,
						filme2
				));
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
			
		//verificacao
		error.checkThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.equalTo(9.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), CoreMatchers.is(true));
	}
	
	@Test(expected = FilmeSemEstoqueException.class)
	public void testLocacao_filmeSemEstoque() throws  LocadoraException, FilmeSemEstoqueException{
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
    LinkedHashSet<Filme> filme = new LinkedHashSet<>(
				Arrays.asList(
						filme1,
						new Filme("Filme 2", 0, 5.0)));

		//acao
		service.alugarFilme(usuario, filme);
	}
	
	@Test
	public void testLocacao_usuarioVazio() throws FilmeSemEstoqueException{
		
    Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		//cenario
		LinkedHashSet<Filme> filme = new LinkedHashSet<>(
				Arrays.asList(
						filme1,
						filme2));
		
		//acao
		try {
			service.alugarFilme(null, filme);
			Assert.fail();
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), CoreMatchers.is("Usuario vazio"));
		}
	}
	
	@Test
	public void testLocacao_FilmeVazio() throws FilmeSemEstoqueException, LocadoraException{
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		
		//acao
		service.alugarFilme(usuario, null);
	}
	@Test
  public void testeLocacao25desconto() throws Exception {
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		LinkedHashSet<Filme> filme = new LinkedHashSet<>(
				Arrays.asList(
						filme1,
						filme2,
						filme3
				));
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
			
		//verificacao
		error.checkThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.equalTo(13.5)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), CoreMatchers.is(true));
	}
	
	@Test
  public void testeLocacao50desconto() throws Exception {
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		LinkedHashSet<Filme> filme = new LinkedHashSet<>(
				Arrays.asList(
						filme1,
						filme2,
						filme3,
						filme4
				));
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
			
		//verificacao
		error.checkThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.equalTo(17.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), CoreMatchers.is(true));
	}
	
	@Test
  public void testeLocacao75desconto() throws Exception {
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		LinkedHashSet<Filme> filme = new LinkedHashSet<>(
				Arrays.asList(
						filme1,
						filme2,
						filme3,
						filme4,
						filme5
				));
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
			
		//verificacao
		error.checkThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.equalTo(19.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), CoreMatchers.is(true));
	}
	
	@Test
  public void testeLocacao100desconto() throws Exception {
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		LinkedHashSet<Filme> filme = new LinkedHashSet<>(
				Arrays.asList(
						filme1,
						filme2,
						filme3,
						filme4,
						filme5,
						filme6
				));
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
			
		//verificacao
		error.checkThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.equalTo(19.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), CoreMatchers.is(true));
	}
	@Test
  public void testeLocacao100desconto9Itens() throws Exception {
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		LinkedHashSet<Filme> filme = new LinkedHashSet<>(
				Arrays.asList(
						filme1,
						filme2,
						filme3,
						filme4,
						filme5,
						filme6,
						new Filme("Filme 7", 1, 10.0),
						new Filme("Filme 8", 1, 11.0),
						new Filme("Filme 9", 1, 12.0)
				));
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
			
		//verificacao
		error.checkThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.equalTo(52.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), CoreMatchers.is(true));
	}

  @Test
  public void semDevolucaoDomingo() throws FilmeSemEstoqueException, LocadoraException {
    Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		LinkedHashSet<Filme> filme = new LinkedHashSet<>(
				Arrays.asList(
						filme1,
						filme2
				));
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		//verificacao
		error.checkThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.equalTo(9.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), CoreMatchers.is(true));
    error.checkThat(locacao.getDataRetorno().getDay(), CoreMatchers.not(CoreMatchers.equalTo(0)));
	}
	
}
