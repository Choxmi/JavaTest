/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_library;

import com.mysql.jdbc.Connection;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Choxmi
 */
public class LibraryDAO {
    String connectionString = "jdbc:mysql://localhost:3306/library?zeroDateTimeBehavior=convertToNull";
    private static LibraryDAO instance;
    PreparedStatement ps;
    String query;
    Connection con;        
    private LibraryDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            con=(Connection) DriverManager.getConnection(connectionString,"root",""); 
            
            if(con!=null){
                System.out.println("Connection succeeded");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static LibraryDAO getInstance(){
        if(instance==null){
            instance = new LibraryDAO();
        }
        return instance;
    }
    
    public int insertMember(String fname, String lname, String address, int tel){
        query = "INSERT INTO members(mem_first_name,mem_last_name,mem_address,mem_telephone,mem_type) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, address);
            ps.setInt(4, tel);
            ps.setInt(5, 0);
            
            ps.execute();
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public int insertAuthor(String name){
        query = "INSERT INTO author(auth_name) VALUES (?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            
            ps.execute();
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public int insertBook(String name, String desc, int author){
        query = "INSERT INTO books(bk_name,bk_description,bk_author) VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, desc);
            ps.setInt(3, author);
            
            ps.execute();
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public ResultSet searchRecords(String tbl, String keyCol, int key, List<String> columns, List<String> values){
        try {
            query = "SELECT * FROM "+tbl+" WHERE 1 = 1 ";
            if(key!=0){
                query = query + " AND "+keyCol+" = "+key;
            }
            
            if(values!=null){
                System.out.println("Values : "+values.size());
                for(int i =0;i<values.size();i++){
                    if(tryParse(values.get(i))!=0){
                        query = query + " AND " + columns.get(i)+ " = "+values.get(i);
                    }else{
                        query = query + " AND " + columns.get(i)+ " LIKE '%"+values.get(i)+"%'";
                    }
                }
            }
            System.out.println("Query : "+query);
            ps = con.prepareStatement(query);
            
            return ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public int dropRecords(String tableName, String keyCol, int id){
        query = "DELETE FROM "+tableName+" WHERE "+keyCol+" = "+id;
        try{
            ps = con.prepareStatement(query);
            ps.execute();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    
    private int tryParse(String txt){
        int val = 0;
        try{
            val = Integer.parseInt(txt);
        }catch(Exception e){
            val = 0;
        }
        return val;
    }
    
}
