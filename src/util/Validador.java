package util;

import cargos.Cargo;

public class Validador {
	private final static String NOME_REGEX = "[a-z A-Z]+";
	private final static String CHARS_VALIDOS_EMAIL = "[0-9a-zA-Z-._]+";
	private final static String APENAS_LETRAS = "[a-zA-Z]+";
	private final static String SIMBOLO_ARROBA = "@";
		
	public static boolean nomeEhValido(final String nome) {
		boolean ehValido = true;
		final String primeiroCharDoNome = getPrimeiroCharComoString(nome);
		if(!primeiroCharDoNome.matches(APENAS_LETRAS)
				|| !nome.matches(NOME_REGEX)){
			ehValido = false;
		}	
		return ehValido;
	}
	
	private static String getPrimeiroCharComoString(final String nome){
		String resposta = "";
		if(!nome.isEmpty()){
			resposta = nome.substring(0,1);
		}
		return resposta;
	}
	
	private static String getTrechoAntesDoArroba(final String email){
		final String[] emailSeparado = email.split(SIMBOLO_ARROBA);
		return emailSeparado[0];
	}

	public static boolean emailEhValido(final String email) {
		final String primeiroCharDoEmail = getPrimeiroCharComoString(email);
		boolean emailEhValido = email.contains(SIMBOLO_ARROBA) && primeiroCharDoEmail.matches(APENAS_LETRAS);
		if(emailEhValido){
			final String primeiraParteDoEmail = getTrechoAntesDoArroba(email);
			emailEhValido = primeiraParteDoEmail.matches(CHARS_VALIDOS_EMAIL);
		}
		return emailEhValido;
	}

	public static boolean salarioEhValido(final double salario) {
		return salario >= 0;
	}
	
	public static boolean cargoEhValido(final Cargo cargo) {
		return cargo != null;
	}
}
