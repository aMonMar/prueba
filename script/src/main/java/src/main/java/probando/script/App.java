package src.main.java.probando.script;

import java.sql.*;

import org.apache.commons.lang3.StringUtils;


/**
 * Hello world!
 *
 */
public class App{	
	
    public static void main( String[] args ) {
    	
    	String param1=args[0];
		String[] param1_array=StringUtils.split(param1, "#");
		String param1_01=param1_array[0];
		String param1_02=param1_array[1];
		String param1_03=param1_array[2];
		System.out.println("parametro1: "+param1_01+ " \nparam2: "+param1_02+"\nparam3: "+param1_03);
		
		Connection conexion = null;
		
		try{
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdciclistas",
	        									"root","");
	        
	        System.out.println("Conexión Exitosa");
	    }catch(SQLException ex){
	        System.out.println("Error al abrir Conexión: " + ex.getMessage());
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		String sql="Select* from ciclista";
		Statement s;
		try {
			s = conexion.createStatement();
			ResultSet rs =s.executeQuery (sql);
			
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{
			    System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getInt(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
//		   try (Connection conn = DriverManager.getConnection(
//	                "jdbc:mysql://127.0.0.1:3306/bdciclistas", "root", "")) {
//
//	            if (conn != null) {
//	                System.out.println("Connected to the database!");
//	            } else {
//	                System.out.println("Failed to make connection!");
//	            }
//
//	        } catch (SQLException e) {
//	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
		
//		try  {	
//			conn = DriverManager.getConnection(dbhost, username, password);
//			
//		System.out.println("conectado ");
//		
//		
//		} catch (SQLException e) {
//			System.out.println("Cannot create database connection");
//			e.printStackTrace();
//		} 	
//		
		
		
		
    	
    	    	
       //System.out.println( "Hello World!" );
    }
}
