import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Espaco> espacos = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        for (int indiceArgumento = 0; indiceArgumento < args.length; indiceArgumento++) {
            String coordenada = args[indiceArgumento].substring(0, 3);
            int numero = Integer.parseInt(args[indiceArgumento].substring(4, 5));
            boolean fixo = Boolean.parseBoolean(args[indiceArgumento].substring(6));

            espacos.add(new Espaco(coordenada, numero, fixo));
        }

        MenuJogo menu = new MenuJogo(espacos, scan);
        menu.iniciar();
    }
}
