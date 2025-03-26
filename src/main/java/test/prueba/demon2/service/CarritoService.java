package test.prueba.demon2.service;

import test.prueba.demon2.model.Carrito;
import test.prueba.demon2.repository.CarritoRepository;
import java.util.List;

public class CarritoService {

    private final CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public double calcularPrecioTotal() {
        List<Carrito> productos = carritoRepository.obtenerProductos();
        return productos.stream().mapToDouble(Carrito::getPrecio).sum();
    }
}
