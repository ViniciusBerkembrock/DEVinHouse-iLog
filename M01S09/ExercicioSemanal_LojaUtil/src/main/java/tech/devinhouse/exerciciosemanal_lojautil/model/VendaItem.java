package tech.devinhouse.exerciciosemanal_lojautil.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data //From Lombok
      // Responsável pela desverbalização do encapsulamento:
      // Getters & Setters, toString, Hash...
@Entity //From Javax -- Utilizada para informar que uma classe também é uma
// entidade. A partir disso, a JPA estabelecerá a ligação entre a entidade
// e uma tabela de mesmo nome no banco de dados, onde os dados de objetos d
// esse tipo poderão ser persistidos.
@Table(name = "vendaItem") //From Javax -- Utilizando a anotação @Table podemos especificar detalhes
// da tabela que serão utilizados para persistir as nossas entidades na base de dados.
// Caso essa anotação seja omitida, não teremos um erro como resultado,
// porém será utilizado o nome da classe como valor default.
public class VendaItem {

    // A Classe deverá ter como atributo as colunas do SQL

    @Id //From Javax -- Identifica o atributo ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //From Javax
    // Define o método de geração automática do ID
    private Integer id; //id INTEGER PRIMARY KEY AUTO_INCREMENT,

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Venda venda;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private BigDecimal quantidade;

    @Column(nullable = false)
    private BigDecimal valorUnitario;

    @Column(nullable = false)
    private BigDecimal valorTotal;


}
