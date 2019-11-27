

  

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
    private Connection conn;
    private Statement statement;
    public Connection openConnection()throws SQLException
    {
      if(conn==null)
      {
          try
          {
        Class.forName("com.mysql.jdbc.Driver");
                this.conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/rail","root","");
          System.out.println("Connected");
          }
          catch(Exception e)
          {
              System.out.print(e.toString());
          }
      }
      return conn;
    }

}


