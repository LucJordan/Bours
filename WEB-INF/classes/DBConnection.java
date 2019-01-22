package connexion;

import java.sql.*;
import java.lang.reflect.*;

public class DBConnection{
	public Connection getConnnection()throws Exception{
		String user = "bours";
		String pwd = "bours";
		System.out.println("connexion a la base");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pwd);
	}
	public DBConnection()throws Exception{}
}