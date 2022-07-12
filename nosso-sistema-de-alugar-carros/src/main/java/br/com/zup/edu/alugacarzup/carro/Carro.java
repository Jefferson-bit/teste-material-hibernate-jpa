package br.com.zup.edu.alugacarzup.carro;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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

    private String nomeDoCliente;

    public Carro(String modelo, Integer ano, String marca) {
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public void validaReserva(boolean disponivel) {
        if (disponivel) this.disponivel = false;
        else throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Carro já foi reservadi");
    }
}
