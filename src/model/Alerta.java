package model;

import interfaces.Notificavel;
import util.NivelRisco;

public class Alerta implements Notificavel {
    private String mensagem;
    private NivelRisco nivel;

    public Alerta(String mensagem, NivelRisco nivel) {
        this.mensagem = mensagem;
        this.nivel = nivel;
    }

    public String getMensagem() {
        return mensagem;
    }

    public NivelRisco getNivel() {
        return nivel;
    }

    @Override
    public void enviarNotificacao() {
        System.out.println("ALERTA [" + nivel.getDescricao() + "]: " + mensagem);
    }

    public void enviarNotificacao(String destinatario) {
        System.out.println("Enviando alerta para " + destinatario);
        System.out.println("ALERTA [" + nivel.getDescricao() + "]: " + mensagem);
    }
}