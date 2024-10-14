package com.marcosvcg.qualificacaooaktecnologia.util;

import com.marcosvcg.qualificacaooaktecnologia.model.entities.Produto;
import com.marcosvcg.qualificacaooaktecnologia.model.enums.DisponivelParaVenda;
import com.marcosvcg.qualificacaooaktecnologia.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class DummyData implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public DummyData(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void run(String... args) {
        List<Produto> dummyData = Arrays.asList(
                new Produto(null, "Leite Ninho", "Leite em pó integral Ninho, 380g", BigDecimal.valueOf(22.89), DisponivelParaVenda.SIM),
                new Produto(null, "Toddy", "Achocolatado em pó Toddy 800g", BigDecimal.valueOf(12.99), DisponivelParaVenda.SIM),
                new Produto(null, "Whey Protein", "Whey Protein da melhor qualidade 1kg", BigDecimal.valueOf(109.99), DisponivelParaVenda.SIM),
                new Produto(null, "Suco Ades", "Suco Ades 1L de sabor morango", BigDecimal.valueOf(8.69), DisponivelParaVenda.NAO),
                new Produto(null, "Coca-Cola Zero", "Refrigerante Coca-Cola Sem Açúcar 1L", BigDecimal.valueOf(4.89), DisponivelParaVenda.SIM)
        );

        produtoRepository.saveAll(dummyData);
    }
}