package com.br.alvaro.TestesUnitarios.TestesUnitarios;

import com.br.alvaro.TestesUnitarios.TestesUnitarios.Service.LocacaoService;
import com.br.alvaro.TestesUnitarios.TestesUnitarios.entidades.Filme;
import com.br.alvaro.TestesUnitarios.TestesUnitarios.entidades.Locacao;
import com.br.alvaro.TestesUnitarios.TestesUnitarios.entidades.Usuario;
import com.br.alvaro.TestesUnitarios.TestesUnitarios.utils.DataUtils;
import java.util.Date;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestesUnitariosApplicationTests {

	@Test
	void contextLoads() {
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
