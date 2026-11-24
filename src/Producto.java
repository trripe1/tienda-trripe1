/**
 * Producto de la tienda.
 */
public class Producto {

    private final String nombre;
    private final double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }

    public void retirar(int cantidad) {
        stock -= cantidad;
    }
}
