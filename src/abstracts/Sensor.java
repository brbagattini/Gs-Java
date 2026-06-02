package abstracts;

public abstract class Sensor {
    private int id;
    private String localizacao;
    private boolean ativo;

    public Sensor(int id, String localizacao) {
        this.id = id;
        this.localizacao = localizacao;
        this.ativo = true;
    }

    public int getId() {
        return id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public abstract void exibirDados();
}