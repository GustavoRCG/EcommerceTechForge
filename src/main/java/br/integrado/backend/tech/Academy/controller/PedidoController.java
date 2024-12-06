package br.integrado.backend.tech.Academy.controller;

import br.integrado.backend.tech.Academy.dto.ClienteRequestDTO;
import br.integrado.backend.tech.Academy.dto.PedidoRequestDTO;
import br.integrado.backend.tech.Academy.model.Cliente;
import br.integrado.backend.tech.Academy.model.Pedido;
import br.integrado.backend.tech.Academy.model.PedidoPK;
import br.integrado.backend.tech.Academy.model.Produto;
import br.integrado.backend.tech.Academy.repository.ClienteRepository;
import br.integrado.backend.tech.Academy.repository.PedidoRepository;
import br.integrado.backend.tech.Academy.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> clientes = this.repository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id) {
        return this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Tipo de prato não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PedidoRequestDTO dto) {

        PedidoPK pedidopk = new PedidoPK();
        pedidopk.setClienteId(dto.getCliente_id());
        pedidopk.setProdutoId(dto.getProduto_id());


            Optional<Cliente> clienteOpt = clienteRepository.findById(dto.getCliente_id());
            Optional<Produto> produtoOpt = produtoRepository.findById(dto.getProduto_id());


            Pedido pedido = new Pedido();
            pedido.setId(pedidopk);
            pedido.setCliente(clienteOpt.get());
            pedido.setProduto(produtoOpt.get());

        Pedido clienteSave = repository.save(pedido);
        return ResponseEntity.ok(clienteSave);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Pedido> enderecoOpt  = repository.findById(id);
        if (enderecoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Endereço não encontrado com o id Fornecido");
        }
        repository.deleteById(id);
        return ResponseEntity.badRequest().body("Endereco deletado com Sucesso!");
    }
}
