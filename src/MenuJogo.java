import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuJogo {
    private final Jogo jogoSudoku;
    private final Scanner scan;

    public MenuJogo(List<Espaco> espacos, Scanner scan) {
        this.jogoSudoku = new Jogo(espacos);
        this.scan = scan;
    }

    public void iniciar() {
        int opcao = 0;
        System.out.println("""
        ================* JOGO SUDOKU *==============
          Preencha corretamente os espaços vazios!
        =============================================""");
        jogoSudoku.mostrarJogo();

        do {
            exibirOpcoes();
            System.out.print("O que você deseja fazer: ");

            try {
                opcao = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scan.next();
                continue;
            }

            executarOpcao(opcao);

        } while (opcao != 8);
    }

    private void exibirOpcoes() {
        System.out.println("""
            =============================================
            [1] Iniciar um novo o jogo
            [2] Inserir um novo número
            [3] Remover um número
            [4] Mostrar o jogo
            [5] Verificar status do jogo
            [6] Limpar o jogo
            [7] Finalizar o jogo
            [8] Desistir do jogo
            =============================================""");
    }

    private void executarOpcao(int opcao) {
        String coordenada;

        switch (opcao) {
            case 1 -> jogoSudoku.iniciarJogo();
            case 2 -> {
                coordenada = lerCoordenada();
                System.out.print("Digite o número (1 a 9): ");
                int numero = scan.nextInt();
                jogoSudoku.inserirNumero(coordenada, numero);
            }
            case 3 -> {
                coordenada = lerCoordenada();
                jogoSudoku.removerNumero(coordenada);
            }
            case 4 -> jogoSudoku.mostrarJogo();
            case 5 -> jogoSudoku.verificarStatusJogo();
            case 6 -> jogoSudoku.recomecarJogo();
            case 7 -> opcao = jogoSudoku.finalizarJogo();
            case 8 -> System.out.println("Aplicação está sendo encerrada...");
            case 9 -> jogoSudoku.testePreencherJogo();
            default -> System.out.println("Opção inválida!");
        }
    }

    private String lerCoordenada() {
        System.out.print("Digite a posição horizontal (0 a 8): ");
        String posX = scan.next();
        System.out.print("Digite a posição vertical (0 a 8): ");
        String posY = scan.next();
        return posX + "," + posY;
    }
}
