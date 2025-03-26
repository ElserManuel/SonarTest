package test.prueba.demon4.service;

import test.prueba.demon4.model.CuentaBancaria;
import test.prueba.demon4.repository.CuentaBancariaRepository;

public class TransferenciaService {

    private final CuentaBancariaRepository cuentaBancariaRepository;

    public TransferenciaService(CuentaBancariaRepository cuentaBancariaRepository) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
    }

    public boolean realizarTransferencia(String cuentaOrigen, String cuentaDestino, double monto) {
        CuentaBancaria origen = cuentaBancariaRepository.encontrarCuentaPorNumero(cuentaOrigen);
        CuentaBancaria destino = cuentaBancariaRepository.encontrarCuentaPorNumero(cuentaDestino);

        if (origen == null || destino == null || monto <= 0 || !origen.retirar(monto)) {
            return false;
        }

        destino.depositar(monto);
        return cuentaBancariaRepository.actualizarCuenta(origen) && cuentaBancariaRepository.actualizarCuenta(destino);
    }
}
