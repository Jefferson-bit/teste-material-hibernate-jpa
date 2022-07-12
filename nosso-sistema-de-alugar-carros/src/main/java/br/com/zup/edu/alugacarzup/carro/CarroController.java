package br.com.zup.edu.alugacarzup.carro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/carros")
public class CarroController {

    private final CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @PatchMapping(value = "/{id}/reservas")
    @Transactional
    public ResponseEntity<?> atualizaNomeDoCliente(@PathVariable Long id, @RequestBody CarroReservaRequest request) {

        Carro carro = carroRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "id não encontrado"));

        carro.validaReserva(carro.isDisponivel());
        carro.setNomeDoCliente(request.getNomeDoCliente());
        carroRepository.save(carro);

        return ResponseEntity.noContent().build();
    }
}
