package tools;

import java.lang.reflect.Field;

public class Mapping{

    public String getConstructor(Object o){
		String res = "";
		Class c = o.getClass();
		Field[] f = c.getDeclaredFields();
		String[] pack_class = c.getName().split("\\.");
		String nom = pack_class[1];
		res += "<p>public "+nom+" () {}</p>";
		res += "<p>public "+nom+" (";
		for(int i=0; i<f.length; i++){
			Class c1 = f[i].getType();
			String type = getType(c1);
			res += " "+type+" "+f[i].getName();
			if(i<f.length-1){
				res += ", ";
			}
		}
		res += ") {</p>";
		for(int i=0; i<f.length; i++){
			res += "<p>"+getSetAppel(f[i])+"</p>";
		}
		res += "<p>}</p>";

		//afficheur
		res += "<p>public String aff() {</p>";
		res += "<p>String res =\"\" ; </p>";
		for(int i=0; i<f.length; i++){
			res += "<p> res += "+getGetAppel(f[i])+"</p>";
		}
		res += "<p>return res;</p>";
		res += "<p>}</p>";

		res += "<p>public String affS(Object[] liste) {</p>";
		res += "<p>if(liste.length&lt=0){</p>";
		res += "<p>return  \"aucun "+nom+"\";</p>";
		res += "<p>}</p>";
		res += "<p>String res =\"Tableau de "+nom+"\" ; </p>";
		res += "<p>res +=\"&lttable class=\\\"table table-bordered\\\"&gt\" ; </p>";
		res += "<p>res +=\"&lttr>\" ; </p>";
		for(int i=0; i<f.length; i++){
			res += "<p> res +=\" &ltth&gt"+f[i].getName()+"&lt/th&gt\";</p>";
		}
		res += "<p>res +=\"&lt/tr&gt\" ; </p>";

		res += "<p>for(int i=0; i&ltliste.length; i++){</p>";
		res += "<p>"+nom+" x = ("+nom+")liste[i];</p>";
		res += "<p>res +=\"&lttr>\" ; </p>";
		for(int i=0; i<f.length; i++){
			res += "<p> res += \"&lttd&gt\"+x."+getgeteur(f[i])+"+\"&lt/td&gt\";</p>";
		}
		res += "<p>res +=\"&lt/tr>\" ; </p>";
		res += "<p>}</p>";

		res += "<p>res +=\"&lt/table&gt\" ; </p>";
		res += "<p>return res;</p>";
		res += "<p>}</p>";
		return res;
    }
    
    public String getType(Class c) {
		String res = "";
		String className = c.getName();
		
		if(c.isArray()) {
			while(className.indexOf("[") > -1) {
				className = className.substring(className.indexOf("[")+1);
				res += "[]";
			}
			res = getT(className) + res; 
		}
		else {
			int p = c.getName().lastIndexOf(".");
			res = c.getName().substring(p+1);
		}
		
		return res;
    }
    public String getSetAppel(Field f) {
		String res = "";
		String name = f.getName();
		String att = name.substring(0,1).toUpperCase() + name.substring(1);
		
		res += "<p>set"+att+"(" + name + ") ;</p>";
		
		return res;
	}
	public String getgeteur(Field f){
		String res = "";
		String name = f.getName();
		String att = name.substring(0,1).toUpperCase() + name.substring(1);
		return "get"+att+"()";
	}
	public String getGetAppel(Field f) {
		String res = "";
		String name = f.getName();
		String att = name.substring(0,1).toUpperCase() + name.substring(1);
		
		res += "\" "+ att + ": \"+get"+att+"()+ \" ---\" ;";
		
		return res;
	}

    
	public String getT(String s) {
		String[] types = {"int","double","float","long","char"};
		String[] t = {"I","D","F","J","C"};
		
		for(int i=0; i < t.length; i++) {
			if(s.compareTo(t[i]) == 0) {
				return types[i];
			}
		}
		
		String type = s.substring(s.lastIndexOf(".")+1,s.length()-1);
		
		return type;
    }
    
    public String getGetString(Field f) {
		String res = "";
		String name = f.getName();
		String att = name.substring(0,1).toUpperCase() + name.substring(1);
		Class c = f.getType();
		String type = getType(c);
		
		res += "<p>public " + type + " get"+att+"() { </p>";
		res += "<p>return this."+ name +";</p>";
		res += "<p> } </p>";
		
		return res;
	}
	public String getSetString(Field f) {
		String res = "";
		String name = f.getName();
		String att = name.substring(0,1).toUpperCase() + name.substring(1);
		Class c = f.getType();
		String type = getType(c);
		
		res += "<p>public void set"+att+"("+ type + " " + name + ") { </p>";
		res += "<p>this."+ name + " = " + name + ";</p>";
		res += "<p> } </p>";

		if(type.compareTo("int")==0){
			res += "<p>public void set"+att+"( String " + name + ") { </p>";
			res += "<p>set"+att+"((new Integer(" + name + ")).intValue());</p>";
			res += "<p> } </p>";
		}
		if(type.compareTo("float")==0){
			res += "<p>public void set"+att+"( String " + name + ") { </p>";
			res += "<p>set"+att+"((new Integer(" + name + ")).floatValue());</p>";
			res += "<p> } </p>";
		}
		if(type.compareTo("Date")==0){
			res += "<p>public void set"+att+"( String " + name + ") throws Exception { </p>";
			res += "<p>set"+att+"( (new Function_date()).stringtodate(" + name + ") );</p>";
			res += "<p> } </p>";
		}
		return res;
	}
    
    public String createAllInClass(Object o) throws Exception {
		Class c = o.getClass();
		Field[] f = c.getDeclaredFields();
		String res = "";
		res += getConstructor(o);
		for(int i=0; i < f.length; i++) {
			res += getGetString(f[i]);
			res += getSetString(f[i]);
		}
		
		return res;
	}
}