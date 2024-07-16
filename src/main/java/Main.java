import java.io.IOException;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException, InterruptedException {

        int[] opcionesValidas = {1, 2, 3, 4, 5, 6};

        Scanner teclado = new Scanner(System.in);

        System.out.println("****CONVERSOR DE MONEDAS***");

        Menu menu = new Menu();
        menu.mostrarMenu();
        int opcionIngresada = teclado.nextInt();

        if(opcionIngresada == 9){
            System.out.println("Gracias por usar el conversor.");
            return;
        }

        if(Arrays.binarySearch(opcionesValidas, opcionIngresada) < 0){
            System.out.println("Opcion inválida. Gracias por usar el conversor.");
            return;
        }


        Double valorConvertir = 0.0;
        System.out.println("Ingrese el valor a convertir: ");
        valorConvertir = teclado.nextDouble();


        ConversorService servicio = new ConversorService();
        servicio.conversor(opcionIngresada, valorConvertir);
    }
}
