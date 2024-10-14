package com.marcosvcg.qualificacaooaktecnologia.controller;

import com.marcosvcg.qualificacaooaktecnologia.model.dto.ProdutoDTO;
import com.marcosvcg.qualificacaooaktecnologia.model.enums.DisponivelParaVenda;
import com.marcosvcg.qualificacaooaktecnologia.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/api/v1")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produto/{id}")
    public String obterProduto(@PathVariable Long id, Model model) throws Exception {
        model.addAttribute("produto", produtoService.obterProduto(id));
        return "produto";
    }

    @GetMapping("/produtos")
    public String listarProdutosOrdenados(Model model) {
       model.addAttribute("produtos", produtoService.listarProdutosOrdenados());
       return "listagem";
    }

    @GetMapping("/cadastrar")
    public String mostrarFormulario(Model model) {
        ProdutoDTO dto = new ProdutoDTO(null, "", "", BigDecimal.ZERO, null);
        model.addAttribute("produto", dto);
        model.addAttribute("disponibilidadeOptions", DisponivelParaVenda.values());
        return "formulario";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(@ModelAttribute ProdutoDTO dto) {
        produtoService.cadastrarProduto(dto);
        return "redirect:/api/v1/produtos";
    }
}