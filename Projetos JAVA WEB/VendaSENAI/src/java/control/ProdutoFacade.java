package control;

import dto.TbProdutoDTO;
import java.sql.SQLException;
import java.util.List;
import model.ProdutoDAO;

/**
 *
 * @author Matthew
 */
public class ProdutoFacade {
    private ProdutoDAO prodDAO = new ProdutoDAO();
    private TbProdutoDTO produtoselecionado;
    private List<TbProdutoDTO> produtos;
    private int idCombo;
    
    public String preparaParaIncluir(){
       produtoselecionado = new TbProdutoDTO(idCombo, null, null, idCombo, idCombo);
        return "vaiParaIncluir";
       
    }
    public ProdutoFacade() {
        produtos = null;
    }
    
    
    public TbProdutoDTO getProdutoselecionado() {
        return produtoselecionado;
    }

    public void setProdutoselecionado(TbProdutoDTO produtoselecionado) {
        this.produtoselecionado = produtoselecionado;
    }

    public List<TbProdutoDTO> getProdutos() throws SQLException, ClassNotFoundException {
        if(produtos != null){
            produtos = prodDAO.getTodos();
        }
        return produtos;
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }
    
    
}
