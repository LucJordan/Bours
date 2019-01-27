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
        txt += "<p><a href=\"cotation.jsp\">Tableau de cotation</a></p>";
        txt += getLien("formulaire");
		txt += "<p><a href=\"deco.jsp\">deconnection</a></p>";
        return txt;
	}
	public String getLienClient(){
        String txt = "";
        txt += "<p><a href=\"index.jsp\">Accueil</a></p>";
		txt += "<p><a href=\"form_ordre.jsp?type=0\">acheter</a></p>";
		txt += "<p><a href=\"form_ordre.jsp?type=1\">vendre</a></p>";
		txt += "<p><a href=\"deco.jsp\">deconnection</a></p>";
        txt += "<p><a href=\"cotation.jsp\">Tableau de cotation</a></p>";
        return txt;
	}
	public String getTitreOrdre(String type){
		if(type.equals("0")){
			return "Formulaire d'achat";
		}
		return "Formulaire de vente";
	}
	public String getLienBrocker(){
        String txt = "";
        txt += "<p><a href=\"index.jsp\">Accueil</a></p>";
        txt += "<p><a href=\"ordre_confirm.jsp\">Ordres a confirmer</a></p>";
        txt += "<p><a href=\"ordre_conclure.jsp\">Ordres a conclure</a></p>";
        txt += "<p><a href=\"cotation.jsp\">Tableau de cotation</a></p>";
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
		txt += (new Ordreaccepted()).affS((new Function_gen()).select(con,"Ordreaccepted"));
		txt += (new Ordrenotaccepted()).affS((new Function_gen()).select(con,"Ordrenotaccepted"));
		txt += (new Titre_vendu()).affS((new Function_gen()).select(con,"Titre_vendu"));
		txt += (new Transaction()).affS((new Function_gen()).select(con,"Transaction"));
		txt += (new Info_titre()).affS((new Function_gen()).select(con,"Info_titre"));
		txt += (new Ordreaccepted()).affS((new Function_gen()).select(con,"Ordreaccepted"));
		
		con.close();
		return txt;
	}
	public String maper() throws Exception {
		Connection con = (new DBConnection()).getConnnection();
		AcceptOrdre o = new AcceptOrdre();
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
		f_Ordre.getChamp("idSociete").setLibele("Societe");
		f_Ordre.getChamp("idSociete").setDeroulante(true);
		f_Ordre.getChamp("idSociete").setListe(new Societe());
		f_Ordre.getChamp("idClient").setLibele("Client");
		f_Ordre.getChamp("idClient").setDeroulante(true);
		f_Ordre.getChamp("idClient").setListe(new Client());
		f_Ordre.getChamp("idBrocker").setLibele("Brocker");
		f_Ordre.getChamp("idBrocker").setDeroulante(true);
		f_Ordre.getChamp("idBrocker").setListe(new Brocker());
		f_Ordre.getChamp("prixUnitaire").setLibele("prix unitaire");
		f_Ordre.getChamp("nbTitre").setLibele("nombre de titre");
		f_Ordre.getChamp("dates").setLibele("Date");
		html += f_Ordre.getHTML(new Ordre(),con);

		Formulaire f_Titre_vendu = new Formulaire();
		f_Titre_vendu.init(new Titre_vendu());
		f_Titre_vendu.getChamp("idTitre_vendu").setDefault("concat('tiv_',idTitre_vendu.nextVal)");
		f_Titre_vendu.getChamp("idTitre_vendu").setVisible(false);
		f_Titre_vendu.getChamp("idTitre").setDeroulante(true);
		f_Titre_vendu.getChamp("idTitre").setListe(new Titre());
		f_Titre_vendu.getChamp("idTitre").setLibele("titre");
		f_Titre_vendu.getChamp("idProprietaire").setDeroulante(true);
		f_Titre_vendu.getChamp("idProprietaire").setListe(new Client());
		f_Titre_vendu.getChamp("idProprietaire").setLibele("Proprietaire");
		html += f_Titre_vendu.getHTML(new Titre_vendu(),con);

		Formulaire f_Transaction = new Formulaire();
		f_Transaction.init(new Transaction());
		f_Transaction.getChamp("idTransaction").setDefault("concat('tr_',idTransaction.nextVal)");
		f_Transaction.getChamp("idTransaction").setVisible(false);
		f_Transaction.getChamp("dateTransac").setLibele("date de transaction");
		f_Transaction.getChamp("idOrdreVente").setLibele("ordre de vente");
		f_Transaction.getChamp("idOrdreVente").setDeroulante(true);
		f_Transaction.getChamp("idOrdreVente").setListe(new Ordre());
		f_Transaction.getChamp("idOrdreAchat").setLibele("ordre d'achat");
		f_Transaction.getChamp("idOrdreAchat").setDeroulante(true);
		f_Transaction.getChamp("idOrdreAchat").setListe(new Ordre());
		f_Transaction.getChamp("montantBrockerV").setLibele("montant du brocker vendeur");
		f_Transaction.getChamp("montantBrockerA").setLibele("montant du brocker acheteur");
		html += f_Transaction.getHTML(new Transaction(),con);

		Formulaire f_AcceptOrdre = new Formulaire();
		f_AcceptOrdre.init(new AcceptOrdre());
		html += f_AcceptOrdre.getHTML(new AcceptOrdre(),con);

		con.close();
		
		return html;
	}

	public String getFormulaireOrdre(String idc,String type) throws Exception {
		Connection con = (new DBConnection()).getConnnection();
		String html = "";
		Formulaire f_Ordre = new Formulaire();
		f_Ordre.init(new Ordre());
		f_Ordre.getChamp("idOrdre").setDefault("concat('o_',idOrdre.nextVal)");
		f_Ordre.getChamp("idOrdre").setVisible(false);
		f_Ordre.getChamp("idSociete").setLibele("Societe");
		f_Ordre.getChamp("idSociete").setDeroulante(true);
		f_Ordre.getChamp("idSociete").setListe(new Societe());
		f_Ordre.getChamp("idClient").setDefault(idc);
		f_Ordre.getChamp("idClient").setVisible(false);
		f_Ordre.getChamp("idBrocker").setLibele("Brocker");
		f_Ordre.getChamp("idBrocker").setDeroulante(true);
		f_Ordre.getChamp("idBrocker").setListe(new Brocker());
		f_Ordre.getChamp("prixUnitaire").setLibele("prix unitaire");
		f_Ordre.getChamp("nbTitre").setLibele("nombre de titre");
		f_Ordre.getChamp("dates").setLibele("Date");
		f_Ordre.getChamp("type").setDefault(type);
		f_Ordre.getChamp("type").setVisible(false);
		html += f_Ordre.getHTML(new Ordre(),con);
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
	public void check_before_insert(Object o,Connection con) throws Exception {
		if(o.getClass().getName().equals("donnee.Ordre")){
			Ordre sujet = (Ordre)o;
			if(sujet.getType()==1){
				Object[] objs = (new Function_gen()).select(con, "Info_titre", "idProprietaire", sujet.getIdClient(),"idSociete",sujet.getIdSociete());
				Info_titre[] its = new Info_titre[objs.length];
				for(int i=0; i<objs.length; i++){
					its[i] = (Info_titre)objs[i];
				}
				check_qtt_vendu(its, sujet.getNbTitre());
			}
		}
	}
	public void check_qtt_vendu(Info_titre[] its, int nbTitre) throws Exception {
		if( nbTitre > its.length){
			throw new Exception("vous n'avez pas assez de titre dans cette societe");
		}
	}
    public void check_after_insert(Object o,Connection con) throws Exception {
    
	}
	public String lister_Brocker(String idBrocker) throws Exception {
		Connection con = (new DBConnection()).getConnnection();
		String txt = "";
		txt += (new Ordrenotaccepted()).affSpecA((new Function_gen()).select(con,"Ordrenotaccepted","idBrocker",idBrocker,"type","0"),con);
		txt += (new Ordrenotaccepted()).affSpecV((new Function_gen()).select(con,"Ordrenotaccepted","idBrocker",idBrocker,"type","1"),con);

		con.close();
		return txt;
	}
	public String aConclure(String idBrocker) throws Exception {
		Connection con = (new DBConnection()).getConnnection();
		String res = aConclure(idBrocker,con);
		con.close();
		return res;
	}
	public String aConclure(String idBrocker,Connection con) throws Exception {
		Object[] mes_ordre_A = (new Function_gen()).select(con,"Ordreaccepted","idBrocker",idBrocker,"type","0");
		Object[] mes_ordre_V = (new Function_gen()).select(con,"Ordreaccepted","idBrocker",idBrocker,"type","1");
		// Object[] ordre_autre = (new Function_gen()).selectnot(con, "Ordreaccepted", "IDBROCKER", idBrocker);
		Object[] ordre_autre = (new Function_gen()).select(con, "Ordreaccepted");
		String res = "";

		res += "<table class=\"table table-bordered\">";
			res += "<tr>";
				res += "<th>vos achats</th>";
				res += "<th>Proposition</th>";
			res += "</tr>";
			for(int i=0; i<mes_ordre_A.length; i++){
				res += "<tr>";
					Ordre o = (Ordre)mes_ordre_A[i];
					res += "<td>"+o.getIdOrdre()+": vous voulez acheter "+o.getNbTitre()+" titre de la societe "+o.getIdSociete()+" appartenant au client "+o.getIdClient()+" prix unitaire= "+o.getPrixUnitaire()+" le "+o.getDates()+"</td>";
					res += "<td>";
						for(int j=0; j<ordre_autre.length; j++){
							Ordre o_autre = (Ordre)ordre_autre[j];
							if(o_autre.getIdSociete().equals(o.getIdSociete()) && o_autre.getType()!=o.getType()){
								res += "<p>"+o_autre.getIdOrdre()+": "+o_autre.getIdBrocker()+" veut vendre "+o_autre.getNbTitre()+" titre de la societe "+o_autre.getIdSociete()+" appartenant au client "+o_autre.getIdClient()+" prix unitaire= "+o_autre.getPrixUnitaire()+" le "+o_autre.getDates()+"</p>";
								res += "<p><a href=\"conclure_ordre.jsp?idOrdreProposition="+o_autre.getIdOrdre()+"&idMyOrdre="+o.getIdOrdre()+"\">conclure</a></p>";
							}
						}
					res += "</td>";
				res += "</tr>";
			}
		res += "</table>";

		res += "<table class=\"table table-bordered\">";
			res += "<tr>";
				res += "<th>vos ventes</th>";
				res += "<th>Proposition</th>";
			res += "</tr>";
			for(int i=0; i<mes_ordre_V.length; i++){
				res += "<tr>";
					Ordre o = (Ordre)mes_ordre_V[i];
					res += "<td>"+o.getIdOrdre()+": vous voulez vendre "+o.getNbTitre()+" titre de la societe "+o.getIdSociete()+" appartenant au client "+o.getIdClient()+" prix unitaire= "+o.getPrixUnitaire()+" le "+o.getDates()+"</td>";
					res += "<td>";
						for(int j=0; j<ordre_autre.length; j++){
							Ordre o_autre = (Ordre)ordre_autre[j];
							if(o_autre.getIdSociete().equals(o.getIdSociete()) && o_autre.getType()!=o.getType()){
								res += "<p>"+o_autre.getIdOrdre()+": "+o_autre.getIdBrocker()+" veut acheter "+o_autre.getNbTitre()+" titre de la societe "+o_autre.getIdSociete()+" appartenant au client "+o_autre.getIdClient()+" prix unitaire= "+o_autre.getPrixUnitaire()+" le "+o_autre.getDates()+"</p>";
								res += "<p><a href=\"conclure_ordre.jsp?idOrdreProposition="+o_autre.getIdOrdre()+"&idMyOrdre="+o.getIdOrdre()+"\">conclure</a></p>";
							}
						}
					res += "</td>";
				res += "</tr>";
			}
		res += "</table>";
		return res;
	}
	public void confirmOrdre(String idOrdre) throws Exception {
		DBConnection dbh =  new DBConnection();
		Connection con = dbh.getConnnection();
		AcceptOrdre ao = new AcceptOrdre("concat('ao_',idAcceptordre.nextVal)",idOrdre);
		(new Function_gen()).insert(con, ao, "AcceptOrdre");
		con.close();
	}
	public String getTabCotation() throws Exception {
		Connection con = new DBConnection().getConnnection();
		String res = getTabCotation(con);
		con.close();
		return res;
	}
	public String getTabCotation(Connection con) throws Exception {
		String html = "";
		html += "<table class=\"table table-bordered\">";
			html += "<tr>";
				html += "<th>Societe</th>";
				html += "<th>Achat</th>";
				html += "<th>Vente</th>";
			html += "</tr>";
			Object[] listedesociete = (new Function_gen()).select(con, "Societe");
			for(int i=0; i<listedesociete.length; i++){
			Societe soc = (Societe)listedesociete[i];
			html += "<tr>";
				html += "<td>"+soc.getNom()+"</td>";
				html += "<td>";
					html += "<table class=\"table table-bordered\">";
						html += "<tr>";
							html += "<th>prix unitaire</th>";
							html += "<th>nombre de titre</th>";
							html += "<th>brocker</th>";
							html += "<th>Client</th>";
						html += "</tr>";
						Object[] listeachat = (new Function_gen()).select(con, "Ordreaccepted", "idSociete", soc.getIdSociete(),"type","0");
						for(int j=0; j<listeachat.length; j++){
						Ordreaccepted oa = (Ordreaccepted)listeachat[j];
						html += "<tr>";
							html += "<td>"+oa.getPrixUnitaire()+"</td>";
							html += "<td>"+oa.getNbTitre()+"</td>";
							html += "<td>"+oa.getIdBrocker()+"</td>";
							html += "<td>"+oa.getIdClient()+"</td>";
						html += "</tr>";
						}
					html += "</table>";
				html += "</td>";

				html += "<td>";
				html += "<table class=\"table table-bordered\">";
					html += "<tr>";
						html += "<th>prix unitaire</th>";
						html += "<th>nombre de titre</th>";
						html += "<th>brocker</th>";
						html += "<th>Client</th>";
					html += "</tr>";
					Object[] listevente = (new Function_gen()).select(con, "Ordreaccepted", "idSociete", soc.getIdSociete(),"type","1");
					for(int j=0; j<listevente.length; j++){
					Ordreaccepted ov = (Ordreaccepted)listevente[j];
					html += "<tr>";
						html += "<td>"+ov.getPrixUnitaire()+"</td>";
						html += "<td>"+ov.getNbTitre()+"</td>";
						html += "<td>"+ov.getIdBrocker()+"</td>";
						html += "<td>"+ov.getIdClient()+"</td>";
					html += "</tr>";
					}
				html += "</table>";
			html += "</td>";
			html += "</tr>";
			}
		html += "</table>";
		return html;
	}
}