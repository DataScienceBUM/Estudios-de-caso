import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PilaDinamica pila = new PilaDinamica();
    private static final AlgoritmoShuntingYard shuntingYard = new AlgoritmoShuntingYard();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== MENÚ - ANÁLISIS DE EXPRESIONES Y PILA ===");
            System.out.println("1. Convertir expresión infija a postfija (Shunting Yard)");
            System.out.println("2. Apilar token (Push)");
            System.out.println("3. Desapilar token (Pop)");
            System.out.println("4. Ver cima de la pila (Peek)");
            System.out.println("5. Mostrar estado de la pila");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Digite un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    convertirExpresion();
                    break;
                case 2:
                    apilarToken();
                    break;
                case 3:
                    desapilarToken();
                    break;
                case 4:
                    verCima();
                    break;
                case 5:
                    pila.view();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción fuera de rango.");
            }
        }
    }

    private static void convertirExpresion() {
        System.out.print("\nIngrese la expresión infija separada por espacios (ej. ( A + B ) * C o 21 + 52): ");
        String expresion = scanner.nextLine();
        if (expresion.trim().isEmpty()) {
            System.out.println("La expresión no puede estar vacía.");
            return;
        }
        String resultado = shuntingYard.AlgoritmoShuntingYard(expresion);
        System.out.println("Expresión en notación postfija: " + resultado);
    }

    private static void apilarToken() {
        System.out.print("Ingrese el token a apilar: ");
        String token = scanner.nextLine();
        pila.push(token);
        System.out.println("Token apilado correctamente.");
    }

    private static void desapilarToken() {
        String valor = pila.pop();
        if (valor == null) {
            System.out.println("La pila está vacía. No se puede desapilar.");
        } else {
            System.out.println("Token desapilado: " + valor);
        }
    }

    private static void verCima() {
        String valor = pila.peek();
        if (valor == null) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Cima de la pila: " + valor);
        }
    }
}
