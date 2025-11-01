package com.udea.drools_airline.controller;

import com.udea.drools_airline.model.BookingRequest;
import com.udea.drools_airline.model.BookingResponse;
import com.udea.drools_airline.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Endpoint REST para evaluar reservas
    @PostMapping("/api/evaluate")
    public BookingResponse evaluateBooking(
            @Valid @RequestBody BookingRequest request,
            BindingResult result) {

        // Validar errores de entrada
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                    .orElse("Errores de validación");

            BookingResponse errorResponse = new BookingResponse();
            errorResponse.setMessage("Error de validación: " + errorMessage);
            return errorResponse;
        }

        // Evaluar la reserva con el servicio
        return bookingService.evaluateBooking(request);
    }

    // Endpoint de salud para verificar que el servicio está corriendo
    @GetMapping("/health")
    public String health() {
        return "Booking Service is running!";
    }
}