import java.util.List;

public class Jogo {
    private List<Espaco> espacos;

    public Jogo(List<Espaco> espacos) {
        this.espacos = espacos;
    }

    public void iniciarJogo(){
        int quebraLinha = 0;
        for (Espaco espaco : espacos
             ) {
            if (espaco.isFixo()) System.out.printf("[ %s ]", espaco.getNumeroAtual());
            else System.out.printf("[   ]");
            quebraLinha++;
            if(quebraLinha % 9 == 0) System.out.printf("\n");

        }
    }

    public void mostrarJogo(){
        int quebraLinha = 0;
        for (Espaco espaco : espacos
        ) {
            if(espaco.getNumeroAtual() != 0 ) System.out.printf("[ %s ]", espaco.getNumeroAtual());
            else System.out.printf("[   ]");
            quebraLinha++;
            if(quebraLinha % 9 == 0) System.out.printf("\n");
        }
    }

    public void removerNumero(String coordenada){
        for (Espaco espaco : espacos
        ) {
            if(espaco.getCoordenada().equals(coordenada)){
                if(espaco.isFixo()){
                    System.out.println("Número não pode ser removido!\n");
                    return;
                }
                if(espaco.getNumeroAtual() != 0) espaco.setNumero(0);
                else System.out.println("Não há número para remover neste espaço.");
            }
        }
    }

    public void inserirNumero(String coordenada, Integer numero){
        for (Espaco espaco : espacos
             ) {
            if(espaco.getCoordenada().equals(coordenada)) {
                if (!espaco.isFixo() && espaco.getNumeroAtual() == 0) {
                    espaco.setNumero(numero);
                    System.out.printf("Número %s inserido na posição %s \n", numero, coordenada);
                    break;
                }
                else {
                    System.out.printf("Número na posição %s não pode ser modificado! \n", espaco.getCoordenada());
                }
            }

        }
    }

    public void verificarJogo(){
        int erros = 0;
        for (Espaco espaco : espacos
        ) {
            if (!espaco.isFixo()){
                if (!espaco.getNumeroAtual().equals(espaco.getNumeroEsperado()) && espaco.getNumeroAtual() != 0) {
                    System.out.printf("Fixo = %s - Numero atual = %s - Numero esperado = %s \n", espaco.isFixo(), espaco.getNumeroAtual(), espaco.getNumeroEsperado());
                    erros++;
                }
            }

        }
        if(erros > 0) System.out.printf("Número de erros encontrado no jogo = %s \n", erros);
        else System.out.println("Nenhum erro encontrado!");
    }

    public String verificarStatusJogo(){
        String status = "";
        int respondidos = 0;
        int aresponder = 0;

        for (Espaco espaco : espacos
        ) {
            if(!espaco.isFixo()) {
                if (espaco.getNumeroAtual() == 0) {
                    aresponder++;

                }
                else if (espaco.getNumeroAtual() != 0) {
                    respondidos++;
                }
                //System.out.printf("numero atual == %s   ----   ", espaco.getNumeroAtual());
            }
        }
        status = respondidos == 0 ? "NÃO INICIADO": "INCOMPLETO";
        status = status.equals("INCOMPLETO") && aresponder == 0 ? "COMPLETO" : status;

        System.out.printf("Status atual do jogo: %s \n", status);
        return status;
    }

    public void recomecarJogo(){
        for (Espaco espaco : espacos
        ) {
            if(!espaco.isFixo()){
                espaco.setNumero(0);
            }
        }
        System.out.println("Recomeçando o Jogo...");
        mostrarJogo();
    }

    public void finalizarJogo(){
        int erros = 0;
        for (Espaco espaco : espacos
        ) {
            if(!espaco.isFixo()){
                if(espaco.getNumeroAtual() != espaco.getNumeroEsperado()){
                    erros++;
                }
            }
        }
        if(erros > 0) System.out.printf("O jogo possui erros! Preencha os espaços \ncom os números corretos para finalizar!\n");
        else System.out.println("Parabéns! Jogo concluído!");
    }
}
