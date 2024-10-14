package com.marcosvcg.qualificacaooaktecnologia.service;

import com.marcosvcg.qualificacaooaktecnologia.model.dto.ListagemDTO;
import com.marcosvcg.qualificacaooaktecnologia.model.dto.ProdutoDTO;
import com.marcosvcg.qualificacaooaktecnologia.model.entities.Produto;
import com.marcosvcg.qualificacaooaktecnologia.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoDTO obterProduto(Long id) throws Exception {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if(produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            return ProdutoDTO.toDTO(produto);
        } else {
            throw new Exception("Produto com o ID: " + id + " não encontrado.");
        }
    }

    public List<ListagemDTO> listarProdutosOrdenados() {
        return produtoRepository.ordenarProdutosMenorParaMaiorPeloPreco()
                .stream()
                .map(ListagemDTO::toDTO)
                .collect(Collectors.toList());
    }

    public void cadastrarProduto(ProdutoDTO dto) {
        produtoRepository.save(ProdutoDTO.toEntity(dto));
    }
}
