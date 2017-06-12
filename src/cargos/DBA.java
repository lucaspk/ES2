package cargos;

import exceptions.SalarioInvalidoException;

public class DBA extends Cargo {

	private final static double MIN_PORC_DESC_DBA = 0.15;
	private final static double MAX_PORC_DESC_DBA = 0.25;
	private final static double SALARIO_BASE_DBA = 2000.0;
	
	public DBA() {
		super();
		setSalarioBase(SALARIO_BASE_DBA);
		setSalarioLiquido(SALARIO_BASE_DBA);
		setMinimaPorcentagemDesconto(MIN_PORC_DESC_DBA);
		setMaximaPorcentagemDesconto(MAX_PORC_DESC_DBA);
	}

	public DBA(final double salario) throws SalarioInvalidoException {
		super(salario);
		setSalarioBase(SALARIO_BASE_DBA);
		setMinimaPorcentagemDesconto(MIN_PORC_DESC_DBA);
		setMaximaPorcentagemDesconto(MAX_PORC_DESC_DBA);
	}

	@Override
	public double calcularPorcentagemDesconto() {
		setDesconto(MIN_PORC_DESC_DBA);
		if (getSalarioLiquido() >= getSalarioBase()) {
			setDesconto(MAX_PORC_DESC_DBA);
		}
		return getDesconto();
	}

	@Override
	public double calcularSalario() {
		return getSalarioLiquido() - calcularPorcentagemDesconto()*getSalarioLiquido();
	}

}
