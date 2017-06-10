package exceptions;

public class DadosDoFuncionarioInvalidosException extends Exception{
	
	public DadosDoFuncionarioInvalidosException() {
		super("Os dados do usu�rio est�o inv�lidos.");
	}
	
	public DadosDoFuncionarioInvalidosException(final String message) {
		super(message);
	}		
}
