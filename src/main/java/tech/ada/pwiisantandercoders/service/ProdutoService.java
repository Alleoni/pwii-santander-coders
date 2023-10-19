package tech.ada.pwiisantandercoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.pwiisantandercoders.converter.ProdutoConverter;
import tech.ada.pwiisantandercoders.dto.ProdutoDTO;
import tech.ada.pwiisantandercoders.model.Produto;
import tech.ada.pwiisantandercoders.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoConverter produtoConverter;

    //INSERT - CREATE
    public Produto criar(ProdutoDTO produtoDTO) {
       Produto produto = this.produtoConverter.toProduto(produtoDTO);
        return this.produtoRepository.save(produto);
    }

    //BUSCAR - READ - TODOS
    public List<ProdutoDTO> todos() {
        return this.produtoRepository.findAll().stream()
                .map(produto -> this.produtoConverter.toProdutoDTO(produto))
                .collect(Collectors.toList());
    }

    //BUSCAR - READ - BUSCAR POR ID
    public Optional<ProdutoDTO> buscarPorId(Long id){
        return this.produtoRepository.findById(id);
    }


    //ATUALIZAR - UPDATE
    public ProdutoDTO atualizar(ProdutoDTO produtoDTO){
        Optional<ProdutoDTO> optionalProduto = this.buscarPorId(produtoDTO.getId());
        if(optionalProduto.isPresent()) {

            ProdutoDTO produtoDB = optionalProduto.get();
            ProdutoDTO produtoAtualizado = new ProdutoDTO(produtoDB.getId(), produtoDB.getNome(), produtoDB.getDescricao(), produtoDB.getPreco());
            return this.produtoRepository.save(produtoAtualizado);
        }
        throw new RuntimeException("Produto inexistente");
    }

    //DELETE
    public void deletar(Long id){
        this.produtoRepository.deleteById(id);
    }

}
