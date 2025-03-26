package test.prueba.demon3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmacionCorreo {
    private String destinatario;
    private String asunto;
    private String mensaje;
}