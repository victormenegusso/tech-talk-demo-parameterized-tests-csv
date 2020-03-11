package br.calculos;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PresuncaoCsvTest {

    private final Presuncao presuncao = new Presuncao();

    @ParameterizedTest
    @CsvFileSource(resources = "massa.csv", numLinesToSkip = 1)
    void calcular(ArgumentsAccessor csv) {

        BigDecimal receitaServico = BigDecimal.valueOf(csv.getDouble(0));
        BigDecimal receitaVenda = BigDecimal.valueOf(csv.getDouble(1));
        BigDecimal deducoes = BigDecimal.valueOf(csv.getDouble(2));

        BigDecimal esperado = BigDecimal.valueOf(csv.getDouble(3));
        BigDecimal resultado;

        resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);

        assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
    }

}