package tools;
import donnee.*;
import function_gen.*;

import java.sql.*;
import java.util.Vector;

import connexion.*;
import java.lang.reflect.*;

import java.lang.reflect.Field;

public class Function{
    public String getLien(String x){
        return "<p><a href=\"liste_"+x+".jsp\">liste des "+x+"s</a></p>";    
    }
    public String boutongoback(){
		String html = "";
		html+= "<p><button onclick=\"goBack()\">Go Back</button>";

		html+= "<script>";
		html+= "function goBack() {";
		html+= "window.history.back();";
		html+= "}";
		html+= "</script> </p>";
		return html;
	}
    public String getLien(){
        String txt = "";
        txt += "<p><a href=\"index.jsp\">Accueil</a></p>";
		txt += "<p><a href=\"map.jsp\">Map</a></p>";
		txt += "<p><a href=\"liste.jsp\">Liste</a></p>";
        txt += getLien("formulaire");
        return txt;
    }
	public String lister() throws Exception {
		Connection con = (new DBConnection()).getConnnection();
		String txt = "";
		
		txt += (new Client()).affS((new Function_gen()).select(con,"Client"));
		txt += (new Brocker()).affS((new Function_gen()).select(con,"Brocker"));
		txt += (new Brocker()).affS((new Function_gen()).select(con,"Societe"));
		
		con.close();
		return txt;
	}
	public String maper() throws Exception {
		Connection con = (new DBConnection()).getConnnection();
		Societe o = new Societe();
		String map = (new Mapping()).createAllInClass(o);
		con.close();
		return map;
	}
	public String formuler() throws Exception {
		Connection con = (new DBConnection()).getConnnection();
		String html = "";

		Formulaire f_Client = new Formulaire();
		f_Client.init(new Client());
		html += f_Client.getHTML(new Client(),con);

		Formulaire f_Brocker = new Formulaire();
		f_Brocker.init(new Brocker());
		html += f_Brocker.getHTML(new Brocker(),con);

		Formulaire f_Societe = new Formulaire();
		f_Societe.init(new Societe());
		html += f_Societe.getHTML(new Societe(),con);

		con.close();
		
		return html;
	}
}