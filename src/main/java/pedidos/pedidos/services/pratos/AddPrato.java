package pedidos.pedidos.services.pratos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pedidos.pedidos.dto.PratoRequest;
import pedidos.pedidos.model.Prato;
import pedidos.pedidos.repository.PratoRepository;
import pedidos.pedidos.services.MethodAddImplementation;

@Service
public class AddPrato implements MethodAddImplementation<PratoRequest> {

    private final PratoRepository pratoRepository;

    public AddPrato(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    @Override
    public Prato add(PratoRequest item) {
        Prato prato = new Prato(
            item.nome(),
            item.descricao(),
            BigDecimal.valueOf(item.preco()),
            item.quantidadeEstoque()
        );

        return pratoRepository.save(prato);
    }

}
