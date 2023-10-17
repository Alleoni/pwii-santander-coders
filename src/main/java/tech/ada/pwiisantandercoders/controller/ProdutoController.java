package tech.ada.pwiisantandercoders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.pwiisantandercoders.model.Produto;
import tech.ada.pwiisantandercoders.service.ProdutoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //POST - Criar
    //GET  - Buscar
    //PUT/PATCH  - Atualizar
    //DELETE     - Deletar

    @RequestMapping(value = "/criar", method = RequestMethod.POST)
    //@PostMapping(value = "/criar")
    public Produto criar(@RequestBody Produto produto) {
        return this.produtoService.criar(produto);
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public Optional<Produto> findById(@PathVariable Long id) {
        return this.produtoService.buscarPorId(id);
    }

    @RequestMapping(value = "/idAll", method = RequestMethod.GET)
    public List<Produto> findAll(){
        return produtoService.todos();
    }

    //Listar todos

}
