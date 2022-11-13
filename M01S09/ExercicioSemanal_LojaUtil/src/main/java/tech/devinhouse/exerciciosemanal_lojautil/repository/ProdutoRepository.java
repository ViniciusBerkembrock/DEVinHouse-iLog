package tech.devinhouse.exerciciosemanal_lojautil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.exerciciosemanal_lojautil.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    boolean existsByIdNotAndSku(Integer id, String sku);

    boolean existsBySku(String sku);
}
