package com.marcosvcg.qualificacaooaktecnologia.model.dto;

import com.marcosvcg.qualificacaooaktecnologia.model.entities.Produto;
import com.marcosvcg.qualificacaooaktecnologia.model.enums.DisponivelParaVenda;

import java.math.BigDecimal;

public record ProdutoDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal valor,
        DisponivelParaVenda disponivel
) {

    public static ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getValor(),
                produto.getDisponibilidade()
        );
    }

    public static Produto toEntity(ProdutoDTO dto) {
        return new Produto(
                dto.nome(),
                dto.descricao(),
                dto.valor(),
                dto.disponivel()
        );
    }
}
