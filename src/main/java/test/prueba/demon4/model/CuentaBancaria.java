package test.prueba.demon4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public boolean retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public void depositar(double monto) {
        saldo += monto;
    }
}