package tech.ada.pwiisantandercoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.pwiisantandercoders.dto.ProdutoDTO;
import tech.ada.pwiisantandercoders.model.Produto;
import tech.ada.pwiisantandercoders.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //INSERT - CREATE
    public Produto criar(ProdutoDTO produtoDTO) {
        return this.produtoRepository.save(produtoDTO);
    }

    //BUSCAR - READ - TODOS
    public List<ProdutoDTO> todos() {
        return this.produtoRepository.findAll();
    }

    //BUSCAR - READ - BUSCAR POR ID
    public Optional<ProdutoDTO> buscarPorId(Long id){
        return this.produtoRepository.findById(id);
    }


    //ATUALIZAR - UPDATE
    public Produto atualizar(ProdutoDTO produtoDTO){
        Optional<Produto> optionalProduto = this.buscarPorId(produtoDTO.getId());
        if(optionalProduto.isPresent()) {

            Produto produtoDB = optionalProduto.get();
            Produto produtoAtualizado = new ProdutoDTO(produtoDB.getId(), produtoDB.getNome(), produtoDB.getDescricao(), produtoDB.getPreco());
            return this.produtoRepository.save(produtoAtualizado);
        }
        throw new RuntimeException("Produto inexistente");
    }

    //DELETE
    public void deletar(Long id){
        this.produtoRepository.deleteById(id);
    }

}
