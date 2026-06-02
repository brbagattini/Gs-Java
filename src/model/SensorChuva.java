package model;

import abstracts.Sensor;
import interfaces.Monitoravel;
import util.NivelRisco;

public class SensorChuva extends Sensor implements Monitoravel {
    private double volumeChuva;

    public SensorChuva(int id, String localizacao) {
        super(id, localizacao);
    }

    public double getVolumeChuva() {
        return volumeChuva;
    }

    @Override
    public void registrarMedicao(double valor) {
        this.volumeChuva = valor;
    }

    public NivelRisco calcularNivelRisco() {
        if (volumeChuva >= 120) {
            return NivelRisco.EMERGENCIA;
        } else if (volumeChuva >= 100) {
            return NivelRisco.ALTO;
        } else if (volumeChuva >= 50) {
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
        System.out.println("Sensor de Chuva ID: " + getId());
        System.out.println("Localização: " + getLocalizacao());
        System.out.println("Volume de chuva: " + volumeChuva + " mm");
        System.out.println("Status: " + verificarStatus());
    }
}