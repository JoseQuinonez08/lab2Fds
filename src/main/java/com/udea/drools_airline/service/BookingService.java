package com.udea.drools_airline.service;

import com.udea.drools_airline.model.BookingRequest;
import com.udea.drools_airline.model.BookingResponse;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private KieContainer kieContainer;

    public BookingResponse evaluateBooking(BookingRequest request) {
        // Crear una respuesta inicial
        BookingResponse response = new BookingResponse();
        response.setPassengerName(request.getPassenger().getName());
        response.setFlightNumber(request.getFlight().getFlightNumber());

        // Crear una sesión de Drools
        KieSession kieSession = kieContainer.newKieSession();

        try {
            // Insertar los hechos (request y response) en la sesión
            kieSession.insert(request);
            kieSession.insert(response);

            // Ejecutar todas las reglas
            kieSession.fireAllRules();

        } finally {
            // Liberar la sesión
            kieSession.dispose();
        }

        return response;
    }
}