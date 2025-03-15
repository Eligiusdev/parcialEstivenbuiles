import java.util.ArrayList;
public class metodos {

    private ArrayList<Articulo> estanteria = new ArrayList<>();
    private double totalPrecio = 0;

    public void ingresarArticulo(String marca, double precio, String descripcion) {
        if (estanteria.size() < 10) {
            Articulo nuevoArticulo = new Articulo(marca, precio, descripcion);
            estanteria.add(nuevoArticulo);
            totalPrecio += precio;
            System.out.println("Artículo ingresado exitosamente. ID: " + nuevoArticulo.id);
        } else {
            System.out.println("Estantería llena. No se pueden agregar más artículos.");
        }
    }

    public void mostrarListaArticulos() {
        if (estanteria.isEmpty()) {
            System.out.println("No hay artículos disponibles.");
            return;
        }
        System.out.println("Lista de artículos disponibles:");
        estanteria.forEach(articulo -> System.out.println("ID: " + articulo.id + ", Marca: " + articulo.marca + ", Precio: " + articulo.precio + ", Descripción: " + articulo.descripcion));
    }

  
    public void venderArticulo(String id) {
        for (Articulo articulo : estanteria) {
            if (articulo.id.equals(id)) {
                estanteria.remove(articulo);
                totalPrecio -= articulo.precio;
                System.out.println("Artículo vendido: " + articulo.marca + " (ID: " + articulo.id + ")");
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }

    public void mostrarPrecioTotal() {
        System.out.println("Precio total de los artículos en la estantería: " + totalPrecio);
    }
}
