package testesTDD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cargos.Cargo;
import cargos.Gerente;
import exceptions.SalarioInvalidoException;

public class TesteCalculadoraSalarioGerente {
	
	private static final String SALARIO_NAO_PODE_SER_NEGATIVO_MSG = "Salario nao pode ser negativo!";
	private static final double SALARIO_MAIOR_SALARIO_BASE = 5000.00000009;
	private static final double SALARIO_BASE_GERENTE = 5000.0;
	private static final double SALARIO_MENOR_SALARIO_BASE = 4999.00;
	private static final double SALARIO_NEGATIVO = -2999.90;
	private static final double CINQUENTA_PORCENTO = 0.5;
	private static final double VINTE_PORCENTO = 0.2;
	private Cargo gerente;
	
	@Before
	public void setUp(){
		gerente = new Gerente();
	}
	
	@Test
	public void testaCriacaoGerenteSalarioNegativo(){
		try{
			gerente = new Gerente(SALARIO_NEGATIVO);
		}
		catch (Exception e) {
			Assert.assertEquals(new SalarioInvalidoException().getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testaCalcularDescontoGerenteSalarioMenorQueSalarioBase(){
		try {
			gerente = new Gerente(SALARIO_MENOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(VINTE_PORCENTO, gerente.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularDescontoGerenteSalarioBase(){
		try {
			gerente = new Gerente(SALARIO_BASE_GERENTE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(CINQUENTA_PORCENTO, gerente.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularDescontoGerenteSalarioMaiorQueSalarioBase(){
		try {
			gerente = new Gerente(SALARIO_MAIOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(CINQUENTA_PORCENTO, gerente.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularSalarioGerenteDesconto10Porcento(){
		try {
			gerente = new Gerente(SALARIO_MENOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 3999.20;
		Assert.assertEquals(salarioComDesconto, gerente.calcularSalario(), 0.00001);
	}
	
	@Test
	public void testaCalcularSalarioGerenteDesconto20Porcento(){
		try {
			gerente = new Gerente(SALARIO_BASE_GERENTE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 2500.0;
		Assert.assertEquals(salarioComDesconto, gerente.calcularSalario(), 0.00001);
	}
}
