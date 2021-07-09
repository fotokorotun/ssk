package cliente;

import java.util.Date;

public class Tarjeta {

	int id;
	int numero;
    Date fechaDecaducidad;
	public String banco;
	public String debitoOcredito;
	int CVV;
	public String masterOvisa;
	
	public Tarjeta() {}
	
	public Tarjeta(int numero, Date fechaDecaducidad, String banco, String debitoOcredito, int cVV,
			String masterOvisa) {
		super();
		this.numero = numero;
		this.fechaDecaducidad = fechaDecaducidad;
		this.banco = banco;
		this.debitoOcredito = debitoOcredito;
		CVV = cVV;
		this.masterOvisa = masterOvisa;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
	public Date getFechaDecaducidad() {
		return fechaDecaducidad;
	}

	public void setFechaDecaducidad(Date fechaDecaducidad) {
		this.fechaDecaducidad = fechaDecaducidad;
	}

	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getDebitoOcredito() {
		return debitoOcredito;
	}
	public void setDebitoOcredito(String debitoOcredito) {
		this.debitoOcredito = debitoOcredito;
	}
	public int getCVV() {
		return CVV;
	}
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	public String getMasterOvisa() {
		return masterOvisa;
	}
	public void setMasterOvisa(String masterOvisa) {
		this.masterOvisa = masterOvisa;
	}
	@Override
	public String toString() {
		return "Tarjeta [numero=" + numero + ", fechaDecaducidad=" + fechaDecaducidad + ", banco=" + banco
				+ ", debitoOcredito=" + debitoOcredito + ", CVV=" + CVV + ", masterOvisa=" + masterOvisa + "]";
	}
	
	
	
	}


