package service;

import abstracts.Sensor;
import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {
    private List<Sensor> sensores;

    public SistemaMonitoramento() {
        sensores = new ArrayList<>();
    }

    public void adicionarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public void listarSensores() {
        if (sensores.isEmpty()) {
            System.out.println("Nenhum sensor cadastrado.");
            return;
        }

        for (Sensor sensor : sensores) {
            sensor.exibirDados();
            System.out.println("----------------------");
        }
    }

    public Sensor buscarSensorPorId(int id) {
        for (Sensor sensor : sensores) {
            if (sensor.getId() == id) {
                return sensor;
            }
        }
        return null;
    }
}