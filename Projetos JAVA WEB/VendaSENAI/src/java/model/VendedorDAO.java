/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.TbVendedorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class VendedorDAO extends DaoUtil {

    public VendedorDAO() {
        super();
    }
    
     private int getMaxId() throws SQLException, ClassNotFoundException{
        int retID;
        PreparedStatement ps = super.getPreparedStatement("SELECT MAX(IDVENDEDOR)+1 FROM TbVendedor");
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()){
            retID = 1;
        }else{
            if(rs.getInt(1) == 0){
                retID = 1;
            }else{
                retID=rs.getInt(1);
            }
        }
        return retID;
    }
    public boolean adicionar(TbVendedorDTO vendedor) throws SQLException, ClassNotFoundException{
     int idVendedor = this.getMaxId();
     
     PreparedStatement ps = super.getPreparedStatement("INSERT INTO TBVENDEDOR "
                                                        + "(IDVENDEDOR, NOMEVENDEDOR , DTNASCIMENTO) "
                                                        + " VALUES (?,?,?)");
     
     ps.setInt(1, idVendedor);
     ps.setString(2, vendedor.getNomevendedor());
     ps.setDate(3, new java.sql.Date(vendedor.getDtnascimento().getTime()));
     
     int ret = ps.executeUpdate();
     ps.close();
     super.getFechaTudo();
     return ret>0;
     //PQ O DTO NO ATRIBUTO DATA COMO SQL DATE  - RESPOSTA - VAI MANIPULAR ISSO NA VIEW E NA VIEW NAO PODE RECEBER ISSO NA VIEW , SQL È CONTEUDO DE BANCO.
    }
     public boolean alterar(TbVendedorDTO vendedor) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = super.getPreparedStatement("UPDATE TBVENDEDOR SET "
                + "NOMEVENDEDOR = ?"
                + "DTNASCIMENTO = ?, "
                + "WHERE IDVENDEDOR = ?");
        
        ps.setString(1, vendedor.getNomevendedor());
        ps.setDate(2, new java.sql.Date(vendedor.getDtnascimento().getTime()));
        ps.setInt(3, vendedor.getIdvendedor());
        
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
        }
      public boolean excluir(TbVendedorDTO vendedor) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM TBVENDEDOR"
                + "WHERE IDVENDEDOR = ?");
        
        ps.setInt(1, vendedor.getIdvendedor()); // MODIFIQUEI DE 5 para 1
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
        }
      public TbVendedorDTO getVendedorPorId(TbVendedorDTO vendedor)throws SQLException, ClassNotFoundException{
      PreparedStatement ps = super.getPreparedStatement("SELECT * FROM TBVENDEDOR "
                + "WHERE IDVENDEDOR = ?");
         
         ps.setInt(1, vendedor.getIdvendedor());
         ResultSet rs = ps.executeQuery();
         if(!rs.next()){
             rs.close();
             ps.close();
             super.getFechaTudo();
             return null;
         }
         TbVendedorDTO proRet = new TbVendedorDTO(rs.getInt("IDVENDEDOR"),
                                                rs.getString("NOMEVENDEDOR"),
                                                rs.getDate("DTNASCIMENTO"));
         rs.close();
         ps.close();
         super.getFechaTudo();
         return proRet;
   }
   
   public List<TbVendedorDTO> getTodos() throws SQLException, ClassNotFoundException{
          List<TbVendedorDTO> todosOsVendedores = new LinkedList<TbVendedorDTO>();
       
       PreparedStatement ps = super.getPreparedStatement("SELECT * FROM TBVENDEDOR");
          
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
         todosOsVendedores.add( new TbVendedorDTO(rs.getInt("IDVENDEDOR"),
                                                rs.getString("NOMEVENDEDOR"),  
                                                rs.getDate("DTNASCIMENTO")) );
         }
         
         rs.close();
         ps.close();
         super.getFechaTudo();
         return todosOsVendedores;
   }
}
