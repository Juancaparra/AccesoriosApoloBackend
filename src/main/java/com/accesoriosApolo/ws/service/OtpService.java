package com.accesoriosApolo.ws.service;

import com.accesoriosApolo.ws.Entidades.OtpVerificacion;
import com.accesoriosApolo.ws.repository.OtpVerificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private OtpVerificacionRepository otpRepo;

    @Autowired
    private JavaMailSender mailSender;

    public String generarCodigo() {
        return String.format("%04d", new Random().nextInt(10000));
    }

    public void enviarOtp(String correo) {
        String codigo = generarCodigo();

        OtpVerificacion otp = new OtpVerificacion();
        otp.setCorreo(correo);
        otp.setCodigo(codigo);
        otp.setFechaExpiracion(LocalDateTime.now().plusMinutes(10));

        otpRepo.deleteByCorreo(correo); // elimina códigos anteriores
        otpRepo.save(otp);

        // Enviar por correo
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(correo);
        mensaje.setSubject("Código de Verificación");
        mensaje.setText("Tu código de verificación es: " + codigo);
        mailSender.send(mensaje);
    }

    public boolean verificarOtp(String correo, String codigo) {
        Optional<OtpVerificacion> otp = otpRepo.findByCorreoAndCodigo(correo, codigo);
        return otp.isPresent() && otp.get().getFechaExpiracion().isAfter(LocalDateTime.now());
    }
}
