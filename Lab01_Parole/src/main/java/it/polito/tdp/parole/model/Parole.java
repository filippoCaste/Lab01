package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	private List <String> elenco;
		
	public Parole() {
		elenco = new ArrayList <String> ();
	}
	
	public void addParola(String p) {
		elenco.add(p);
	}
	
	public List<String> getElenco() {
		List <String> res = new LinkedList <String> (elenco); 
		Collections.sort(res, new ComparatoreIgnoreCase());
		return res;
	}
	
	public void reset() {
		elenco.removeAll(elenco);
	}
	
	public boolean removeParola(String s) {
		boolean res = elenco.remove(s);
		return res;
	}

}
