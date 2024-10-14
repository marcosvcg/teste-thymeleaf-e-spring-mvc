package com.marcosvcg.qualificacaooaktecnologia.repository;

import com.marcosvcg.qualificacaooaktecnologia.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT p FROM Produto p ORDER BY p.valor ASC")
    List<Produto> ordenarProdutosMenorParaMaiorPeloPreco();
}
