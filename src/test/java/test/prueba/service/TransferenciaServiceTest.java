package test.prueba.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.prueba.demon4.model.CuentaBancaria;
import test.prueba.demon4.repository.CuentaBancariaRepository;
import test.prueba.demon4.service.TransferenciaService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TransferenciaServiceTest {

    @Test
    void testTransferenciaExitosa() {
        CuentaBancariaRepository repository = Mockito.mock(CuentaBancariaRepository.class);

        CuentaBancaria origen = new CuentaBancaria("123", "Juan Pérez", 500);
        CuentaBancaria destino = new CuentaBancaria("456", "Ana Gómez", 200);

        when(repository.encontrarCuentaPorNumero("123")).thenReturn(origen);
        when(repository.encontrarCuentaPorNumero("456")).thenReturn(destino);

        when(repository.actualizarCuenta(any(CuentaBancaria.class))).thenReturn(true);

        TransferenciaService servicio = new TransferenciaService(repository);

        boolean resultado = servicio.realizarTransferencia("123", "456", 100);

        assertTrue(resultado);
        assertEquals(400, origen.getSaldo());
        assertEquals(300, destino.getSaldo());

        if (resultado) {
            System.out.println("Transferencia exitosa: Juan Pérez → Ana Gómez, Monto: 100");
            System.out.println("Nuevo saldo - Juan Pérez: " + origen.getSaldo());
            System.out.println("Nuevo saldo - Ana Gómez: " + destino.getSaldo());
        }
    }

    @Test
    void testTransferenciaFondosInsuficientes() {
        CuentaBancariaRepository repository = Mockito.mock(CuentaBancariaRepository.class);

        CuentaBancaria origen = new CuentaBancaria("123", "Juan Pérez", 50);
        CuentaBancaria destino = new CuentaBancaria("456", "Ana Gómez", 200);

        when(repository.encontrarCuentaPorNumero("123")).thenReturn(origen);
        when(repository.encontrarCuentaPorNumero("456")).thenReturn(destino);

        TransferenciaService servicio = new TransferenciaService(repository);

        boolean resultado = servicio.realizarTransferencia("123", "456", 100);

        assertFalse(resultado);
        assertEquals(50, origen.getSaldo());
        assertEquals(200, destino.getSaldo());

        if (!resultado) {
            System.out.println("Transferencia fallida: Fondos insuficientes en la cuenta de Juan Pérez.");
            System.out.println("Saldo actual - Juan Pérez: " + origen.getSaldo());
            System.out.println("Saldo actual - Ana Gómez: " + destino.getSaldo());
        }
    }
}
