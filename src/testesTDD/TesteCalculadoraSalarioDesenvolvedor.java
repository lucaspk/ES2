package testesTDD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cargos.Cargo;
import cargos.Desenvolvedor;
import exceptions.SalarioInvalidoException;

public class TesteCalculadoraSalarioDesenvolvedor {
	
	private static final double SALARIO_MAIOR_SALARIO_BASE = 3000.00000009;
	private static final double SALARIO_BASE_DESENVOLVEDOR = 3000.0;
	private static final double SALARIO_MENOR_SALARIO_BASE = 2999.90;
	private static final double SALARIO_NEGATIVO = -2999.90;
	private static final double DEZ_PORCENTO = 0.1;
	private static final double VINTE_PORCENTO = 0.2;
	private Cargo desenvolvedor;
	
	@Before
	public void setUp(){
		desenvolvedor = new Desenvolvedor();
	}
	
	@Test
	public void testaCriacaoDesenvolvedorSalarioNegativo(){
		try{
			desenvolvedor = new Desenvolvedor(SALARIO_NEGATIVO);
		}
		catch (Exception e) {
			Assert.assertEquals(new SalarioInvalidoException().getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testaCalcularDescontoDesenvolvedorSalarioMenorQueSalarioBase(){
		try {
			desenvolvedor = new Desenvolvedor(SALARIO_MENOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(DEZ_PORCENTO, desenvolvedor.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularDescontoDesenvolvedorSalarioBase(){
		try {
			desenvolvedor = new Desenvolvedor(SALARIO_BASE_DESENVOLVEDOR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(VINTE_PORCENTO, desenvolvedor.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularDescontoDesenvolvedorSalarioMaiorQueSalarioBase(){
		try {
			desenvolvedor = new Desenvolvedor(SALARIO_MAIOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(VINTE_PORCENTO, desenvolvedor.calcularPorcentagemDesconto(), 0.00001);
	}
	
	@Test
	public void testaCalcularSalarioDesenvolvedorDesconto10Porcento(){
		try {
			desenvolvedor = new Desenvolvedor(SALARIO_MENOR_SALARIO_BASE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 2699.91;
		Assert.assertEquals(salarioComDesconto, desenvolvedor.calcularSalario(), 0.00001);
	}
	
	@Test
	public void testaCalcularSalarioDesenvolvedorDesconto20Porcento(){
		try {
			desenvolvedor = new Desenvolvedor(SALARIO_BASE_DESENVOLVEDOR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 2400.0;
		Assert.assertEquals(salarioComDesconto, desenvolvedor.calcularSalario(), 0.00001);
	}
}
