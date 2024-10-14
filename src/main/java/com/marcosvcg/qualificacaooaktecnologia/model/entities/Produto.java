package com.marcosvcg.qualificacaooaktecnologia.model.entities;

import com.marcosvcg.qualificacaooaktecnologia.model.enums.DisponivelParaVenda;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private DisponivelParaVenda disponivel;

    public Produto(Long id, String nome, String descricao, BigDecimal valor, DisponivelParaVenda disponivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public Produto(String nome, String descricao, BigDecimal valor, DisponivelParaVenda disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public Produto(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public DisponivelParaVenda getDisponibilidade() {
        return disponivel;
    }

    public void setDisponibilidade(DisponivelParaVenda disponivel) {
        this.disponivel = disponivel;
    }
}
