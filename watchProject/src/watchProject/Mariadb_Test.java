package watchProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mariadb_Test {

		    String driver = "org.mariadb.jdbc.Driver";
		    Connection con;
		    PreparedStatement pstmt;
		    ResultSet rs;
		    public void DBcon() {
		   
		         try {
		            Class.forName(driver);
		            con = DriverManager.getConnection(
		                    "jdbc:mariadb://203.245.28.69:3306/project_db",
		                    "root",
		                    "manager123");
		            
		            if( con != null ) {
		                System.out.println("DB ���� ����");
		            }
		            
		        } catch (ClassNotFoundException e) { 
		            System.out.println("����̹� �ε� ����");
		        } catch (SQLException e) {
		            System.out.println("DB ���� ����");
		            e.printStackTrace();
		        }
		    
		    }
	public static void main(String[] args){
		Mariadb_Test dbcon    = new Mariadb_Test();
		dbcon.DBcon();
    }
}
