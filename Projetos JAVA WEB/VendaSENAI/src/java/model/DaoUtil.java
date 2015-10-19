/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Matthew
 */
public abstract class DaoUtil {
    private Connection cx = null;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if(cx == null){
            String url = "jdbc:sqlite:D:\\Linguagem Orientada a Objetos II\\BancoDeDados\\VendasSenai.s3db";
            String login = "";
            String senha = "";
            Class.forName("org.sqlite.JDBC");
            cx = DriverManager.getConnection(url, url, senha);
        }
        return cx;
    }
    public Statement getStatement() throws SQLException, ClassNotFoundException{
        return this.getConnection().createStatement();
    }
    public PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException{
        return this.getConnection().prepareStatement(sql);
    }
    
    public void getFechaTudo() throws SQLException{
        if(cx != null){
            cx.close();
            cx = null;
        }
    }

   public int getMaxId(String sqlMAX) throws SQLException, ClassNotFoundException{
       int retID;
       PreparedStatement ps = getPreparedStatement(sqlMAX);
       ResultSet rs = ps.executeQuery();
       
       if(!rs.next()){
           retID = 1;
       }else{
           if(rs.getInt(1)== 0 ){
               retID = 1;
           }else{
               retID = rs.getInt(1);
           }
       }
       return retID;
   }
    
}
