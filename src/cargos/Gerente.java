package cargos;

import exceptions.SalarioInvalidoException;

public class Gerente extends Cargo {

	private static final double MAX_PORC_DESC_GERENTE = 0.5;
	private static final double MIN_PORC_DESC_GERENTE = 0.2;
	private static final double SALARIO_BASE_GERENTE = 5000.0;
	
	public Gerente(final double salario) throws SalarioInvalidoException {
		super(salario);
		setSalarioBase(SALARIO_BASE_GERENTE);
	}

	public Gerente(){
		super();
		setSalarioBase(SALARIO_BASE_GERENTE);
	}

	@Override
	public double calcularPorcentagemDesconto() {
		setDesconto(MIN_PORC_DESC_GERENTE);
		if (getSalarioLiquido() >= getSalarioBase()) {
			setDesconto(MAX_PORC_DESC_GERENTE);
		}
		return getDesconto();
	}

	@Override
	public double calcularSalario() {
		return getSalarioLiquido() - calcularPorcentagemDesconto()*getSalarioLiquido();
	}

}
