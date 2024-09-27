package br.com.silvio.streamingkids.service;

public interface IConverteDados {
    /* Genérico T */
    <T> T obterDados(String json, Class<T> classe);
}
