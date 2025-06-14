package pedidos.pedidos.services.pratos;

import org.springframework.stereotype.Service;
import pedidos.pedidos.dto.PratoResponse;
import pedidos.pedidos.model.Prato;
import pedidos.pedidos.repository.PratoRepository;
import pedidos.pedidos.services.MethodReadAllImplementation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReadAllPratos implements MethodReadAllImplementation<PratoResponse>{
    private final PratoRepository pratoRepository;

    public ReadAllPratos(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    @Override
    public List<PratoResponse> readAll() {
       return pratoRepository.findAll().stream()
               .collect(Collectors.groupingBy(
                       prato -> prato.getNome(),
                       Collectors.collectingAndThen(
                               Collectors.toList(),
                               pratosComMesmoNome -> {
                                   var primeiro = pratosComMesmoNome.get(0);
                                   int estoqueTotal = pratosComMesmoNome.stream()
                                           .map(Prato::getQuantidadeEstoque)
                                           .filter(Objects::nonNull)
                                           .mapToInt(Integer::intValue)
                                           .sum();
                                   return new PratoResponse(
                                           primeiro.getId(),
                                           primeiro.getNome(),
                                           primeiro.getDescricao(),
                                           primeiro.getPreco(),
                                           primeiro.getDataCriacao(),
                                           estoqueTotal
                                   );
                               }
                       )
               ))
               .values().stream()
               .toList();
    }
    
}
