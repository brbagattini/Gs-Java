package util;

public enum NivelRisco {
    BAIXO("Risco baixo"),
    MODERADO("Risco moderado"),
    ALTO("Risco alto"),
    EMERGENCIA("Situação de emergência");

    private String descricao;

    NivelRisco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}