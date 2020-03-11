package br.calculos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PresuncaoTest {

    private final Presuncao presuncao = new Presuncao();

    @Test
    void calcularTudoZerado() {

        BigDecimal receitaServico = BigDecimal.ZERO;
        BigDecimal receitaVenda = BigDecimal.ZERO;
        BigDecimal deducoes = BigDecimal.ZERO;

        BigDecimal esperado = BigDecimal.ZERO;
        BigDecimal resultado;

        resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);

        assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
    }

    @Test
    void calcularApenasReceitaServico() {

        BigDecimal receitaServico = BigDecimal.valueOf(10000L);
        BigDecimal receitaVenda = BigDecimal.ZERO;
        BigDecimal deducoes = BigDecimal.ZERO;

        BigDecimal esperado = BigDecimal.valueOf(3200);
        BigDecimal resultado;

        resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);

        assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
    }

    @Test
    void calcularReceitaServicoMaiorDeducao() {

        BigDecimal receitaServico = BigDecimal.valueOf(10000L);
        BigDecimal receitaVenda = BigDecimal.ZERO;
        BigDecimal deducoes = BigDecimal.valueOf(1000L);

        BigDecimal esperado = BigDecimal.valueOf(2200);
        BigDecimal resultado;

        resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);

        assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
    }

    @Test
    void calcularReceitaServicoIgualDeducao() {

        BigDecimal receitaServico = BigDecimal.valueOf(10000L);
        BigDecimal receitaVenda = BigDecimal.ZERO;
        BigDecimal deducoes = BigDecimal.valueOf(10000L);

        BigDecimal esperado = BigDecimal.valueOf(0);
        BigDecimal resultado;

        resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);

        assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
    }

    @Test
    void calcularReceitaServicoMenorDeducao() {

        BigDecimal receitaServico = BigDecimal.valueOf(10000L);
        BigDecimal receitaVenda = BigDecimal.ZERO;
        BigDecimal deducoes = BigDecimal.valueOf(20000L);

        BigDecimal esperado = BigDecimal.valueOf(0);
        BigDecimal resultado;

        resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);

        assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
    }

    @Test
    void calcularApenasReceitaVenda() {

        BigDecimal receitaServico = BigDecimal.ZERO;
        BigDecimal receitaVenda = BigDecimal.valueOf(10000L);
        BigDecimal deducoes = BigDecimal.ZERO;

        BigDecimal esperado = BigDecimal.valueOf(800);
        BigDecimal resultado;

        resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);

        assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
    }

    @Test
    void calcularReceitaVendaMaiorDeducao() {

        BigDecimal receitaServico = BigDecimal.ZERO;
        BigDecimal receitaVenda = BigDecimal.valueOf(10000L);
        BigDecimal deducoes = BigDecimal.valueOf(100L);

        BigDecimal esperado = BigDecimal.valueOf(700);
        BigDecimal resultado;

        resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);

        assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
    }

    @Test
    void calcularReceitaVendaIgualDeducao() {

        BigDecimal receitaServico = BigDecimal.ZERO;
        BigDecimal receitaVenda = BigDecimal.valueOf(10000L);
        BigDecimal deducoes = BigDecimal.valueOf(10000L);

        BigDecimal esperado = BigDecimal.valueOf(0);
        BigDecimal resultado;

        resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);

        assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
    }

    @Test
    void calcularReceitaVendaMenorDeducao() {

        BigDecimal receitaServico = BigDecimal.ZERO;
        BigDecimal receitaVenda = BigDecimal.valueOf(10000L);
        BigDecimal deducoes = BigDecimal.valueOf(20000L);

        BigDecimal esperado = BigDecimal.valueOf(0);
        BigDecimal resultado;

        resultado = presuncao.calcular(receitaServico, receitaVenda, deducoes);

        assertTrue(esperado.compareTo(resultado)==0, String.format("Esperado: %s Calculado: %s", esperado.toString(), resultado.toString()));
    }
}