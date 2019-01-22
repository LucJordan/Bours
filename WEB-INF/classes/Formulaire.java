package tools;

import java.lang.reflect.*;
import java.sql.Connection;

public class Formulaire{
	
	public Formulaire() {}

	Champ[] liste_c;
	
	/* --- */
	int countField(Class c){
		Field[] f = c.getDeclaredFields();
		return f.length;
	}
	
	public int countFieldTotal(Object o) {
		Class c = o.getClass();
		Object obj = new Object();
		int nb = 0;
		while(c != obj.getClass()){
			nb = nb + countField(c);
			c = c.getSuperclass();
		}
		return nb;
	}
	/* --- */
	Field[] joinTab(Field[] a, Field[] b){
		Field[] valiny = new Field[b.length+a.length];
		int x=0;
		for(int i=0; i<a.length; i++){
			valiny[x] = a[i];
			x++;
		}
		for(int i=0; i<b.length; i++){
			valiny[x] = b[i];
			x++;
		}
		return valiny;
	}
	
	public Field[] getAllField(Object o){
		Class c = o.getClass();
		Field[] valiny = c.getDeclaredFields();
		c = c.getSuperclass();
		Object oo = new Object();
		while(c != oo.getClass()){
			valiny = joinTab(valiny,c.getDeclaredFields());
			c = c.getSuperclass();
		}
		return valiny;
	}
	public void init(Object o){
		Field[] ls = getAllField(o);
		Champ[] champs = new Champ[ls.length];
		for(int i=0; i<ls.length; i++){
			champs[i] = new Champ(ls[i].getName());
		}
		liste_c = champs;
	}
	public String getHTML(Object o,Connection con)throws Exception{
		
		String valiny = "<center>";
		valiny += "<p>Formulaire d'insertion "+o.getClass().getName().substring(o.getClass().getName().indexOf(".")+1)+"</p>";
		valiny += "<table>";
		valiny += "<form action=\"FormListener.jsp\" method=\"POST\">";
		for(int i=0; i<liste_c.length; i++){
			if(liste_c[i].getDeroulante()==false && liste_c[i].getBox()==false){
				valiny += "<tr><td><p><label "+liste_c[i].getApparence()+" for=\""+liste_c[i].getName()+"\"> "+liste_c[i].getlibele()+"</label></td>";
				valiny += "<td><input "+liste_c[i].getApparence()+" type=\"text\" name=\""+liste_c[i].getName()+"\" value=\""+liste_c[i].getDefault()+"\" ></p></td></tr>";
			}
			else if(liste_c[i].getDeroulante()){
				valiny += liste_c[i].getListederoul(con);
			}
			else{
				valiny += liste_c[i].getCombobox(con);
			}
		}
			valiny += "<input hidden name=\"class\" type=\"text\" value=\""+NameString(o.getClass().getName())+"\"";
		valiny += "<tr><td></td><td><input type=\"submit\" value=\"Ok\"></form></td></tr>";
		valiny += "</table>";
		valiny += "------------o------------";
		valiny += "</center>";
		return valiny;
	}
	public String getHTMLupdate(Object o,Connection con)throws Exception{
		
		String valiny = "<center>";
		valiny += "<p>Formulaire d'update "+o.getClass().getName().substring(o.getClass().getName().indexOf(".")+1)+"</p>";
		valiny += "<table>";
		valiny += "<form action=\"FormListener.jsp\" method=\"POST\">";
		valiny += "<tr><td><label for=\"colone\">colonne de repere</label></td>";
		valiny += "<td><input type=\"text\" name=\"colone\" ></td></tr>";
		valiny += "<tr><td><label for=\"valeur_colonne\">valeur</label></td>";
		valiny += "<td><input type=\"text\" name=\"valeur_colonne\" ></td></tr>";
		
		for(int i=0; i<liste_c.length; i++){
			if(liste_c[i].getDeroulante()==false && liste_c[i].getBox()==false){
				valiny += "<tr><td><p><label "+liste_c[i].getApparence()+" for=\""+liste_c[i].getName()+"\"> "+liste_c[i].getlibele()+"</label></td>";
				valiny += "<td><input "+liste_c[i].getApparence()+" type=\"text\" name=\""+liste_c[i].getName()+"\" value=\""+liste_c[i].getDefault()+"\" ></p></td></tr>";
			}
			else if(liste_c[i].getDeroulante()){
				valiny += liste_c[i].getListederoul(con);
			}
			else{
				valiny += liste_c[i].getCombobox(con);
			}
		}
			valiny += "<input hidden name=\"class\" type=\"text\" value=\""+NameString(o.getClass().getName())+"\"";
		valiny += "<tr><td></td><td><input type=\"submit\" value=\"Ok\"></form></td></tr>";
		valiny += "</table>";
		valiny += "------------o------------";
		valiny += "</center>";
		return valiny;
	}

	public Champ getChamp(String name){
		Champ val = new Champ();
		for(int i=0; i<liste_c.length; i++){
			if(name.compareTo(liste_c[i].getName()) == 0){
				val = liste_c[i];
			}
		}
		return val;
	}
	public String NameString(String packAndClass){
		int nb = packAndClass.lastIndexOf(".");
		if(nb>0){
			packAndClass = packAndClass.substring(nb+1);
		}
		return packAndClass;
	}
	public String[] getFieldString(Object o){
		Field[] ls = getAllField(o);
		String[] val = new String[ls.length];
		for(int i=0; i<ls.length; i++){
			val[i] = ls[i].getName();
		}
		return val;
	}
}