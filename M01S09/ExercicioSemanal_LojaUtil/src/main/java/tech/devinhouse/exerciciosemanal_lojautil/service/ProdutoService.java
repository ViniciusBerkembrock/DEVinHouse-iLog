package tech.devinhouse.exerciciosemanal_lojautil.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.exerciciosemanal_lojautil.model.Produto;
import tech.devinhouse.exerciciosemanal_lojautil.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> buscar() {
        return produtoRepository.findAll();
    }

    public Produto salvar(Produto produto) throws Exception {

        if (produto.getValorUnitario() != null && produto.getValorUnitario().compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("Error: Valor Unitário menor que zero");
        }

        if (produto.getSku() == null || produto.getSku().isEmpty()) {

            throw new Exception("Entrada SKU não fornecida");
        }

        if (produto.getId() != null) {
            if (produtoRepository.existsByIdNotAndSku(produto.getId(), produto.getSku())) {

                throw new Exception("SKU já cadastrado");
            } else {
                if (produtoRepository.existsBySku(produto.getSku())) {

                    throw new Exception("SKU já cadastrado");
                }
            }
        }

        return produtoRepository.save(produto);
    }

    public boolean apagar (Integer id) {

        try {
            produtoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
