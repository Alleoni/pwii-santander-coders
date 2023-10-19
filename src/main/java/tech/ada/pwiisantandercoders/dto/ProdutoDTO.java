package tech.ada.pwiisantandercoders.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private String nome;
    private String codigoBarra;
    private String descricao;
    private BigDecimal preco;
}