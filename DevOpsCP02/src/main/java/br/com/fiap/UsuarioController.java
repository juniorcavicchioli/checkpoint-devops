package br.com.fiap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    private Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario not found"));
    }

    @PostMapping
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("{id}")
    public Usuario browseUsuario(@PathVariable Long id) {
        return getUsuario(id);
    }

    @GetMapping
    public Iterable<Usuario> listUsuarios() {
        return usuarioRepository.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id){
        var fundedUsuario = getUsuario(id);
        usuarioRepository.delete(fundedUsuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        getUsuario(id);
        usuario.setId(id);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    //login capenga
    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<Usuario> login(@PathVariable String email, @PathVariable String password) {
        var usuarioEncontrado = usuarioRepository.findByEmail(email);
        if (!usuarioEncontrado.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if (usuarioEncontrado.get().getPassword().equals(password))
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioEncontrado.get());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}