package br.calculos;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PresuncaoCsvAssumingThatTest {

    private final PresuncaoComException presuncao = new PresuncaoComException();

    @ParameterizedTest
    @CsvFileSource(resources = "massa_erro.csv", numLinesToSkip = 1)
    void calcular(ArgumentsAccessor csv) {

        BigDecimal receitaServico = csv.getDouble(0) != null ? BigDecimal.valueOf(csv.getDouble(0)) : null;
        BigDecimal receitaVenda = csv.getDouble(1) != null ? BigDecimal.valueOf(csv.getDouble(1)) : null;
        BigDecimal deducoes = csv.getDouble(2) != null ? BigDecimal.valueOf(csv.getDouble(2)) : null;

        BigDecimal esperado = BigDecimal.valueOf(csv.getDouble(3));

        // quando o valor da presunção estiver -1 é porque tem que dar IllegalArgumentException
        assumingThat(esperado.compareTo(BigDecimal.valueOf(-1L)) == 0, () -> {
            assertThrows(IllegalArgumentException.class, () -> presuncao.calcular(receitaServico, receitaVenda, deducoes));
        });

        assumingThat(esperado.compareTo(BigDecimal.valueOf(-1L)) != 0, () -> {
            BigDecimal resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);
            assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
        });
    }

}

// assertThrows(EmptyStackException.class, stack::pop);