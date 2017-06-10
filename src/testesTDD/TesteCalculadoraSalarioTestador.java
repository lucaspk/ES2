package testesTDD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cargos.Cargo;
import cargos.Gerente;
import cargos.Testador;
import exceptions.CargoInvalidoException;
import exceptions.DadosDoFuncionarioInvalidosException;
import exceptions.SalarioInvalidoException;
import funcionario.Funcionario;

public class TesteCalculadoraSalarioTestador {
	
	private static final double SALARIO_MAIOR_SALARIO_BASE = 2000.00000009;
	private static final double SALARIO_BASE_TESTADOR = 2000.0;
	private static final double SALARIO_MENOR_SALARIO_BASE = 1999.90;
	private static final double SALARIO_NEGATIVO = -2999.90;
	private static final double QUINZE_PORCENTO = 0.15;
	private static final double VINTE_E_CINCO_PORCENTO = 0.25;
	private Cargo testador;
	
	@Before
	public void setUp(){
		testador = new Testador();
	}
	
	@Test
	public void testaCriacaoTestadorSalarioNegativo(){
		try{
			testador = new Testador(SALARIO_NEGATIVO);
		}
		catch (Exception e) {
			Assert.assertEquals(new SalarioInvalidoException().getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testaCalcularDescontoTestadorSalarioMenorQueSalarioBase(){
		try {
			testador = new Testador(SALARIO_MENOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(QUINZE_PORCENTO, testador.calcularPorcentagemDesconto(), 0.00001);
		Assert.assertEquals(QUINZE_PORCENTO, new Testador().getMinimaPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularDescontoTestadorSalarioSalarioBase(){
		try {
			testador = new Testador(SALARIO_BASE_TESTADOR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(VINTE_E_CINCO_PORCENTO, testador.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularDescontoTestadorSalarioMaiorQueSalarioBase(){
		try {
			testador = new Testador(SALARIO_MAIOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(VINTE_E_CINCO_PORCENTO, testador.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularSalarioTestadorDesconto15Porcento(){
		try {
			testador = new Testador(SALARIO_MENOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 1699.915;
		Assert.assertEquals(salarioComDesconto, testador.calcularSalario(), 0.00001);
	}
	
	@Test
	public void testaCalcularSalarioTestadorDesconto25Porcento(){
		try {
			testador = new Testador(SALARIO_BASE_TESTADOR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 1500.0;
		Assert.assertEquals(salarioComDesconto, testador.calcularSalario(), 0.00001);
	}
	
	@Test
	public void testaAlterarMinPorcentagemComSucesso(){
		Cargo testador = new Testador();
		Assert.assertEquals(0.15, testador.getMinimaPorcentagemDesconto(), 0.00001);
		testador.setMinimaPorcentagemDesconto(0.1);
		Assert.assertEquals(0.1, testador.getMinimaPorcentagemDesconto(), 0.00001);
		
	}
	
	@Test
	public void testaAlterarMinPorcentagemComFracasso(){
		Cargo testador = new Testador();
		Assert.assertEquals(0.15, testador.getMinimaPorcentagemDesconto(), 0.00001);
		try {
			testador.setMinimaPorcentagemDesconto(0.5);
		} catch (Exception e) {
			Assert.assertEquals("", e.getMessage());
		}
		Assert.assertEquals(0.15, testador.getMinimaPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaAlterarMaxPorcentagemComSucesso(){
		Cargo testador = new Testador();
		Assert.assertEquals(0.25, testador.getMaximaPorcentagemDesconto(), 0.00001);
		testador.setMaximaPorcentagemDesconto(0.5);
		Assert.assertEquals(0.5, testador.getMaximaPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaAlterarMaxPorcentagemComFracasso(){
		Cargo testador = new Testador();
		Assert.assertEquals(0.25, testador.getMaximaPorcentagemDesconto(), 0.00001);
		testador.setMaximaPorcentagemDesconto(0.15);
		Assert.assertEquals(0.25, testador.getMaximaPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaAlterarMaxPorcentagemComFracassoParaNegativa(){
		Cargo testador = new Testador();
		Assert.assertEquals(0.25, testador.getMaximaPorcentagemDesconto(), 0.00001);
		testador.setMaximaPorcentagemDesconto(-0.15);
		Assert.assertEquals(0.25, testador.getMaximaPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaAlterarMinPorcentagemComFracassoParaNegativa(){
		Cargo testador = new Testador();
		Assert.assertEquals(0.15, testador.getMinimaPorcentagemDesconto(), 0.00001);
		try {
			testador.setMinimaPorcentagemDesconto(-0.5);
		} catch (Exception e) {
			Assert.assertEquals("", e.getMessage());
		}
		Assert.assertEquals(0.15, testador.getMinimaPorcentagemDesconto(), 0.00001);
	}
	
}
