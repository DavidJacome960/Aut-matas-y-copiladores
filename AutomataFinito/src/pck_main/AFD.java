package pck_main;
import java.util.*;

/**
 *
 * @author jd121
 */

public class AFD {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Estados iniciales
        int N = sc.nextInt(); 
        int S = sc.nextInt(); 
        int D = sc.nextInt(); 
        int q0 = sc.nextInt();
        int T = sc.nextInt(); 
        int C = sc.nextInt(); 
        
        Set<Character> alfabeto = new HashSet<>();
        for (int i = 0; i < S; i++) {
            alfabeto.add(sc.next().charAt(0));
        }
        
        Set<Integer> finales = new HashSet<>();
        for (int i = 0; i < T; i++) {
            finales.add(sc.nextInt());
        }
        
        Map<String, Integer> transiciones = new HashMap<>();

        for (int i = 0; i < D; i++) {
            int estadoActual = sc.nextInt();
            char simbolo = sc.next().charAt(0);
            int estadoDestino = sc.nextInt();

            String clave = estadoActual + "," + simbolo;
            transiciones.put(clave, estadoDestino);
        }

        sc.nextLine();
        
        for (int i = 0; i < C; i++) {
            String cadena = sc.nextLine();

            int estadoActual = q0;

            for (int j = 0; j < cadena.length(); j++) {
                char simbolo = cadena.charAt(j);

                String clave = estadoActual + "," + simbolo;

                if (transiciones.containsKey(clave)) {
                    estadoActual = transiciones.get(clave);
                } else {
                    estadoActual = -1;
                    break;
                }
            }

            if (finales.contains(estadoActual)) {
                System.out.println("ACEPTADA");
            } else {
                System.out.println("RECHAZADA");
            }
        }

        sc.close();
    }
}
