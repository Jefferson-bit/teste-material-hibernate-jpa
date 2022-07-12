package br.com.zup.edu.alugacarzup.carro;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CarroReservaRequest {

    @JsonProperty("nome_do_cliente")
    @NotBlank(message = "nome do cliente não pode ser vazio")
    private String nomeDoCliente;

    public CarroReservaRequest(){}

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }
}
