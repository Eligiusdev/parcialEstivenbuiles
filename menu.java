import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        metodos tienda = new metodos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Ingresar artículo");
            System.out.println("2. Mostrar lista de artículos");
            System.out.println("3. Vender artículo");
            System.out.println("4. Mostrar precio total de los artículos");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            
            while (true) {
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingresa un número.");
                    scanner.nextLine();
                }
            }

            switch (opcion) {
                case 1:
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    double precio;
                    while (true) {
                        try {
                            System.out.print("Precio: ");
                            precio = scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Ingresa un número válido para el precio.");
                            scanner.nextLine();
                        }
                    }
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    tienda.ingresarArticulo(marca, precio, descripcion);
                    break;
                case 2:
                    tienda.mostrarListaArticulos();
                    break;
                case 3:
                    System.out.print("Ingresa el ID del artículo a vender: ");
                    String idVenta = scanner.nextLine();
                    tienda.venderArticulo(idVenta);
                    break;
                case 4:
                    tienda.mostrarPrecioTotal();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}