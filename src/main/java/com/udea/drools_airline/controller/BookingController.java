package com.udea.drools_airline.controller;

import com.udea.drools_airline.model.BookingRequest;
import com.udea.drools_airline.model.BookingResponse;
import com.udea.drools_airline.model.Passenger;
import com.udea.drools_airline.model.Flight;
import com.udea.drools_airline.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // ========================================
    // ENDPOINT REST (para Postman)
    // ========================================
    @PostMapping("/api/evaluate")
    @ResponseBody
    public BookingResponse evaluateBookingApi(
            @Valid @RequestBody BookingRequest request,
            BindingResult result) {

        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                    .orElse("Errores de validación");

            return new BookingResponse(false, 0.0, 0.0,
                    "Error de validación: " + errorMessage);
        }

        return bookingService.evaluateBooking(request);
    }

    // ========================================
    // ENDPOINTS WEB (para navegador)
    // ========================================

    // Mostrar formulario de reserva
    @GetMapping("/form")
    public String showBookingForm(Model model) {
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setPassenger(new Passenger());
        bookingRequest.setFlight(new Flight());
        model.addAttribute("bookingRequest", bookingRequest);
        return "booking_form";
    }

    // Procesar solicitud desde el formulario web
    @PostMapping("/evaluate")
    public String evaluateBookingWeb(
            @Valid @ModelAttribute("bookingRequest") BookingRequest bookingRequest,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            // Si hay errores de validación, volver al formulario
            return "booking_form";
        }

        BookingResponse response = bookingService.evaluateBooking(bookingRequest);
        model.addAttribute("bookingResponse", response);
        return "booking_result";
    }

    // Endpoint de salud
    @GetMapping("/health")
    @ResponseBody
    public String health() {
        return "Booking Service is running!";
    }
}