package pedidos.pedidos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.pedidos.dto.PratoRequest;
import pedidos.pedidos.services.pratos.PratoServices;

@RestController
@RequestMapping("/api/pratos")
public class PratoController {
    private final PratoServices pratoServices;

    public PratoController(PratoServices pratoServices) {
        this.pratoServices = pratoServices;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPrato(@RequestBody PratoRequest request){
        var prato = pratoServices.addPrato(request);
        return ResponseEntity.ok(prato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPrato(@PathVariable Long id){
        var prato = pratoServices.getPrato(id);
        return ResponseEntity.ok(prato);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPratos(){
        var pratos = pratoServices.getAllPratos();
        return ResponseEntity.ok(pratos);
    }
    
}
