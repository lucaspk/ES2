package exceptions;

public class DadosDoFuncionarioInvalidosException extends Exception{
	
	public DadosDoFuncionarioInvalidosException() {
		super("Os dados do usuário estão inválidos.");
	}
	
	public DadosDoFuncionarioInvalidosException(final String message) {
		super(message);
	}		
}
