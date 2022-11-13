package tech.devinhouse.exerciciosemanal_lojautil.model;


import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Data //From Lombok
      // Responsável pela desverbalização do encapsulamento:
      // Getters & Setters, toString, Hash...
@Entity //From Javax -- Utilizada para informar que uma classe também é uma
// entidade. A partir disso, a JPA estabelecerá a ligação entre a entidade
// e uma tabela de mesmo nome no banco de dados, onde os dados de objetos d
// esse tipo poderão ser persistidos.
@Table(name = "produto") //From Javax -- Utilizando a anotação @Table podemos especificar detalhes
// da tabela que serão utilizados para persistir as nossas entidades na base de dados.
// Caso essa anotação seja omitida, não teremos um erro como resultado,
// porém será utilizado o nome da classe como valor default.
public class Produto {

    // A Classe deverá ter como atributo as colunas do SQL

    @Id //From Javax -- Identifica o atributo ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //From Javax
    // Define o método de geração automática do ID
    private Integer id; //id INTEGER PRIMARY KEY AUTO_INCREMENT,

    @Column(nullable = false) //From jaxax -- Define o valor como coluna e define como NOT NULL;
    private Boolean ativo = true; //ativo BOOLEAN DEFAULT TRUE,

    @Column(nullable = false, length = 100, unique = true)
    private String sku; //sku VARCHAR(100) UNIQUE,

    @Column(nullable = false, length = 100)
    private String nome; //nome VARCHAR(100) NOT NULL,

    //Não é necessário @Column por não ser NOT NULL e pelo Length ser padrão (255)
    private String descricao; //descricao VARCHAR(255),

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valorUnitario = BigDecimal.ZERO; //valor_unitario DECIMAL (19,2) NOT NULL DEFAULT 0.00
}
