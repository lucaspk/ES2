package exceptions;

public class CargoInvalidoException extends DadosDoFuncionarioInvalidosException{
	
	public CargoInvalidoException() {
		super("O cargo é inválido.");
	}
	
	public CargoInvalidoException(final String message) {
		super(message);
	}		
}
