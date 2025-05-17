package com.example.demo.mapper;

import com.example.demo.dto.ProdutoDTO;
import com.example.demo.model.Produto;

public class ProdutoMapper {

    public static ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO.Builder()
            .nome(produto.getNome())
            .descricao(produto.getDescricao())
            .preco(produto.getPreco())
            .quantidadeEmEstoque(produto.getQuantidadeEmEstoque())
            .categoria(produto.getCategoria())
            .build();
    }
}