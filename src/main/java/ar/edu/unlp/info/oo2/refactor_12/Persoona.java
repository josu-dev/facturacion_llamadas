package ar.edu.unlp.info.oo2.refactor_12;

import java.util.ArrayList;
import java.util.List;

public class Persoona {
	private List<Llamada> lista1 = new ArrayList<Llamada>();
	private String t;
	private String nya;
	private String tel;
	private String cuit;
	private String doc;
	private Persoonal sis;

	public List<Llamada> getLista1() {
		return lista1;
	}
	public void setLista1(List<Llamada> lista1) {
		this.lista1 = lista1;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getNya() {
		return nya;
	}
	public void setNya(String nya) {
		this.nya = nya;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public Persoonal getSis() {
		return sis;
	}
	public void setSis(Persoonal sis) {
		this.sis = sis;
	}
}
