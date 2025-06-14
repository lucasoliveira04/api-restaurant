package pedidos.pedidos.services.pratos;

import java.util.List;

import org.springframework.stereotype.Service;

import pedidos.pedidos.dto.PratoRequest;
import pedidos.pedidos.dto.PratoResponse;
import pedidos.pedidos.model.Prato;

@Service
public class PratoServices {
    private final AddPrato addPrato;
    private final ReadPrato readPrato;
    private final ReadAllPratos readAllPratos;

    public PratoServices(AddPrato addPrato, ReadPrato readPrato, ReadAllPratos readAllPratos) {
        this.addPrato = addPrato;
        this.readPrato = readPrato;
        this.readAllPratos = readAllPratos; 
    }

   public Prato addPrato(PratoRequest request) {
       return addPrato.add(request);
   }

   public Prato getPrato(Long id) {
       return readPrato.read(id);
   }

   public List<PratoResponse> getAllPratos() {
       return readAllPratos.readAll();
   }
}
