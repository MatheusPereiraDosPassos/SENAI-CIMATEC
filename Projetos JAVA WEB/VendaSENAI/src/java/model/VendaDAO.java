/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.TbProdutoDTO;
import dto.TbVendaDTO;
import dto.TbVendedorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class VendaDAO extends DaoUtil {

    private VendedorDAO vendedordao = new VendedorDAO();
    private ProdutoDAO produtodao = new ProdutoDAO();

    public VendaDAO() {
        super();
    }

    //THE JUMP of the CATS 

    public boolean Adicionar(TbVendaDTO venda) throws SQLException, ClassNotFoundException {
        int idvenda = super.getMaxId("SELECT MAX(idVenda)+1 from TBVENDA");
        PreparedStatement ps = super.getPreparedStatement("INSERT INTO TBVENDA "
                + "(IDVENDA, IDVENDEDOR , IDPRODUTO, QTQUANTIDADE) "
                + " VALUES (?,?,?,?)");

        ps.setInt(1, idvenda);
        ps.setInt(2, venda.getVendedor().getIdvendedor());
        ps.setInt(3, venda.getProduto().getIdproduto());
        ps.setInt(4, venda.getQtquantidade());

        int ret = ps.executeUpdate();
        ps.close();
        
        produtodao.setAlterarestoque(venda.getProduto());
        super.getFechaTudo();
        return ret > 0;
    }
    public boolean alterar(TbVendaDTO venda) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = super.getPreparedStatement("UPDATE TBVENDA SET "
                + "idVendedor = ?, "
                + "idProduto = ? ,"
                + "qtQuantidade = ? ,"
                + "WHERE IdVenda = ?");
        
        ps.setInt(1, venda.getVendedor().getIdvendedor());
        ps.setInt(2, venda.getProduto().getIdproduto());
        ps.setInt(3, venda.getQtquantidade());
        ps.setInt(4, venda.getIdvenda());
        
        
        int ret = ps.executeUpdate();
        produtodao.setAlterarestoque(venda.getProduto());
        ps.close();
        super.getFechaTudo();
        return ret > 0;
        }
      public boolean excluir(TbVendaDTO venda) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM TBVENDA"
                + "WHERE IDVENDA = ?");
        
        ps.setInt(1, venda.getIdvenda()); // MODIFIQUEI DE 5 para 1
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
        }
      public TbVendaDTO getPorId(TbVendaDTO venda)throws SQLException, ClassNotFoundException{
      PreparedStatement ps = super.getPreparedStatement("SELECT * FROM TBVENDA "
                + "WHERE IDVENDA = ?");
         
         ps.setInt(1, venda.getIdvenda());
         ResultSet rs = ps.executeQuery();
         if(!rs.next()){
             rs.close();
             ps.close();
             super.getFechaTudo();
             return null;
         }
          TbVendedorDTO vendedor = vendedordao.getVendedorPorId(new TbVendedorDTO(rs.getInt("idVendedor"), null, null));
          TbProdutoDTO produto = produtodao.getPorId(new TbProdutoDTO(rs.getInt("idProduto"), null, null, 0, 0));
          TbVendaDTO vendaRet = new TbVendaDTO(rs.getInt("idVenda"), vendedor, produto, rs.getInt("qtQuantidade"));
          
         rs.close();
         ps.close();
         super.getFechaTudo();
         return vendaRet;
   }
    public List<TbVendaDTO> getTodasAsVendas() throws SQLException, ClassNotFoundException{
          List<TbVendaDTO> todasAsVendas = new LinkedList<TbVendaDTO>();
       
       PreparedStatement ps = super.getPreparedStatement("SELECT * FROM TBVENDA");
          
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
          TbVendedorDTO vendedor = vendedordao.getVendedorPorId(new TbVendedorDTO(rs.getInt("idVendedor"), null, null));
          TbProdutoDTO produto = produtodao.getPorId(new TbProdutoDTO(rs.getInt("idProduto"), null, null, 0, 0));
          TbVendaDTO vendaRet = new TbVendaDTO(rs.getInt("idVenda"), vendedor, produto, rs.getInt("qtQuantidade"));
          todasAsVendas.add( new TbVendaDTO(rs.getInt("idVenda"), vendedor, produto, rs.getInt("qtQuantidade")));
         }
         
         rs.close();
         ps.close();
         super.getFechaTudo();
         return todasAsVendas;
         // Se a tabela tiver 50000 mil registros , qual é o custo ? - Desempenho quadrático(para cada registro é elevado ao quadrado) SUpondo que tivesse uma outra 
         //entidade relacional (ex:......) para cada iteração vira uma exponencial.
   }
}
