package br.ce.wcaquino.servicos;

import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.daos.LocacaoDAOFake;
import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import java.util.HashSet;
import java.util.LinkedList;

public class LocacaoService {
	
		LocacaoDAO dao;
		SPCService spc;
		
  public Locacao alugarFilme(Usuario usuario, HashSet<Filme> filmes)
      throws FilmeSemEstoqueException, LocadoraException {
		if(usuario == null) {
			throw new LocadoraException("Usuario vazio");
		}else if(spc.possuinegativacao(usuario)){
			throw new LocadoraException("Usuario negativado");
		}
		
		
		
		if(filmes == null ||filmes.isEmpty()) {
			throw new LocadoraException("Filme vazio");
		}
		Locacao locacao = new Locacao();
		locacao.setFilme(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
    locacao.setValor(geraTotal(filmes));

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		if(dataEntrega.getDay() == 0) dataEntrega = adicionarDias(dataEntrega, 1);
    // Salvando a locacao...
    dao.salvar(locacao);

		return locacao;
	}
	private double	semDesconto(LinkedList<Filme> filmes,double volta) throws LocadoraException{
		if(filmes == null ||filmes.isEmpty()) throw new LocadoraException("Filme vazio");
		
		double result = 0;
		for(Filme f :filmes) result += f.getPrecoLocacao();
		return volta + result;
	}
	
	private double	desconto25(LinkedList<Filme> filmes,double volta) throws LocadoraException{
		if(filmes == null ||filmes.isEmpty()) throw new LocadoraException("Filme vazio");
		
		if(filmes.size() == 3){
			Filme filme = filmes.pop();
      return semDesconto(filmes, volta + (filme.getPrecoLocacao()*0.75));
		}
		else if(filmes.size() < 3){
			return semDesconto( filmes,volta);
		}
		else{
			throw new LocadoraException("Quantidade de filmes maior que três.");
		}
	}
	
	private double	desconto50(LinkedList<Filme> filmes,double volta) throws LocadoraException{
		if(filmes == null ||filmes.isEmpty()) throw new LocadoraException("Filme vazio");
			
		if(filmes.size()== 4){
			Filme filme = filmes.pop();
      return desconto25(filmes, volta + (filme.getPrecoLocacao() - (filme.getPrecoLocacao()*0.5)));
		}
		else if(filmes.size() < 4){
			return desconto25( filmes,volta);
		}
		else{
			throw new LocadoraException("Quantidade de filmes maior que quatro.");
		}
	}
	
	private double	desconto75(LinkedList<Filme> filmes,double volta) throws LocadoraException{
		if(filmes == null ||filmes.isEmpty()) {
			throw new LocadoraException("Filme vazio");
		}
		if(filmes.size()== 5){
			Filme filme = filmes.pop();
      return desconto50(filmes, volta + (filme.getPrecoLocacao()*0.25));
		}
		else if(filmes.size() < 5){
			return desconto50( filmes,volta);
		}
		else{
			throw new LocadoraException("Quantidade de filmes maior que cinco.");
		}
	}
	
	private double	desconto100(LinkedList<Filme> filmes,double volta) throws LocadoraException{
		if(filmes == null ||filmes.isEmpty()) {
			throw new LocadoraException("Filme vazio");
		}
		if(filmes.size()== 6){
			filmes.pop();
      return desconto75(filmes, volta);
		}
		else if(filmes.size() < 6){
			return desconto75( filmes,volta);
		}
		else{
			throw new LocadoraException("Quantidade de filmes maior que seis.");
		}
	}
	
	private double geraTotal(HashSet<Filme> filmes) throws FilmeSemEstoqueException, LocadoraException{
			LinkedList<Filme> list = new LinkedList<>();
			double volta = 0;
			
			for(Filme filme :filmes) {
				if(filme.getEstoque()== 0)throw new FilmeSemEstoqueException("Filme vazio");
				list.push(filme);
			}
			
			while(list.size() > 6){
				volta += list.pop().getPrecoLocacao();
			}
			return desconto100(list,volta);
	}

	void setLocacao(LocacaoDAO dao) {
		this.dao = dao;
	}

	public void setSpc(SPCService spc) {
		this.spc = spc;
	}
	
}