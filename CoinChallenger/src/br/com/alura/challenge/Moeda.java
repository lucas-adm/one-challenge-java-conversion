package br.com.alura.challenge;

public class Moeda {

	// COTAÇÃO DO DIA 07/07/2023 15:59pm
	private double dolar = 4.85;
	private double euro = 5.32;
	private double libraEsterlinas = 6.23;
	private double pesoArgentino = 0.019;
	private double pesoChileno = 0.0060;

	public double getDolar() {
		return dolar;
	}

	public void setDolar(double dolar) {
		this.dolar = dolar;
	}

	public double getEuro() {
		return euro;
	}

	public void setEuro(double euro) {
		this.euro = euro;
	}

	public double getLibraEsterlinas() {
		return libraEsterlinas;
	}

	public void setLibraEsterlinas(double libraEsterlinas) {
		this.libraEsterlinas = libraEsterlinas;
	}

	public double getPesoArgentino() {
		return pesoArgentino;
	}

	public void setPesoArgentino(double pesoArgentino) {
		this.pesoArgentino = pesoArgentino;
	}

	public double getPesoChileno() {
		return pesoChileno;
	}

	public void setPesoChileno(double pesoChileno) {
		this.pesoChileno = pesoChileno;
	}

}
