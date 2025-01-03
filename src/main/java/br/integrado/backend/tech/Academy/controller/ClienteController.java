package br.integrado.backend.tech.Academy.controller;

import br.integrado.backend.tech.Academy.dto.ClienteRequestDTO;
import br.integrado.backend.tech.Academy.model.Cliente;
import br.integrado.backend.tech.Academy.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;


    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = this.repository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Integer id) {
        return this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Tipo de prato não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClienteRequestDTO dto) {


        Cliente cliente = new Cliente();
        cliente.setId_cliente(dto.getId_cliente());
        cliente.setNome(dto.getNome());
        cliente.setCelular(dto.getCelular());

        Cliente clienteSave = repository.save(cliente);
        return ResponseEntity.ok(clienteSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ClienteRequestDTO dto) {


        Cliente cliente = new Cliente();
        cliente.setId_cliente(dto.getId_cliente());
        cliente.setNome(dto.getNome());
        cliente.setCelular(dto.getCelular());

        Cliente clienteSave = repository.save(cliente);
        return ResponseEntity.ok(clienteSave);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Cliente> enderecoOpt  = repository.findById(id);
        if (enderecoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Endereço não encontrado com o id Fornecido");
        }
        repository.deleteById(id);
        return ResponseEntity.badRequest().body("Endereco deletado com Sucesso!");
    }

}
