package testesTDD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cargos.Cargo;
import cargos.Gerente;
import cargos.Testador;
import exceptions.CargoInvalidoException;
import exceptions.DadosDoFuncionarioInvalidosException;
import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;
import exceptions.SalarioInvalidoException;
import funcionario.Funcionario;

public class TesteDadosDoFuncionario {
		
	private String nomeInvalidoComApenasLetras;
	private String nomeInvalidoMisturandoLetrasEVariosNumeros;
	private String nomeInvalidoMisturandoLetrasEApenasUmNumero;
	private String nomeInvalidoMisturandoLetrasECharsEspeciais;
	private String nomeInvalidoMisturandoLetrasENumerosECharsEspeciais;
	private String nomeInvalidoComApenasCharsEspeciais;
	private String nomeInvalidoComApenasNumeros;
	private String nomeInvalidoComApenasEspacos;
	private String nomeValido;
		
	private String emailValido;
	private String emailInvalidoComecandoComNumero;
	private String emailInvalidoComecandoComArroba;
	private String emailInvalidoComecandoComPonto;
	private String emailInvalidoComecandoComUnderscore;
	private String emailInvalidoComecandoComHifen;
	private String emailInvalidoComApenasNumerosAntesDoArroba;
	private String emailInvalidoComApenasCharsEspeciaisNoPrefixo;
	private String emailInvalidoComApenasEspacosAntesDoArroba;
	private String emailInvalidoComApenasEspacos;
	private String emailInvalidoComEspacoNoPrefixo;
	private String emailValidoComUnderscoreAntesDoArroba;
	private String emailValidoComPontoNoPrefixo;
	private String emailValidoComHyphenAntesDoArroba;
	private String emailValidoComLetraComoPrimeiroChar;
	private String emailInvalidoComCharsEspeciaisInvalidosNoPrefixo;
	private Funcionario funcionarioInvalido;
	private Funcionario funcionarioValido;
		
	@Before
	public void setUpValidUserData() throws DadosDoFuncionarioInvalidosException{
		nomeValido = "Jobson Lucas";		
		
		emailValido = "lucas@gmail.com";
		emailValidoComUnderscoreAntesDoArroba = "lucas_dias@gmail.com";
		emailValidoComPontoNoPrefixo = "lucas.dias@gmail.com";
		emailValidoComHyphenAntesDoArroba = "lucas-dias@gmail.com";
		emailValidoComLetraComoPrimeiroChar = "a5648546@gmail.com";
	}
	
	@Before
	public void setUpInvalidUserData(){
		nomeInvalidoComApenasLetras = "JobsonLucasDias";
		nomeInvalidoComApenasNumeros = "1651561681818616818161516156";
		nomeInvalidoComApenasCharsEspeciais = "!bs@#      ¬¢*$   |)/%£_=+§{}ºª°?/;:<>¹²³";
		nomeInvalidoComApenasEspacos = "                           ";
		nomeInvalidoMisturandoLetrasEVariosNumeros = "Jobson54654 Lucas245541561";
		nomeInvalidoMisturandoLetrasEApenasUmNumero = "Jobson Lucas2";
		nomeInvalidoMisturandoLetrasECharsEspeciais = "Job$@# ¬u¢@! !@#sdf#WER@xcv$%$¨¨¨&**/-*";
		nomeInvalidoMisturandoLetrasENumerosECharsEspeciais = "J156651o51b$@# 156156¬u¢@!asdqwe2 !@#sdf#WER@xcv$%$¨¨¨&**/-*";
				
		emailInvalidoComecandoComNumero = "9sdfsdf99@gmail.com";
		emailInvalidoComecandoComPonto = ".999@gmail.com";
		emailInvalidoComecandoComUnderscore= "_999@gmail.com";
		emailInvalidoComecandoComHifen= "-999@gmail.com";
		emailInvalidoComecandoComArroba = "999gmail.com";
		emailInvalidoComApenasNumerosAntesDoArroba = "999@gmail.com";
		emailInvalidoComApenasCharsEspeciaisNoPrefixo= "+-/*/*+.@gmail.com";
		emailInvalidoComApenasEspacosAntesDoArroba = "                      @gmail.com";
		emailInvalidoComApenasEspacos = "                              ";
		emailInvalidoComEspacoNoPrefixo = "lucas dias@gmail.com";
		emailInvalidoComCharsEspeciaisInvalidosNoPrefixo = "luc+a*s&dias@gmail.com";	
	}	
	
	@Test
	public void testaCriacaoFuncionarioEmailComAtLeastOneLetterAntesDoArroba(){
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComLetraComoPrimeiroChar, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComHyphenAntesDoArroba(){
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComHyphenAntesDoArroba, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComDotAntesDoArroba(){
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, new Testador(), 0.1);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComUnderscoreAntesDoArroba(){
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComUnderscoreAntesDoArroba, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComSpaceAntesDoArroba(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComEspacoNoPrefixo, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComCharsEspeciaisAntesDoArroba(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComCharsEspeciaisInvalidosNoPrefixo, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComApenasEspacos(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComApenasEspacos, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComApenasEspacosAntesDoArroba(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComApenasEspacosAntesDoArroba, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComApenasCharsEspeciaisAntesDoArroba(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComApenasCharsEspeciaisNoPrefixo, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComApenasNumerosAntesDoArroba(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComApenasNumerosAntesDoArroba, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComHyphenAsFirstChar(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComecandoComHifen, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testaCriacaoFuncionarioEmailComUnderscoreAsFirstChar(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComecandoComUnderscore, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testaCriacaoFuncionarioEmailComDotAsFirstChar(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComecandoComPonto, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testaCriacaoFuncionarioEmailComoutAtSymbol(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComecandoComArroba, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioEmailComNumeroAsFirstChar(){
		try {
			funcionarioInvalido = new Funcionario(nomeValido, emailInvalidoComecandoComNumero, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		
	}
		
	@Test
	public void testCreatingFuncionarioValidData(){
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValido, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
		
	@Test
	public void testaCriacaoFuncionarioComApenasLetrasNoNome(){
		try {
			funcionarioInvalido = new Funcionario(nomeInvalidoComApenasLetras, emailValido, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioComApenasNumerosComoNome(){
		try {
			funcionarioInvalido = new Funcionario(nomeInvalidoComApenasNumeros, emailValido, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioComApenasEspacosComoNome(){
		try {
			funcionarioInvalido = new Funcionario(nomeInvalidoComApenasEspacos, emailValido, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioComApenasSpecialCharComoNome(){
		try {
			funcionarioInvalido = new Funcionario(nomeInvalidoComApenasCharsEspeciais, emailValido, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testaCriacaoFuncionarioComSpecialCharENumeroNoNome(){
		try {
			funcionarioInvalido = new Funcionario(nomeInvalidoMisturandoLetrasENumerosECharsEspeciais, emailValido, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioComSpecialCharNoNome(){
		try {
			funcionarioInvalido = new Funcionario(nomeInvalidoMisturandoLetrasECharsEspeciais, emailValido, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
			
	@Test
	public void testaCriacaoFuncionarioComSingleNumeroNoNome(){
		try {
			funcionarioInvalido = new Funcionario(nomeInvalidoMisturandoLetrasEApenasUmNumero, emailValido, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioComVariosNumerosNoNome(){
		try {
			funcionarioInvalido = new Funcionario(nomeInvalidoMisturandoLetrasEVariosNumeros, emailValido, new Testador(), 0);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testaCriacaoFuncionarioComCargoNull(){
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, null, 0.1);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new CargoInvalidoException().getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testaCriacaoFuncionarioComSalarioLiquidoNegativo(){
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, new Testador(), -0.1);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new SalarioInvalidoException().getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testaMudarSalarioLiquidoERecalcularValorSalario(){
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, new Testador(), 2500);
		} catch (DadosDoFuncionarioInvalidosException e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 1875.0;
		Assert.assertEquals(salarioComDesconto, funcionarioValido.calcularSalario(), 0.00001);
		funcionarioValido.setSalarioLiquido(2000.0);
		salarioComDesconto = 1500.0;
		Assert.assertEquals(salarioComDesconto, funcionarioValido.calcularSalario(), 0.00001);
	}

	@Test
	public void testaMudarPorcentagemMaximaDescontoERecalcularSalarioLiquido(){
		Cargo testador = new Testador();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
		} catch (DadosDoFuncionarioInvalidosException e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 1875.0;
		Assert.assertEquals(salarioComDesconto, funcionarioValido.calcularSalario(), 0.00001);
		testador.setMaximaPorcentagemDesconto(0.3);
		salarioComDesconto = 1750.0;
		Assert.assertEquals(salarioComDesconto, funcionarioValido.calcularSalario(), 0.00001);
	}
	
	@Test
	public void testaMudarPorcentagemMinimaDescontoERecalcularSalarioLiquido(){
		Cargo testador = new Testador();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 1800);
		} catch (DadosDoFuncionarioInvalidosException e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 1530.0;
		Assert.assertEquals(salarioComDesconto, funcionarioValido.calcularSalario(), 0.00001);
		testador.setMinimaPorcentagemDesconto(0.1);
		salarioComDesconto = 1620.0;
		Assert.assertEquals(salarioComDesconto, funcionarioValido.calcularSalario(), 0.00001);
	}

	@Test
	public void testaMudarSalarioBaseERecalcularSalarioLiquido(){
		Cargo testador = new Testador();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
		} catch (DadosDoFuncionarioInvalidosException e) {
			e.printStackTrace();
		}
		double salarioComDesconto = 1875.0;
		Assert.assertEquals(salarioComDesconto, funcionarioValido.calcularSalario(), 0.00001);
		testador.setSalarioBase(3000);
		salarioComDesconto = 2125.0;
		Assert.assertEquals(salarioComDesconto, funcionarioValido.calcularSalario(), 0.00001);
	}
	
	@Test
	public void testaAlterarNomeFuncionarioParaOutroValido(){
		Cargo testador = new Testador();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
			funcionarioValido.setNome(nomeValido);
		} catch (DadosDoFuncionarioInvalidosException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(nomeValido, funcionarioValido.getNome());	
	}
	
	@Test
	public void testaAlterarNomeFuncionarioParaOutroInvalido(){
		Cargo testador = new Testador();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
			funcionarioValido.setNome(nomeInvalidoComApenasNumeros);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new NomeInvalidoException().getMessage(), e.getMessage());
		}
		Assert.assertEquals(nomeValido, funcionarioValido.getNome());
	}
	
	@Test
	public void testaAlterarEmailFuncionarioParaOutroInvalido(){
		Cargo testador = new Testador();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
			funcionarioValido.setEmail(emailInvalidoComApenasCharsEspeciaisNoPrefixo);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		Assert.assertEquals(emailValidoComPontoNoPrefixo, funcionarioValido.getEmail());
	}
	
	@Test
	public void testaAlterarEmailFuncionarioParaOutroValido(){
		Cargo testador = new Testador();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
			funcionarioValido.setEmail(emailValidoComLetraComoPrimeiroChar);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new EmailInvalidoException().getMessage(), e.getMessage());
		}
		Assert.assertEquals(emailValidoComLetraComoPrimeiroChar, funcionarioValido.getEmail());
	}
	
	@Test
	public void testaAlterarSalarioFuncionarioParaOutroValido(){
		Cargo testador = new Testador();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
			funcionarioValido.setSalarioLiquido(2560);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new SalarioInvalidoException().getMessage(), e.getMessage());
		}
		Assert.assertEquals(2560, funcionarioValido.getSalarioLiquido(), 0.00001);
	}
	
	@Test
	public void testaAlterarSalarioFuncionarioParaOutroInvalido(){
		Cargo testador = new Testador();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
			funcionarioValido.setSalarioLiquido(-2560);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new SalarioInvalidoException().getMessage(), e.getMessage());
		}
		Assert.assertEquals(2500, funcionarioValido.getSalarioLiquido(), 0.00001);
	}
	
	@Test
	public void testaAlterarCargoFuncionarioParaOutroInvalido(){
		Cargo testador = new Testador();
		Cargo gerente = null;
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
			funcionarioValido.setCargo(gerente);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new CargoInvalidoException().getMessage(), e.getMessage());
		}
		Assert.assertEquals(testador, funcionarioValido.getCargo());
	}
	
	@Test
	public void testaAlterarCargoFuncionarioParaOutroValido(){
		Cargo testador = new Testador();
		Cargo gerente = new Gerente();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
			funcionarioValido.setCargo(gerente);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new CargoInvalidoException().getMessage(), e.getMessage());
		}
		Assert.assertEquals(gerente, funcionarioValido.getCargo());
	}
	
	@Test
	public void testaAlterarCargoFuncionarioRecalcularSalario(){
		Cargo testador = new Testador();
		Cargo gerente = new Gerente();
		try {
			funcionarioValido = new Funcionario(nomeValido, emailValidoComPontoNoPrefixo, testador, 2500);
		} catch (DadosDoFuncionarioInvalidosException e) {
			Assert.assertEquals(new CargoInvalidoException().getMessage(), e.getMessage());
		}
		double salarioComDesconto = 1875.0;
		Assert.assertEquals(salarioComDesconto, funcionarioValido.calcularSalario(), 0.00001);
		funcionarioValido.setCargo(gerente);
		Assert.assertEquals(gerente, funcionarioValido.getCargo());
	}
	
}
