package com.marcosvcg.qualificacaooaktecnologia.model.dto;

import com.marcosvcg.qualificacaooaktecnologia.model.entities.Produto;

import java.math.BigDecimal;

public record ListagemDTO(Long id, String nome, BigDecimal valor) {

    public static ListagemDTO toDTO(Produto produto) {
        return new ListagemDTO(
                produto.getId(),
                produto.getNome(),
                produto.getValor()
        );
    }

    public static Produto toEntity(ListagemDTO dto) {
        return new Produto(
                dto.nome(),
                dto.valor()
        );
    }
}


