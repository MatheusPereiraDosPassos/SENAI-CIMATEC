/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.TbProdutoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class ProdutoDAO extends DaoUtil {

    public ProdutoDAO() {
        super();
    }
    
    private int getMaxId() throws SQLException, ClassNotFoundException{
        int retID;
        PreparedStatement ps = super.getPreparedStatement("SELECT MAX(idproduto)+1 FROM TbProduto");
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
    
    public boolean adicionar(TbProdutoDTO produto) throws SQLException, ClassNotFoundException{
        int idproduto = this.getMaxId();
        PreparedStatement ps = super.getPreparedStatement("INSERT INTO TBPRODUTO "
                + "(IDPRODUTO, "
                + "DESCRICAO, "
                + "FABRICANTE, "
                + "QTESTOQUE,  "
                + "VLPRECO) " 
                + "VALUES (?,?,?,?,?)");
        ps.setInt(1, idproduto);
        ps.setString(2, produto.getDescricao());
        ps.setString(3, produto.getFabricante());
        ps.setInt(4, produto.getQtestoque());
        ps.setFloat(5, produto.getVlpreco());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }
    
    public boolean alterar(TbProdutoDTO produto) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = super.getPreparedStatement("UPDATE TBPRODUTO SET "
                + "DESCRICAO = ?,"
                + "FABRICANTE = ?, "
                + "QTESTOQUE = ?,  "
                + "WHERE IDPRODUTO = ?");
        
        ps.setString(1, produto.getDescricao());
        ps.setString(2, produto.getFabricante());
        ps.setInt(3, produto.getQtestoque());
        ps.setFloat(4, produto.getVlpreco());
        ps.setInt(5, produto.getIdproduto());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
        }
    
   public boolean excluir(TbProdutoDTO produto) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM TBPRODUTO "
                + "WHERE IDPRODUTO = ?");
        
        ps.setInt(1, produto.getIdproduto());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
        }
   
   public TbProdutoDTO getPorId(TbProdutoDTO produto)throws SQLException, ClassNotFoundException{
      PreparedStatement ps = super.getPreparedStatement("SELECT * FROM TBPRODUTO "
                + "WHERE IDPRODUTO = ?");
         
         ps.setInt(1, produto.getIdproduto());
         ResultSet rs = ps.executeQuery();
         if(!rs.next()){
             rs.close();
             ps.close();
             super.getFechaTudo();
             return null;
         }
         TbProdutoDTO proRet = new TbProdutoDTO(rs.getInt("IDPRODUTO"),
                                                rs.getString("DESCRICAO"),
                                                rs.getString("FABRICANT"),  
                                                rs.getInt("QTESTOQUE"),
                                                rs.getFloat("VLPRECO"));
         rs.close();
         ps.close();
         super.getFechaTudo();
         return proRet;
   }
   
   //Cada no dessa lista será um dto que possui valores ou tipos , cada get é um tipo que retorna e cada set é um tipo que seta , por isso é fortemente TIPADA
   //LINKEDLIST - TIPADA
  
   public List<TbProdutoDTO> getTodos() throws SQLException, ClassNotFoundException{
          List<TbProdutoDTO> todosOsProdutos = new LinkedList<TbProdutoDTO>();
       
       PreparedStatement ps = super.getPreparedStatement("SELECT * FROM TBPRODUTO");
          
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
         todosOsProdutos.add( new TbProdutoDTO(rs.getInt("IDPRODUTO"),
                                                rs.getString("DESCRICAO"),
                                                rs.getString("FABRICANT"),  
                                                rs.getInt("QTESTOQUE"),
                                                rs.getFloat("VLPRECO")) );
         }
         
         rs.close();
         ps.close();
         super.getFechaTudo();
         return todosOsProdutos;
   }
   public boolean setAlterarestoque(TbProdutoDTO produto) throws SQLException, ClassNotFoundException{
       PreparedStatement ps = super.getPreparedStatement("UPDATE TBPRODUTOS " 
                                                         + "SET QTESTOQUE = QTESTOQUE -" + produto.getQtestoque()
                                                         + "WHERE IDPRODUTO = " + produto.getIdproduto());
       
       int ret = ps.executeUpdate();
       ps.close();
       super.getFechaTudo();
       return ret > 0;
   /*
   // Outra alternativa
   TbProdutoDTO prodAux = this.getProdutoPorId(produto);
   int auxQt = prodAux.getQtestoque();
   prodAux.setQtestoque(auxQt - produto.getQtestoque());
   this.alterar(prodAux); 
   */
   }
   
}
 