import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<Espaco> espacos = new ArrayList<>();
        Scanner scan = new Scanner(System.in);



        for(int arg = 0; arg < args.length; arg++){
            String coordenada = args[arg].substring(0,3);
            Integer numero =  Integer.parseInt(args[arg].substring(4,5));
            boolean fixo = Boolean.parseBoolean(args[arg].substring(6));

            Espaco espaco = new Espaco(coordenada, numero, fixo);

            espacos.add(espaco);
        }
        Jogo tabuleiro = new Jogo(espacos);


        int opcao = 0;
        System.out.println("""
        ================* JOGO SUDOKU *==============
          Preencha corretamente os espaços vazios!
        =============================================
        """);
        tabuleiro.mostrarJogo();

        do{
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
            System.out.print("O que você deseja fazer: ");
            opcao = scan.nextInt();
            String posX;
            String posY;
            String coordenada;

            switch (opcao){
                case 1:
                    tabuleiro.iniciarJogo();
                    break;
                case 2:
                    System.out.print("Digite a posição horizontal (0 a 8): ");
                    posX = scan.next();
                    System.out.print("Digite a posição vertical (0 a 8): ");
                    posY = scan.next();
                    System.out.print("Digite o número (1 a 9): ");
                    int numero = scan.nextInt();
                    coordenada = posX + "," + posY;
                    tabuleiro.inserirNumero(coordenada, numero);
                    break;
                case 3:
                    System.out.print("Digite a posição horizontal (0 a 8): ");
                    posX = scan.next();
                    System.out.print("Digite a posição vertical (0 a 8): ");
                    posY = scan.next();
                    coordenada = posX + "," + posY;
                    tabuleiro.removerNumero(coordenada);
                    break;
                case 4:
                    tabuleiro.mostrarJogo();
                    break;
                case 5:
                    tabuleiro.verificarStatusJogo();
                    break;
                case 6:
                    tabuleiro.recomecarJogo();
                    break;
                case 7:
                    tabuleiro.finalizarJogo();
                case 8:
                    System.out.println("Aplicação está sendo encerrada...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }



        }while (opcao != 8);

    }
}
