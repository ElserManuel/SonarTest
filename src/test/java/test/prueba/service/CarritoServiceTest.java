package test.prueba.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.prueba.demon2.model.Carrito;
import test.prueba.demon2.repository.CarritoRepository;
import test.prueba.demon2.service.CarritoService;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CarritoServiceTest {

    @Test
    void testCalcularPrecioTotal() {
        CarritoRepository repository = Mockito.mock(CarritoRepository.class);

        List<Carrito> productos = Arrays.asList(
                new Carrito("Producto A", 10.0),
                new Carrito("Producto B", 20.5),
                new Carrito("Producto C", 5.0)
        );

        when(repository.obtenerProductos()).thenReturn(productos);

        CarritoService servicio = new CarritoService(repository);

        double precioTotal = servicio.calcularPrecioTotal();

        assertEquals(35.5, precioTotal, 0.01);

        System.out.println("Cálculo exitoso: Precio total del carrito = $" + precioTotal);
    }

    @Test
    void testCalcularPrecioTotalCarritoVacio() {
        CarritoRepository repository = Mockito.mock(CarritoRepository.class);

        when(repository.obtenerProductos()).thenReturn(List.of());

        CarritoService servicio = new CarritoService(repository);

        double precioTotal = servicio.calcularPrecioTotal();

        assertEquals(0.0, precioTotal, 0.01);

        System.out.println("🛒 El carrito está vacío. Precio total = $" + precioTotal);
    }
}
