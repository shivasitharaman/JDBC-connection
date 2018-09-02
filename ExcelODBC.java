import java.sql.*;
public class ExcelODBC {

	public static void main(String[] args) {
		
		 try {
	            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	            Connection con = DriverManager.getConnection("jdbc:odbc:shiva");
	            if(con==null) {
	            	System.out.println("access denied");
	            }
	            else {
	            	System.out.println("connected successfully!!");
	            }
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("Select * from [student$]");
	 
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int numberOfColumns = rsmd.getColumnCount();
	 
	            while (rs.next()) {
	 
	                for (int i = 1; i <= numberOfColumns; i++) {
	                    if (i > 1)
	                        System.out.print(", ");
	                    String columnValue = rs.getString(i);
	                    System.out.print(columnValue);
	                }
	                System.out.println("");
	            }
	 
	            st.close();
	            con.close();
	 
	        } catch (Exception ex) {
	            System.err.print("Exception: ");
	            System.err.println(ex.getMessage());
	        }
	    }
}
