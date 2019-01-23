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
	public String getLien_session(String x){
		if(x.compareTo("client")==0){
			return getLienClient();
		}
		if(x.compareTo("brocker")==0){
			return getLienBrocker();
		}
		return getLien();
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
		txt += "<p><a href=\"deco.jsp\">deconnection</a></p>";
        return txt;
	}
	public String getLienClient(){
        String txt = "";
        txt += "<p><a href=\"index.jsp\">Accueil</a></p>";
		txt += "<p><a href=\"deco.jsp\">deconnection</a></p>";
        return txt;
	}
	public String getLienBrocker(){
        String txt = "";
        txt += "<p><a href=\"index.jsp\">Accueil</a></p>";
		txt += "<p><a href=\"deco.jsp\">deconnection</a></p>";
        return txt;
	}
	public String getLienLog(){
        String txt = "";
        txt += "<p><a href=\"login_client.jsp\">Se connecter en tant que client</a></p>";
		txt += "<p><a href=\"login_brocker.jsp\">Se connecter en tant que Brocker</a></p>";
		txt += "<p><a href=\"administrer.jsp\">Se connecter en tant que admin</a></p>";
        return txt;
    }
	public String lister() throws Exception {
		Connection con = (new DBConnection()).getConnnection();
		String txt = "";
		
		txt += (new Client()).affS((new Function_gen()).select(con,"Client"));
		txt += (new Brocker()).affS((new Function_gen()).select(con,"Brocker"));
		txt += (new Societe()).affS((new Function_gen()).select(con,"Societe"));
		txt += (new Titre()).affS((new Function_gen()).select(con,"Titre"));
		txt += (new Ordre()).affS((new Function_gen()).select(con,"Ordre"));
		txt += (new Titre_vendu()).affS((new Function_gen()).select(con,"Titre_vendu"));
		txt += (new Transaction()).affS((new Function_gen()).select(con,"Transaction"));
		
		con.close();
		return txt;
	}
	public String maper() throws Exception {
		Connection con = (new DBConnection()).getConnnection();
		Transaction o = new Transaction();
		String map = (new Mapping()).createAllInClass(o);
		con.close();
		return map;
	}
	public String formuler() throws Exception {
		Connection con = (new DBConnection()).getConnnection();
		String html = "";

		Formulaire f_Client = new Formulaire();
		f_Client.init(new Client());
		f_Client.getChamp("idClient").setDefault("concat('cl_',idClient.nextVal)");
		f_Client.getChamp("idClient").setVisible(false);
		html += f_Client.getHTML(new Client(),con);

		Formulaire f_Brocker = new Formulaire();
		f_Brocker.init(new Brocker());
		f_Brocker.getChamp("idBrocker").setDefault("concat('br_',idBrocker.nextVal)");
		f_Brocker.getChamp("idBrocker").setVisible(false);
		html += f_Brocker.getHTML(new Brocker(),con);

		Formulaire f_Societe = new Formulaire();
		f_Societe.init(new Societe());
		f_Societe.getChamp("idSociete").setDefault("concat('s_',idSociete.nextVal)");
		f_Societe.getChamp("idSociete").setVisible(false);
		f_Societe.getChamp("nbTitre").setLibele("nombre de titre");
		f_Societe.getChamp("idBrocker").setDeroulante(true);
		f_Societe.getChamp("idBrocker").setListe(new Brocker());
		f_Societe.getChamp("idBrocker").setLibele("Brocker");
		html += f_Societe.getHTML(new Societe(),con);

		Formulaire f_Titre = new Formulaire();
		f_Titre.init(new Titre());
		f_Titre.getChamp("idTitre").setDefault("concat('ti_',idTitre.nextVal)");
		f_Titre.getChamp("idTitre").setVisible(false);
		f_Titre.getChamp("idSociete").setDeroulante(true);
		f_Titre.getChamp("idSociete").setListe(new Societe());
		f_Titre.getChamp("idSociete").setLibele("Societe");
		html += f_Titre.getHTML(new Titre(),con);

		Formulaire f_Ordre = new Formulaire();
		f_Ordre.init(new Ordre());
		f_Ordre.getChamp("idOrdre").setDefault("concat('o_',idOrdre.nextVal)");
		f_Ordre.getChamp("idOrdre").setVisible(false);
		html += f_Ordre.getHTML(new Ordre(),con);

		Formulaire f_Titre_vendu = new Formulaire();
		f_Titre_vendu.init(new Titre_vendu());
		f_Titre_vendu.getChamp("idTitre_vendu").setDefault("concat('tiv_',idTitre_vendu.nextVal)");
		f_Titre_vendu.getChamp("idTitre_vendu").setVisible(false);
		html += f_Titre_vendu.getHTML(new Titre_vendu(),con);

		Formulaire f_Transaction = new Formulaire();
		f_Transaction.init(new Transaction());
		f_Transaction.getChamp("idTransaction").setDefault("concat('tr_',idTransaction.nextVal)");
		f_Transaction.getChamp("idTransaction").setVisible(false);
		html += f_Transaction.getHTML(new Transaction(),con);

		con.close();
		
		return html;
	}
	public String get_log_client(){
		String html = "";

		html += "<h2>Connection Client</h2>";
        html += "<form method=\"post\" class=\"form-horizontal\" action=\"#\">";
        html += "<div class=\"form-group\">";
            html += "<label class=\"control-label col-sm-2\" for=\"login\">Login</label>";
            html += "<div class=\"col-sm-10\">";
            html += "<input name=\"login\" type=\"login\" class=\"form-control\" id=\"login\" placeholder=\"Enter login\">";
            html += "</div>";
        html += "</div>";
        html += "<div class=\"form-group\">";
            html += "<label class=\"control-label col-sm-2\" for=\"pwd\">Password</label>";
            html += "<div class=\"col-sm-10\">";
            html += "<input name=\"pwd\" type=\"password\" class=\"form-control\" id=\"pwd\" placeholder=\"Enter password\">";
            html += "</div>";
        html += "</div>";
        html += "<div class=\"form-group\">";
            html += "<div class=\"col-sm-offset-2 col-sm-10\">";
            html += "<button type=\"reset\" class=\"btn btn-default\">Reset</button>";
            html += "</div>";
        html += "</div>";
        html += "<div class=\"form-group\">";
            html += "<div class=\"col-sm-offset-2 col-sm-10\">";
            html += "<button type=\"submit\" class=\"btn btn-default\">Submit</button>";
            html += "</div>";
        html += "</div>";
        html += "</form>";

		return html;
	}
	public String get_log_brocker(){
		String html = "";

		html += "<h2>Connection brocker</h2>";
        html += "<form method=\"post\" class=\"form-horizontal\" action=\"#\">";
        html += "<div class=\"form-group\">";
            html += "<label class=\"control-label col-sm-2\" for=\"login\">Login</label>";
            html += "<div class=\"col-sm-10\">";
            html += "<input name=\"login\" type=\"login\" class=\"form-control\" id=\"login\" placeholder=\"Enter login\">";
            html += "</div>";
        html += "</div>";
        html += "<div class=\"form-group\">";
            html += "<label class=\"control-label col-sm-2\" for=\"pwd\">Password</label>";
            html += "<div class=\"col-sm-10\">";
            html += "<input name=\"pwd\" type=\"password\" class=\"form-control\" id=\"pwd\" placeholder=\"Enter password\">";
            html += "</div>";
        html += "</div>";
        html += "<div class=\"form-group\">";
            html += "<div class=\"col-sm-offset-2 col-sm-10\">";
            html += "<button type=\"reset\" class=\"btn btn-default\">Reset</button>";
            html += "</div>";
        html += "</div>";
        html += "<div class=\"form-group\">";
            html += "<div class=\"col-sm-offset-2 col-sm-10\">";
            html += "<button type=\"submit\" class=\"btn btn-default\">Submit</button>";
            html += "</div>";
        html += "</div>";
        html += "</form>";

		return html;
	}
	public Boolean check_log_client(String login,String pwd) throws Exception {
		if(login==null){
			throw new Exception(" ");
		}
		if(login.compareTo("")==0){
			throw new Exception("veuillez entrer votre login");
		}
		if(pwd.compareTo("")==0){
			throw new Exception("veuillez entrer votre password");
		}
		Connection con = (new DBConnection()).getConnnection();
		Object[] objs = (new Function_gen()).select(con ,"Client","idClient",pwd,"nom",login);
		if(objs.length!=1){
			throw new Exception("erreur d'authentification");
		}
		con.close();
		return true;
	}
	public Boolean check_log_brocker(String login,String pwd) throws Exception {
		if(login==null){
			throw new Exception(" ");
		}
		if(login.compareTo("")==0){
			throw new Exception("veuillez entrer votre login");
		}
		if(pwd.compareTo("")==0){
			throw new Exception("veuillez entrer votre password");
		}
		Connection con = (new DBConnection()).getConnnection();
		Object[] objs = (new Function_gen()).select(con ,"Brocker","idBrocker",pwd,"nom",login);
		if(objs.length!=1){
			throw new Exception("erreur d'authentification");
		}
		con.close();
		return true;
	}
	public String getNotNull(Object client, Object brocker,Object admin){
		if(client!=null){
			return (String)client;
		}
		if(brocker!=null){
			return (String)brocker;
		}
		return (String)admin;
	}
	public String getTypeSession(Object client, Object brocker,Object admin){
		if(client!=null){
			return "client";
		}
		if(brocker!=null){
			return "brocker";
		}
		return "admin";
	}
}