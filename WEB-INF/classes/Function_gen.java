package function_gen;
// import donnee.*;
import java.sql.*;
import java.util.Vector;
import tools.*;
import connexion.*;
import java.lang.reflect.*;

import java.lang.reflect.Field;

public class Function_gen{
    
	public Function_gen(){}
	
	public double getSomme(Object[] lo, String attribut)throws Exception{
		double total = 0;
		for(int i=0; i<lo.length; i++){
			Class c = lo[i].getClass();
			String nf = "get"+attribut;
			
			Method meth = c.getMethod(nf);
			total = total + (double)(meth.invoke(lo[i]));
		}
		return total;
	}

    public Class[] getTypeField(Class c){
		Field[] f = c.getDeclaredFields();
		Class[] types = new Class[f.length];
		for(int i=0; i<f.length; i++){
			types[i] = f[i].getType();
		}
		return types;
    }
    public String NameString(String packAndClass){
		int nb = packAndClass.lastIndexOf(".");
		if(nb>0){
			packAndClass = packAndClass.substring(nb+1);
		}
		return packAndClass;
    }
    public Object[] addObj(Object[] tab, Object obj) {
		int n = tab.length;
		Object[] res = new Object[n+1];
		int i = 0;
		
		while(i < n) {
			res[i] = tab[i];
			i++;
		}
		res[n] = obj;
		
		return res;
	}
    public Object selectbyId(Connection con ,String nt,String col,String val)throws Exception{
		Object[] objs = selectnotlike(con ,nt,col,val);
		Object obj = new Object();
		obj = null;
		if(objs.length>0){
			obj = objs[0];
		}
		return obj;
	}
    public Object[] select(Connection con ,String nt)throws Exception{
        return select(con, nt, "", "");
    }
    public Object[] select(Connection con ,String nt,String col,String val)throws Exception{
        String sql = "SELECT * FROM "+nt;
        if(col.compareTo("")!=0 && val.compareTo("")!=0){
            sql+=" WHERE "+col+" LIKE '%"+val+"%'";
		}
		ResultSet rs = con.createStatement().executeQuery(sql);
		// System.out.println(sql);
		nt = "donnee."+nt;
		Class c = Class.forName(nt);
		Object[] valiny = new Object[0];
		int nbCol = rs.getMetaData().getColumnCount();
		Class[] types = getTypeField(c);
		Constructor constr = c.getConstructor(types);
		while(rs.next()){
			// System.out.println("\n ");
			Object[] lesValAtt = new Object[nbCol];
			for(int i=0; i<nbCol; i++){
				String withGet = NameString(types[i].getName());
				if(withGet.equals("int")){
					lesValAtt[i]=rs.getInt(i+1);
				}
				if(withGet.equals("String")){
					lesValAtt[i]=rs.getString(i+1);
				}
				if(withGet.equals("double")){
					lesValAtt[i]=rs.getDouble(i+1);
				}
				if(withGet.equals("float")){
					lesValAtt[i]=rs.getFloat(i+1);
				}
				if(withGet.equals("Date")){
					lesValAtt[i]=rs.getDate(i+1);
				}
				//System.out.println("valeur "+lesValAtt[i]);
			}
			//System.out.println("taille"+lesValAtt.length);
			Object o = constr.newInstance(lesValAtt);
			valiny = addObj(valiny,o);
		}
		rs.close();
		return valiny;
	}
	public Object[] selectnotlike(Connection con ,String nt,String col,String val)throws Exception{
        String sql = "SELECT * FROM "+nt;
        if(col.compareTo("")!=0 && val.compareTo("")!=0){
            sql+=" WHERE "+col+" = '"+val+"'";
		}
		ResultSet rs = con.createStatement().executeQuery(sql);
		// System.out.println(sql);
		nt = "donnee."+nt;
		Class c = Class.forName(nt);
		Object[] valiny = new Object[0];
		int nbCol = rs.getMetaData().getColumnCount();
		Class[] types = getTypeField(c);
		Constructor constr = c.getConstructor(types);
		while(rs.next()){
			// System.out.println("\n ");
			Object[] lesValAtt = new Object[nbCol];
			for(int i=0; i<nbCol; i++){
				String withGet = NameString(types[i].getName());
				if(withGet.equals("int")){
					lesValAtt[i]=rs.getInt(i+1);
				}
				if(withGet.equals("String")){
					lesValAtt[i]=rs.getString(i+1);
				}
				if(withGet.equals("double")){
					lesValAtt[i]=rs.getDouble(i+1);
				}
				if(withGet.equals("float")){
					lesValAtt[i]=rs.getFloat(i+1);
				}
				if(withGet.equals("Date")){
					lesValAtt[i]=rs.getDate(i+1);
				}
				//System.out.println("valeur "+lesValAtt[i]);
			}
			//System.out.println("taille"+lesValAtt.length);
			Object o = constr.newInstance(lesValAtt);
			valiny = addObj(valiny,o);
		}
		rs.close();
		return valiny;
	}
	public Object[] select(Connection con ,String nt,String col,int val)throws Exception{
        String sql = "SELECT * FROM "+nt;
            sql+=" WHERE "+col+" = "+val;
		ResultSet rs = con.createStatement().executeQuery(sql);
		
		nt = "donnee."+nt;
		Class c = Class.forName(nt);
		Object[] valiny = new Object[0];
		int nbCol = rs.getMetaData().getColumnCount();
		Class[] types = getTypeField(c);
		Constructor constr = c.getConstructor(types);
		while(rs.next()){
			// System.out.println("\n ");
			Object[] lesValAtt = new Object[nbCol];
			for(int i=0; i<nbCol; i++){
				String withGet = NameString(types[i].getName());
				if(withGet.equals("int")){
					lesValAtt[i]=rs.getInt(i+1);
				}
				if(withGet.equals("String")){
					lesValAtt[i]=rs.getString(i+1);
				}
				if(withGet.equals("double")){
					lesValAtt[i]=rs.getDouble(i+1);
				}
				if(withGet.equals("float")){
					lesValAtt[i]=rs.getFloat(i+1);
				}
				if(withGet.equals("Date")){
					lesValAtt[i]=rs.getDate(i+1);
				}
				//System.out.println("valeur "+lesValAtt[i]);
			}
			//System.out.println("taille"+lesValAtt.length);
			Object o = constr.newInstance(lesValAtt);
			valiny = addObj(valiny,o);
		}
		rs.close();
		return valiny;
	}
	public Object[] select(Connection con ,String nt,String col,String val,String col0,String val0,String col1,String val1)throws Exception{
        String sql = "SELECT * FROM "+nt;
            sql+=" WHERE "+col+" = '"+val+"' AND "+col0+" = '"+val0+"' AND "+col1+" = '"+val1+"'";
		ResultSet rs = con.createStatement().executeQuery(sql);
		// System.out.println(sql);
		nt = "donnee."+nt;
		Class c = Class.forName(nt);
		Object[] valiny = new Object[0];
		int nbCol = rs.getMetaData().getColumnCount();
		Class[] types = getTypeField(c);
		Constructor constr = c.getConstructor(types);
		while(rs.next()){
			// System.out.println("\n ");
			Object[] lesValAtt = new Object[nbCol];
			for(int i=0; i<nbCol; i++){
				String withGet = NameString(types[i].getName());
				if(withGet.equals("int")){
					lesValAtt[i]=rs.getInt(i+1);
				}
				if(withGet.equals("String")){
					lesValAtt[i]=rs.getString(i+1);
				}
				if(withGet.equals("double")){
					lesValAtt[i]=rs.getDouble(i+1);
				}
				if(withGet.equals("float")){
					lesValAtt[i]=rs.getFloat(i+1);
				}
				if(withGet.equals("Date")){
					lesValAtt[i]=rs.getDate(i+1);
				}
				//System.out.println("valeur "+lesValAtt[i]);
			}
			//System.out.println("taille"+lesValAtt.length);
			Object o = constr.newInstance(lesValAtt);
			valiny = addObj(valiny,o);
		}
		rs.close();
		return valiny;
	}
	public Object[] select(Connection con ,String nt,String col,String val,String col0,String val0)throws Exception{
        String sql = "SELECT * FROM "+nt;
			sql+=" WHERE "+col+" = '"+val+"' AND "+col0+" = '"+val0+"' ";
		System.out.println(sql);
		ResultSet rs = con.createStatement().executeQuery(sql);
		nt = "donnee."+nt;
		Class c = Class.forName(nt);
		Object[] valiny = new Object[0];
		int nbCol = rs.getMetaData().getColumnCount();
		Class[] types = getTypeField(c);
		Constructor constr = c.getConstructor(types);
		while(rs.next()){
			// System.out.println("\n ");
			Object[] lesValAtt = new Object[nbCol];
			for(int i=0; i<nbCol; i++){
				String withGet = NameString(types[i].getName());
				if(withGet.equals("int")){
					lesValAtt[i]=rs.getInt(i+1);
				}
				if(withGet.equals("String")){
					lesValAtt[i]=rs.getString(i+1);
				}
				if(withGet.equals("double")){
					lesValAtt[i]=rs.getDouble(i+1);
				}
				if(withGet.equals("float")){
					lesValAtt[i]=rs.getFloat(i+1);
				}
				if(withGet.equals("Date")){
					lesValAtt[i]=rs.getDate(i+1);
				}
				//System.out.println("valeur "+lesValAtt[i]);
			}
			//System.out.println("taille"+lesValAtt.length);
			Object o = constr.newInstance(lesValAtt);
			valiny = addObj(valiny,o);
		}
		rs.close();
		return valiny;
	}
	public Object[] selectbefore(Connection con ,String nt,String id, String idval, String col,String val)throws Exception{
        String sql = "SELECT * FROM "+nt;
            sql+=" WHERE "+id+" = '"+idval+"' and "+col+" < '"+val+"' order by "+col+" desc";
		ResultSet rs = con.createStatement().executeQuery(sql);
		System.out.println(sql);
		nt = "donnee."+nt;
		Class c = Class.forName(nt);
		Object[] valiny = new Object[0];
		int nbCol = rs.getMetaData().getColumnCount();
		Class[] types = getTypeField(c);
		Constructor constr = c.getConstructor(types);
		while(rs.next()){
			// System.out.println("\n ");
			Object[] lesValAtt = new Object[nbCol];
			for(int i=0; i<nbCol; i++){
				String withGet = NameString(types[i].getName());
				if(withGet.equals("int")){
					lesValAtt[i]=rs.getInt(i+1);
				}
				if(withGet.equals("String")){
					lesValAtt[i]=rs.getString(i+1);
				}
				if(withGet.equals("double")){
					lesValAtt[i]=rs.getDouble(i+1);
				}
				if(withGet.equals("float")){
					lesValAtt[i]=rs.getFloat(i+1);
				}
				if(withGet.equals("Date")){
					lesValAtt[i]=rs.getDate(i+1);
				}
				//System.out.println("valeur "+lesValAtt[i]);
			}
			//System.out.println("taille"+lesValAtt.length);
			Object o = constr.newInstance(lesValAtt);
			valiny = addObj(valiny,o);
		}
		rs.close();
		return valiny;
	}
	public Object[] selectorder(Connection con ,String nt,String order,String asc_desc)throws Exception{
		return selectorder(con ,nt,"","",order,asc_desc);
	}
	public Object[] selectorder(Connection con ,String nt,String col,String val,String order,String asc_desc)throws Exception{
        String sql = "SELECT * FROM "+nt;
        if(col.compareTo("")!=0 && val.compareTo("")!=0){
            sql+=" WHERE "+col+" LIKE '%"+val+"%'";
		}
		if(order.compareTo("")!=0 && asc_desc.compareTo("")!=0){
            sql+=" order by "+order+" "+asc_desc;
		}
		ResultSet rs = con.createStatement().executeQuery(sql);
		System.out.println(sql);
		nt = "donnee."+nt;
		Class c = Class.forName(nt);
		Object[] valiny = new Object[0];
		int nbCol = rs.getMetaData().getColumnCount();
		Class[] types = getTypeField(c);
		Constructor constr = c.getConstructor(types);
		while(rs.next()){
			// System.out.println("\n ");
			Object[] lesValAtt = new Object[nbCol];
			for(int i=0; i<nbCol; i++){
				String withGet = NameString(types[i].getName());
				if(withGet.equals("int")){
					lesValAtt[i]=rs.getInt(i+1);
				}
				if(withGet.equals("String")){
					lesValAtt[i]=rs.getString(i+1);
				}
				if(withGet.equals("double")){
					lesValAtt[i]=rs.getDouble(i+1);
				}
				if(withGet.equals("float")){
					lesValAtt[i]=rs.getFloat(i+1);
				}
				if(withGet.equals("Date")){
					lesValAtt[i]=rs.getDate(i+1);
				}
				//System.out.println("valeur "+lesValAtt[i]);
			}
			//System.out.println("taille"+lesValAtt.length);
			Object o = constr.newInstance(lesValAtt);
			valiny = addObj(valiny,o);
		}
		rs.close();
		return valiny;
    }
    public String getTab(Class c){
		String val = c.getName();
		int i = val.lastIndexOf('.')+1;
		val = val.substring(i);
		return val;
    }
    public String getSqlInsert(Object obj,String nt)throws Exception{
		Class c = obj.getClass();
		String nomTab = getTab(c);
		if(nt!=""){
			nomTab = nt;
		}
		String sql = "insert into "+nomTab+" VALUES (";
		Field[] fs = c.getDeclaredFields();
		for(int i=0; i<fs.length; i++){
            if(fs[i].getName().indexOf("_nit")==-1){
                if(i!=0){
                    sql+=",";
                }
                String col = fs[i].getName();
                String nf = "get"+col.substring(0,1).toUpperCase() + col.substring(1);
                Method m = c.getMethod(nf);
                String val = m.invoke(obj).toString();
                if(fs[i].getType() == val.getClass()){
                    if(val.indexOf(".next")==-1){
                        val = "'"+val+"'";
                    }
				}
				if(fs[i].getType() == (new Date(1,1,1)).getClass()){
					val = val.substring(8)+val.substring(4, 7)+"-"+val.substring(0, 4);
					val = "'"+val+"'";
				}
				sql = sql+val;
            }
		}
		sql +=")";
		return sql;
	}
	public String getSqlUpdate(Object obj,String nt,String colone,String valeur_colonne)throws Exception{
		Class c = obj.getClass();
		String nomTab = getTab(c);
		if(nt!=""){
			nomTab = nt;
		}
		String sql = "update "+nomTab+" set ";
		Field[] fs = c.getDeclaredFields();
		for(int i=0; i<fs.length; i++){
            if(fs[i].getName().indexOf("_nit")==-1){
				if(i!=0){
                    sql+=", ";
                }
				String col = fs[i].getName();
                String nf = "get"+col.substring(0,1).toUpperCase() + col.substring(1);
                Method m = c.getMethod(nf);
                String val = m.invoke(obj).toString();
                if(fs[i].getType() == val.getClass()){
					val = col+"='"+val+"' ";					
				}else{
					val = col+"="+val+" ";					
				}
				sql = sql+val;
            }
		}
		String[] tab_colone = colone.split(",");
		String[] tab_valeur_colonne = valeur_colonne.split(",");
		if(tab_colone.length != tab_valeur_colonne.length){
			throw new Exception("error : le nombre de colonne de repere et de valeur differe");
		}
		for(int i=0; i<tab_colone.length; i++){
			if(i==0){
				sql += " where ";
			}
			sql += tab_colone[i]+" = '"+tab_valeur_colonne[i]+"' ";
			if(i!=tab_colone.length-1){
				sql += " and ";
			}
		}
		return sql;
    }
    public void insert(Connection con, Object o,String nt)throws Exception{
		String sql = getSqlInsert(o,nt);
		System.out.println(sql);
		ResultSet rs = con.createStatement().executeQuery(sql);
		con.commit();
		rs.close();
	}
	public void update(Connection con, Object o,String nt,String colone,String valeur_colonne)throws Exception{
		String sql = getSqlUpdate(o,nt,colone,valeur_colonne);
		System.out.println(sql);
		con.createStatement().executeUpdate(sql);
		con.commit();
	}
	
	public String enlettre(float nb){
		return enlettre(floatToInt(nb));
	}
	public String enlettre(int nb){
        if(nb==0){
            return " zero";
        }
        String val=" ";
        if(nb<0){
            nb=-nb;
            val="moins ";
        }
        String[] autre = new String[4];
        autre[0] = "cent";
        autre[1] = "mille";
        autre[2] = "million";
        autre[3] = "milliard";
        int x=0;
        while(nb>=1000000000){
            x=x+1;
            nb = nb-1000000000;
        }
        if(x!=0){val += centEnLettre(x)+" milliard ";}
        x=0;
        while(nb>=1000000){
            x=x+1;
            nb = nb-1000000;
        }
        if(x!=0){val += centEnLettre(x)+" million ";}
        x=0;
        while(nb>=1000){
            x=x+1;
            nb = nb-1000;
        }
        if(x!=0){val += centEnLettre(x)+" mille ";}
        if(nb!=0){val += centEnLettre(nb);}
        val=remplacer(val,"dix un","onze");
        val=remplacer(val,"dix deux","douze");
        val=remplacer(val,"dix trois","treize");
        val=remplacer(val,"dix quatre","quatorze");
        val=remplacer(val,"dix cinq","quinze");
        val=remplacer(val,"dix six","seize");
        val=remplacer(val,"un cent","cent");
        val=remplacer(val,"  un mille","mille");  
        return val;
    }
    public String centEnLettre(int nb){
        String[] unite = new String[10];
        unite[0] = "zero";
        unite[1] = "un";
        unite[2] = "deux";
        unite[3] = "trois";
        unite[4] = "quatre";
        unite[5] = "cinq";
        unite[6] = "six";
        unite[7] = "sept";
        unite[8] = "huit";
        unite[9] = "neuf";
        String[] dizaine = new String[9];
        dizaine[0] = "dix";
        dizaine[1] = "vingt";
        dizaine[2] = "trente";
        dizaine[3] = "quarante";
        dizaine[4] = "cinquante";
        dizaine[5] = "soixante";
        dizaine[6] = "soixante dix";
        dizaine[7] = "quatre vingt";
        dizaine[8] = "quatre vingt dix";
        String val = "";
        int x=0;
        while(nb>=100){
            x=x+1;
            nb=nb-100;
        }
        if(x!=0){val+=unite[x]+" cent ";}
        x=0;
        while(nb>=10){
            x=x+1;
            nb=nb-10;
        }  
        if(x!=0){val+=dizaine[x-1];} 
        if(nb!=0){val+=" "+unite[nb];}

        return val;
    }
    public String remplacer(String amodifier,String ancien,String nouv){
        int nb;
        nb=amodifier.indexOf(ancien);
        String val ;
        while(nb!=-1){
            val = "";
            val += amodifier.substring(0,nb);
            val += nouv;
            val += amodifier.substring(nb+ancien.length());
            amodifier = val;
            nb=amodifier.indexOf(ancien);            
        }
        return amodifier;
    }
    public int floatToInt(float f){
        String s = String.valueOf(f);
        String[] a = s.split("\\.");
        s= a[0];
        Integer itg = new Integer(s);
        return itg.intValue();
    }
}