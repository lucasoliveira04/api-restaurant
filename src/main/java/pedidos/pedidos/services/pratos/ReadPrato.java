package pedidos.pedidos.services.pratos;

import org.springframework.stereotype.Service;

import pedidos.pedidos.model.Prato;
import pedidos.pedidos.repository.PratoRepository;
import pedidos.pedidos.services.MethodReadImplementation;

@Service
public class ReadPrato implements MethodReadImplementation<Prato>{
    private final PratoRepository pratoRepository;

    public ReadPrato(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    @Override
    public Prato read(Long id) {
        return pratoRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Prato not found with id: " + id));
    }
}
