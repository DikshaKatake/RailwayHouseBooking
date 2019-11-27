import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1bestcsharp.blogspot.com
 */
public class Myquery {
    
   
    
    public ArrayList<Product> BindTable() throws SQLException{
        
   ArrayList<Product> list = new ArrayList<Product>();
    DBcon db=new DBcon();
   Connection con =db.openConnection();
   Statement st;
   ResultSet rs;
   
   try {
   st = con.createStatement();
   rs = st.executeQuery("select house_id,house_name,rooms_left,price,image from house");
   
   Product p;
   while(rs.next()){
   p = new Product(
   rs.getString("house_id"),
   rs.getString("house_name"),
   rs.getInt("rooms_left"),
   rs.getInt("price"),
   rs.getBytes("image")
   );
   list.add(p);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(Myquery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return list;
   }
}