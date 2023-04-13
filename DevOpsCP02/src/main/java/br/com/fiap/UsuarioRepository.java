package br.com.fiap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM USUARIO WHERE EMAIL LIKE %?1%", nativeQuery = true)
    public Optional<Usuario> findByEmail(String email);
}
