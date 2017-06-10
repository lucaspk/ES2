package exceptions;

public class NomeInvalidoException extends DadosDoFuncionarioInvalidosException {

	public NomeInvalidoException() {
		super("O nome só pode conter letras e espaços.");
	}
	
	public NomeInvalidoException(final String message) {
		super(message);
	}	
}
