package tema5.pruebas;

import java.util.Objects;

public class Fraccion {
	private int numerador;
	private int denominador;
	
	public Fraccion(int numerador, int denominador) throws ArithmeticException {
		super();
		this.numerador = numerador;
		this.denominador = denominador;
		if (this.denominador == 0) {
			throw new ArithmeticException();
		}
	}
	
	public Fraccion() {
		super();
		this.numerador = 1;
		this.denominador = 1;
	}
	
	public Fraccion(Fraccion f) {
		super();
		this.numerador = f.numerador;
		this.denominador = f.denominador;
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) throws ArithmeticException {
		this.denominador = denominador;
		if (this.denominador == 0) {
			throw new ArithmeticException();
		}
	}

	@Override
	public String toString() {
		return numerador + "/" + denominador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(denominador, numerador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraccion other = (Fraccion) obj;
		return denominador == other.denominador && numerador == other.numerador;
	}
	
	public void sumar(Fraccion f) {
		this.numerador = this.numerador * f.denominador + f.numerador * this.denominador;
		this.denominador = this.denominador * f.denominador;
		this.simplificar();
	}
	
	public void restar(Fraccion f) {
		this.numerador = this.numerador * f.denominador - f.numerador * this.denominador;
		this.denominador = this.denominador * f.denominador;
		this.simplificar();
	}

	public void multiplicar(Fraccion f) {
		this.numerador = this.numerador * f.numerador;
		this.denominador = this.denominador * f.denominador;
		this.simplificar();
	}

	public void dividir(Fraccion f) {
		this.numerador = this.numerador * f.denominador;
		this.denominador = this.denominador * f.numerador;
		this.simplificar();
	}

	public void simplificar() {
		int i = this.denominador; 
		while (i >= 2) {
			if (this.numerador % i == 0 && this.denominador % i == 0) {
				this.numerador = this.numerador / i;
				this.denominador = this.denominador / i;
			} else {
				i--;
			}
		}
	}
	
}
