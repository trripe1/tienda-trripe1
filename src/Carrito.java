import java.util.ArrayList;
import java.util.List;

/**
 * Carrito de la compra.
 */
public class Carrito {

    private static final double IVA = 0.21;

    private final List<Producto> productos = new ArrayList<>();
    private final List<Integer> cantidades = new ArrayList<>();

    public boolean anadir(Producto producto, int cantidad) {
        if (!producto.hayStock(cantidad)) {
            return false;
        }
        producto.retirar(cantidad);
        productos.add(producto);
        cantidades.add(cantidad);
        return true;
    }

    public double subtotal() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio() * cantidades.get(i);
        }
        return total;
    }

    public double totalConIva() {
        return subtotal() * (1 + IVA);
    }

    public double totalConDescuento(double porcentaje) {
        return totalConIva() * (1 - porcentaje / 100);
    }

    public void mostrarTicket() {
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.printf("%-10s x%d %8.2f €%n", p.getNombre(), cantidades.get(i), p.getPrecio() * cantidades.get(i));
        }
        System.out.printf("Subtotal: %.2f €%n", subtotal());
        System.out.printf("Total con IVA: %.2f €%n", totalConIva());
    }
}
