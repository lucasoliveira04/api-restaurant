package pedidos.pedidos.dto;

public record PratoRequest(
    String nome,
    String descricao,
    Double preco,
    Integer quantidadeEstoque
) {
    
}
