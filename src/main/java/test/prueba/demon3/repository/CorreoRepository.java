package test.prueba.demon3.repository;

import test.prueba.demon3.model.ConfirmacionCorreo;

public interface CorreoRepository {
    boolean enviarCorreo(ConfirmacionCorreo correo);
}