package tech.ada.pwiisantandercoders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.pwiisantandercoders.model.Produto;
import tech.ada.pwiisantandercoders.service.ProdutoService;

import java.util.List;

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

    @RequestMapping (value = "/{codigoBarra}", method = RequestMethod.GET)
    public Produto findById(@PathVariable("codigoBarra") String codigoBarra) {
        return this.produtoService.buscarPorId(codigoBarra)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @RequestMapping(value = "/idAll", method = RequestMethod.GET)
    public List<Produto> findAll(){
        return this.produtoService.todos();
    }

    @RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
    public Produto atualizar(@RequestBody Produto produto){
       return this.produtoService.atualizar(produto);
    }

    @RequestMapping(value = "/delete/{sk}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("sk") String sk){
       this.produtoService.deletar(codigoBarra);
    }


    //Listar todos

}
