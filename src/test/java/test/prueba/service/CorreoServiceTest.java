package test.prueba.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.prueba.demon3.model.ConfirmacionCorreo;
import test.prueba.demon3.repository.CorreoRepository;
import test.prueba.demon3.service.CorreoService;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

public class CorreoServiceTest {

    @Test
    void testEnvioCorreoConfirmacion() {
        CorreoRepository correoRepository = Mockito.mock(CorreoRepository.class);

        when(correoRepository.enviarCorreo(any(ConfirmacionCorreo.class))).thenReturn(true);

        CorreoService correoService = new CorreoService(correoRepository);

        boolean resultado = correoService.enviarConfirmacion("usuario@example.com");

        assertTrue(resultado);

        if (resultado) {
            System.out.println("¡Correo de confirmación enviado exitosamente a usuario@example.com!");
        }
    }
}
