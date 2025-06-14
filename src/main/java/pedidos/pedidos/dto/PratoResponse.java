package pedidos.pedidos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PratoResponse(
    Long id,
    String nome,
    String descricao,
    BigDecimal preco,
    LocalDateTime dataCriacao,
    Integer quantidadeEstoque
) {
    
}
