package br.calculos;

import java.math.BigDecimal;

public class Presuncao {

    private final BigDecimal PERCENTUAL_SERVICO = new BigDecimal("0.32");
    private final BigDecimal PERCENTUAL_VENDA = new BigDecimal("0.08");

    public BigDecimal calcular(BigDecimal receitaServico, BigDecimal receitaVenda, BigDecimal deducoes) {
        if(receitaServico == null || receitaVenda == null || deducoes == null) {
            return BigDecimal.ZERO;
        }

        if(receitaServico.signum() == -1 || receitaVenda.signum() == -1 || deducoes.signum() == -1) {
            return BigDecimal.ZERO;
        }

        BigDecimal receita = (receitaServico.multiply(PERCENTUAL_SERVICO)).add(receitaVenda.multiply(PERCENTUAL_VENDA));
        BigDecimal presuncao = receita.subtract(deducoes);

        if(presuncao.signum() == -1) {
            return BigDecimal.ZERO;
        }

        return presuncao;
    }
}
