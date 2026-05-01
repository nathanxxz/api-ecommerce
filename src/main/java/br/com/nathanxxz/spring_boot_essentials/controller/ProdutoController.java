package br.com.nathanxxz.spring_boot_essentials.controller;


import br.com.nathanxxz.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.nathanxxz.spring_boot_essentials.dto.ProdutoDto;
import br.com.nathanxxz.spring_boot_essentials.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> listarProdutos(){
      return  produtoService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  ProdutoEntity criarProdutos(@RequestBody ProdutoDto produtoDto){
        return  produtoService.criarProduto(produtoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  ProdutoEntity atualizarProdutos(@PathVariable Integer id, @RequestBody ProdutoDto produtoDto){
        return  produtoService.atualizarProduto(produtoDto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deletarProduto(@PathVariable Integer id){
        produtoService.removerProduto(id);
    }
}
