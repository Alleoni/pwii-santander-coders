package tech.ada.pwiisantandercoders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.pwiisantandercoders.dto.ProdutoDTO;
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
    public ProdutoDTO criar(@RequestBody ProdutoDTO produtoDTO) {
        return this.produtoService.criar(produtoDTO);
    }

    @RequestMapping (value = "/{codigoBarra}", method = RequestMethod.GET)
    public ProdutoDTO findById(@PathVariable("codigoBarra") String codigoBarra) {
        return this.produtoService.buscaPorCodigoBarra(codigoBarra)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @RequestMapping(value = "/idAll", method = RequestMethod.GET)
    public List<ProdutoDTO> findAll(){
        return this.produtoService.todos();
    }

   /* @RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
    public Produto atualizar(@RequestBody ProdutoDTO produtoDTO){
       return this.produtoService.atualizar(produtoDTO);
    }
*/
    @RequestMapping(value = "/delete/{codigoBarra}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("codigoBarra") String codigoBarra){
       this.produtoService.deletar(codigoBarra);
    }


}
