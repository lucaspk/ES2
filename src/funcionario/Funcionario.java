package funcionario;

import cargos.Cargo;
import exceptions.CargoInvalidoException;
import exceptions.DadosDoFuncionarioInvalidosException;
import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;
import exceptions.SalarioInvalidoException;
import util.Validador;

public class Funcionario {

	private String nome;
	private String email;
	private Cargo cargo;
	private double salarioLiquido;
	
	public Funcionario(final String nome, final String email, 
			final Cargo cargo, final double salarioLiquido) throws DadosDoFuncionarioInvalidosException{
		
		if (Validador.nomeEhValido(nome) == false) {
			throw new NomeInvalidoException();
		}
		if (Validador.emailEhValido(email) == false) {
			throw new EmailInvalidoException();
		}
		if (Validador.cargoEhValido(cargo) == false) {
			throw new CargoInvalidoException();
		}
		if (Validador.salarioEhValido(salarioLiquido) == false) {
			throw new SalarioInvalidoException();
		}
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
		this.salarioLiquido = salarioLiquido;
		this.cargo.setSalarioLiquido(salarioLiquido);
	}

	public double calcularSalario() {
		return this.cargo.calcularSalario();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String novoNome) {
		if (Validador.nomeEhValido(novoNome) == false) {
			try {
				throw new NomeInvalidoException();
			} catch (NomeInvalidoException e) {
				e.printStackTrace();
			}
		} else {
			this.nome = novoNome;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String novoEmail) {
		if (Validador.emailEhValido(novoEmail) == false) {
			try {
				throw new EmailInvalidoException();
			} catch (EmailInvalidoException e) {
				e.printStackTrace();
			}
		} else {
			this.email = novoEmail;
		}
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(final Cargo novoCargo) {
		if (Validador.cargoEhValido(novoCargo) == false) {
			try {
				throw new CargoInvalidoException();
			} catch (CargoInvalidoException e) {
				e.printStackTrace();
			}
		} else {
			this.cargo = novoCargo;
			this.setSalarioLiquido(novoCargo.getSalarioBase());
		}
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(final double novoSalarioLiquido) {
		if (Validador.salarioEhValido(novoSalarioLiquido) == false) {
			try {
				throw new SalarioInvalidoException();
			} catch (SalarioInvalidoException e) {
				e.printStackTrace();
			}
		} else {
			this.salarioLiquido = novoSalarioLiquido;
			this.cargo.setSalarioLiquido(novoSalarioLiquido);
		}
		
	}
	
	

}
