package br.com.esig.sistematarefas.models;

public enum Prioridade {
	
	BAIXA("Baixa"),
	MEDIA("Média"),
	ALTA("Alta");

    private String label;

    private Prioridade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
