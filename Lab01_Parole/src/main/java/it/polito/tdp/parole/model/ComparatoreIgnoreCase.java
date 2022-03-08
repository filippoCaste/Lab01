package it.polito.tdp.parole.model;

import java.util.Comparator;

public class ComparatoreIgnoreCase implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if(o1.compareToIgnoreCase(o2)==0)
			return 0;
		else if(o1.compareToIgnoreCase(o2)>0)
			return 1;
		else
			return -1;
	}

}
