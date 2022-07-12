package br.com.zup.edu.alugacarzup.carro;

import javax.persistence.*;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private boolean disponivel;

    public Carro(String modelo, Integer ano, String marca) {
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
        this.disponivel=true;
    }

    /**
     * @deprecated construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Carro() {
    }

    public Long getId() {
        return id;
    }
}
