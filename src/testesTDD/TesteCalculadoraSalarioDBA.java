package testesTDD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cargos.Cargo;
import cargos.DBA;
import exceptions.SalarioInvalidoException;

public class TesteCalculadoraSalarioDBA {
	
	private static final String SALARIO_NAO_PODE_SER_NEGATIVO_MSG = "Salario nao pode ser negativo!";
	private static final double SALARIO_MAIOR_SALARIO_BASE = 2000.00000009;
	private static final double SALARIO_BASE_DBA = 2000.0;
	private static final double SALARIO_MENOR_SALARIO_BASE = 1999.90;
	private static final double SALARIO_NEGATIVO = -2999.90;
	private static final double QUINZE_PORCENTO = 0.15;
	private static final double VINTE_E_CINCO_PORCENTO = 0.25;
	private Cargo dba;
	
	@Before
	public void setUp(){
		dba = new DBA();
	}
	
	@Test
	public void testaCriacaoDBASalarioNegativo(){
		try{
			dba = new DBA(SALARIO_NEGATIVO);
		}
		catch (Exception e) {
			Assert.assertEquals(new SalarioInvalidoException().getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testaCalcularDescontoDBASalarioMenorQueSalarioBase(){
		try {
			dba = new DBA(SALARIO_MENOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(QUINZE_PORCENTO, dba.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularDescontoDBASalarioSalarioBase(){
		try {
			dba = new DBA(SALARIO_BASE_DBA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(VINTE_E_CINCO_PORCENTO, dba.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularDescontoDBASalarioMaiorQueSalarioBase(){
		try {
			dba = new DBA(SALARIO_MAIOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(VINTE_E_CINCO_PORCENTO, dba.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularSalarioDBADesconto15Porcento(){
		try {
			dba = new DBA(SALARIO_MENOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 1699.915;
		Assert.assertEquals(salarioComDesconto, dba.calcularSalario(), 0.00001);
	}
	
	@Test
	public void testaCalcularSalarioDBADesconto25Porcento(){
		try {
			dba = new DBA(SALARIO_BASE_DBA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 1500.0;
		Assert.assertEquals(salarioComDesconto, dba.calcularSalario(), 0.00001);
	}
	
}
