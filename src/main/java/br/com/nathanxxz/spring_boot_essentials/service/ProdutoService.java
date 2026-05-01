package br.com.nathanxxz.spring_boot_essentials.service;

import br.com.nathanxxz.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.nathanxxz.spring_boot_essentials.dto.ProdutoDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private  static  final List<ProdutoEntity> PRODUTOS = new ArrayList<>(List.of(
            ProdutoEntity.builder()
                    .id(1)
                    .nome("Notebook")
                    .preco(new BigDecimal(5000))
                    .quantidade(10)
                    .build()
    ));
    public  List<ProdutoEntity> listar(){
        return  new ArrayList<>(PRODUTOS);
    }

    public ProdutoEntity criarProduto(ProdutoDto produtoDto){

        Integer identificador = PRODUTOS.stream()
                .mapToInt(ProdutoEntity::getId)
                .max()
                .orElse(0) + 1;
        ProdutoEntity novoProduto = ProdutoEntity.builder()
                .nome(produtoDto.getNome())
                .preco(produtoDto.getPreco())
                .quantidade(produtoDto.getQuantidade())
                .build();

        PRODUTOS.add(novoProduto);
        return  novoProduto;
    }

    public ProdutoEntity atualizarProduto (ProdutoDto produtoDto, Integer id){
        ProdutoEntity produto = PRODUTOS.stream()
                .filter(produtoEntity -> produtoEntity.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());
        return  produto;
    }

    public void removerProduto(Integer id){
        PRODUTOS.removeIf(produtoEntity -> produtoEntity.getId().equals(id));
    }
}
