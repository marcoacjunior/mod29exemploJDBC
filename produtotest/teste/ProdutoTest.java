package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import dao.IProdutoDAO;
import dao.ProdutoDAO;
import domain.Produto;

public class ProdutoTest {

	private IProdutoDAO produtoDAO;

	@Test
	public void cadastrarTest() throws Exception {
		produtoDAO = new ProdutoDAO();

		Produto produto = new Produto();
		produto.setCodigo("15");
		produto.setDescricao("Produto XXX");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);

		Produto produtoBD = produtoDAO.buscar("15");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getDescricao(), produtoBD.getDescricao());

		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTest() throws Exception {
		produtoDAO = new ProdutoDAO();

		Produto produto = new Produto();
		produto.setCodigo("15");
		produto.setDescricao("Produto XXX");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);

		Produto produtoBD = produtoDAO.buscar("15");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getDescricao(), produtoBD.getDescricao());

		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void excluirTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("15");
		produto.setDescricao("Produto XXX");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);

		Produto produtoBD = produtoDAO.buscar("15");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getDescricao(), produtoBD.getDescricao());

		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTodosTest() throws Exception {
		produtoDAO = new ProdutoDAO();

		Produto produto = new Produto();
		produto.setCodigo("15");
		produto.setDescricao("Produto XXX");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);

		Produto produtos = new Produto();
		produtos.setCodigo("20");
		produtos.setDescricao("Teste");
		Integer countCad2 = produtoDAO.cadastrar(produtos);
		assertTrue(countCad2 == 1);

		List<Produto> list = produtoDAO.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());

		int countDel = 0;
		for (Produto pro : list) {
			produtoDAO.excluir(pro);
			countDel++;
		}
		assertEquals(list.size(), countDel);

		list = produtoDAO.buscarTodos();
		assertEquals(list.size(), 0);

	}
	
	@Test
	public void atualizarTest() throws Exception {
		produtoDAO = new ProdutoDAO();

		Produto produto = new Produto();
		produto.setCodigo("15");
		produto.setDescricao("Cliente XXX");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);

		Produto produtoBD = produtoDAO.buscar("15");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getDescricao(), produtoBD.getDescricao());

		produtoBD.setCodigo("25");
		produtoBD.setDescricao("Outro produto");
		Integer countUpdate = produtoDAO.atualizar(produtoBD);
		assertTrue(countUpdate == 1);

		Produto produtoBD1 = produtoDAO.buscar("15");
		assertNull(produtoBD1);

		Produto produtoBD2 = produtoDAO.buscar("25");
		assertNotNull(produtoBD2);
		assertEquals(produtoBD.getId(), produtoBD2.getId());
		assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
		assertEquals(produtoBD.getDescricao(), produtoBD2.getDescricao());

		List<Produto> list = produtoDAO.buscarTodos();
		for (Produto pro : list) {
			produtoDAO.excluir(pro);
		}
	
}

}







