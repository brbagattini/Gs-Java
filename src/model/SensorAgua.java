package model;

import abstracts.Sensor;
import interfaces.Monitoravel;
import util.NivelRisco;

public class SensorAgua extends Sensor implements Monitoravel {
    private double nivelAgua;

    public SensorAgua(int id, String localizacao) {
        super(id, localizacao);
    }

    public double getNivelAgua() {
        return nivelAgua;
    }

    @Override
    public void registrarMedicao(double valor) {
        this.nivelAgua = valor;
    }

    public NivelRisco calcularNivelRisco() {
        if (nivelAgua >= 100) {
            return NivelRisco.EMERGENCIA;
        } else if (nivelAgua >= 80) {
            return NivelRisco.ALTO;
        } else if (nivelAgua >= 50) {
            return NivelRisco.MODERADO;
        } else {
            return NivelRisco.BAIXO;
        }
    }

    @Override
    public String verificarStatus() {
        return calcularNivelRisco().getDescricao();
    }

    @Override
    public void exibirDados() {
        System.out.println("Sensor de Água ID: " + getId());
        System.out.println("Localização: " + getLocalizacao());
        System.out.println("Nível da água: " + nivelAgua + " cm");
        System.out.println("Status: " + verificarStatus());
    }
}