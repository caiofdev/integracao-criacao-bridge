package br.com.integracao.bridge;

public final class Parametros {

    private static final Parametros INSTANCE = new Parametros();

    private String usuarioLogado;

    private Parametros() {
    }

    public static Parametros getInstance() {
        return INSTANCE;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}