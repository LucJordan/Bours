package tools;

import java.sql.*;
import function_gen.Function_gen;
import java.lang.reflect.*;

public class Cible{

    public Cible(){}

    public void action(String nc,Object myClass,Connection con,String[] values) throws Exception {
        Formulaire fu = new Formulaire();
        // Function fun = new Function();
        String[] lesChamps = fu.getFieldString(myClass);
        Class c = Class.forName("donnee."+nc);
        for(int i=0; i< values.length; i++){
            String nf = "set"+lesChamps[i].substring(0,1).toUpperCase()+lesChamps[i].substring(1);
            if(values[i]!=null){
                try{
                    Method meth = c.getMethod(nf,String.class);
                    meth.invoke(myClass,values[i]);
                }catch(java.lang.NoSuchMethodException e){
                    Class[] lclass = new Class[2];
                    lclass[0] = String.class;
                    lclass[1] = Connection.class;
                    Method meth = c.getMethod(nf,lclass);
                    Object[] objs = new Object[2];
                    objs[0] = values[i];
                    objs[1] = con;
                    meth.invoke(myClass,objs);
                    // throw e;
                }
            }
          }
        (new Function_gen()).insert(con,myClass,nc);
        // (new Function_gen()).update(con,myClass,nc);
    }
    public void actionup(String nc,Object myClass,Connection con,String[] values,String colone,String valeur_colonne) throws Exception {
        Formulaire fu = new Formulaire();
        // Function fun = new Function();
        String[] lesChamps = fu.getFieldString(myClass);
        Class c = Class.forName("donnee."+nc);
        for(int i=0; i< values.length; i++){
            String nf = "set"+lesChamps[i].substring(0,1).toUpperCase()+lesChamps[i].substring(1);
            if(values[i]!=null){
                try{
                    Method meth = c.getMethod(nf,String.class);
                    meth.invoke(myClass,values[i]);
                }catch(java.lang.NoSuchMethodException e){
                    Class[] lclass = new Class[2];
                    lclass[0] = String.class;
                    lclass[1] = Connection.class;
                    Method meth = c.getMethod(nf,lclass);
                    Object[] objs = new Object[2];
                    objs[0] = values[i];
                    objs[1] = con;
                    meth.invoke(myClass,objs);
                    // throw e;
                }
            }
          }
        //(new Function_gen()).insert(con,myClass,nc);
        (new Function_gen()).update(con,myClass,nc,colone,valeur_colonne);
    }
}