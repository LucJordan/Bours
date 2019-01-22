package tools;

import java.sql.*;

import java.lang.reflect.*;

public class Function_date {
    public Function_date(){}

    public boolean ischiffre(String x){
        boolean b = false;
        String[] c = new String[10];
        c[0] = "0";
        c[1] = "1";
        c[2] = "2";
        c[3] = "3";
        c[4] = "4";
        c[5] = "5";
        c[6] = "6";
        c[7] = "7";
        c[8] = "8";
        c[9] = "9";
        for(int i=0; i<c.length; i++){
            if(x.compareTo(c[i])==0){
                b = true;
            }
        }
        return b;
    }
    public boolean checkdate(String date) throws Exception {
        int nb = 0;
        for(int i=0; i<date.length(); i++){
            if(!ischiffre(date.substring(i, i+1))){
                nb++;
            }
        }
        int nan = 2,t=10;
        if(nb==nan && date.length()==t){
            return true;
        }
        if(nb!=nan || date.length()!=t)
            // throw new Exception("la date que vous avez entre -->"+date+"<-- est invalide");
            throw new InvocationTargetException(new Throwable() ,"la date que vous avez entre -->"+date+"<-- est invalide");            
            // new InvocationTargetException(target, s)
        return false;
    }
    public int indexofNotchiffre(String date) throws Exception {
        checkdate(date);
        for(int i=0; i<date.length(); i++){
            if(!ischiffre(date.substring(i, i+1))){
                return i;
            }
        }
        return -1;
    }
    public int lastindexofNotchiffre(String date) throws Exception {
        checkdate(date);
        for(int i=date.length()-1; i>=0; i--){
            if(!ischiffre(date.substring(i, i+1))){
                return i;
            }
        }
        return -1;
    }
    public String getFormat(String date) throws Exception {
        checkdate(date);
        int a=2, b=5, c=4, d=7;
        if(indexofNotchiffre(date) ==a && lastindexofNotchiffre(date)==b){
            return "DD-MM-YYYY";
        }
        if(indexofNotchiffre(date) ==c && lastindexofNotchiffre(date)==d){
            return "YYYY-MM-DD";
        }
        return "format inconnu";
    }
    public String datetoYYYY_MM_DD(String date) throws Exception {
        checkdate(date);
        if(getFormat(date).compareTo("YYYY-MM-DD")==0){
            return date.substring(0, 4)+"-"+date.substring(5, 7)+"-"+date.substring(8);
        }
        if(getFormat(date).compareTo("DD-MM-YYYY")==0){
            return date.substring(6)+"-"+date.substring(3, 5)+"-"+date.substring(0, 2);
        }
        return "impossible de formater";
    }
    public String datetoDD_MM_YYYY(String date) throws Exception {
        checkdate(date);
        if(getFormat(date).compareTo("DD-MM-YYYY")==0){
            return date.substring(0, 2)+"-"+date.substring(3, 5)+"-"+date.substring(6);
        }
        if(getFormat(date).compareTo("YYYY-MM-DD")==0){
            return date.substring(8)+"-"+date.substring(5, 7)+"-"+date.substring(0, 4);
        }
        return "impossible de formater";
    }
    public Date stringtodate(String date) throws Exception {
        checkdate(date);
        Date valiny = null;
        try {
            valiny = Date.valueOf(datetoYYYY_MM_DD(date));
        } catch (IllegalArgumentException e) {
            throw new Exception("la date que vous avez entre -->"+date+"<-- est invalide");
        }
        return valiny;
    }
    public String aff(Date date) throws Exception {
        if(date==null){
            throw new Exception("la date est invalide");
        }
        return datetoDD_MM_YYYY(date.toString());
    }

    public String affmoisYYYY(String date)throws Exception{
        return affmoisYYYY(stringtodate(date));
    }
    public String affmoisYYYY(Date date){
        
        String[] tab = new String[12];
        tab[0] = "Janvier";
        tab[1] = "Fevrier";
        tab[2] = "Mars";
        tab[3] = "Avril";
        tab[4] = "Mai";
        tab[5] = "Juin";
        tab[6] = "Juillet";
        tab[7] = "Aout";
        tab[8] = "Septembre";
        tab[9] = "Octobre";
        tab[10] = "Novembre";
        tab[11] = "Decembre";

        return ""+tab[date.getMonth()]+" "+(date.getYear()+1900);
    }
    public int getdiffinDD(Date date0, Date date1){
        int nb = 0;
        if(date0.before(date1)){
            Date d0 = date0, d1 = date1;
            while(d0.before(d1)){
                d0.setDate(d0.getDate()+1);
                nb++;
            }
            for(int i=0; i<nb; i++){
                d0.setDate(d0.getDate()-1);
            }
        }
        else{
            Date d0 = date0, d1 = date1;
            while(d1.before(d0)){
                d1.setDate(d1.getDate()+1);
                nb++;
            }
            for(int i=0; i<nb; i++){
                d1.setDate(d1.getDate()-1);
            }
        }
        return nb;
    }
}