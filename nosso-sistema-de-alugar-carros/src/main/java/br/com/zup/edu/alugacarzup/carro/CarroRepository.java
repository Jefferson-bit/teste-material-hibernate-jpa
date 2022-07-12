package br.com.zup.edu.alugacarzup.carro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Carro> findById(Long id);
}
