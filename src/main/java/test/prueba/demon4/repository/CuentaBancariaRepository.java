package test.prueba.demon4.repository;

import test.prueba.demon4.model.CuentaBancaria;

public interface CuentaBancariaRepository {
    CuentaBancaria encontrarCuentaPorNumero(String numeroCuenta);
    boolean actualizarCuenta(CuentaBancaria cuenta);
}
