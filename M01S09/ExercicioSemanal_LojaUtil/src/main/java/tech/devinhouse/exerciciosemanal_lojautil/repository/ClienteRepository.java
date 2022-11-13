package tech.devinhouse.exerciciosemanal_lojautil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.exerciciosemanal_lojautil.model.Cliente;
import tech.devinhouse.exerciciosemanal_lojautil.model.Produto;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    boolean existsByCpfCnpj(String cpfCnpj);

    boolean existsByIdNotAndCpfCnpj(Integer id, String cpfCnpj);
}

