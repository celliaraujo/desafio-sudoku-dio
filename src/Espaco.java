import java.util.Objects;

public class Espaco {
    private String coordenada;
    private Integer numeroAtual;
    private Integer numeroEsperado;
    private int status;
    private boolean fixo;

    public Espaco(String coordenada, Integer numeroEsperado, boolean fixo) {
        this.coordenada = coordenada;
        this.numeroEsperado = numeroEsperado;
        this.fixo = fixo;
        if(fixo) this.numeroAtual = this.numeroEsperado;
        else this.numeroAtual = 0;
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public Integer getNumeroAtual() {
        return numeroAtual;
    }

    public Integer getNumeroEsperado() {
        return numeroEsperado;
    }

    public void setNumero(Integer numero) {
        this.numeroAtual = numero;
    }

    public boolean isFixo() {
        return fixo;
    }

    public void setFixo(boolean fixo) {
        this.fixo = fixo;
    }

    @Override
    public String toString() {
        return "Espaco { " +
                "coordenada='" + coordenada + '\'' +
                ", numero=" + numeroAtual +
                ", fixo=" + fixo +
                '}';
    }


}
