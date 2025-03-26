package test.prueba.demon3.service;

import test.prueba.demon3.model.ConfirmacionCorreo;
import test.prueba.demon3.repository.CorreoRepository;

public class CorreoService {

    private final CorreoRepository correoRepository;

    public CorreoService(CorreoRepository correoRepository) {
        this.correoRepository = correoRepository;
    }

    public boolean enviarConfirmacion(String destinatario) {
        ConfirmacionCorreo correo = new ConfirmacionCorreo(destinatario, "Confirmación de Registro", "Su registro ha sido exitoso.");
        return correoRepository.enviarCorreo(correo);
    }
}
