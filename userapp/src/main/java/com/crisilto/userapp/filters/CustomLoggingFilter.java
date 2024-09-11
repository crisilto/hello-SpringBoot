package com.crisilto.userapp.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Se inicializa el filtro si es que fuese necesario.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        //Excluimos rutas específicas del registro.
        if (requestURI.startsWith("/h2-console") || requestURI.startsWith("/swagger-ui")) {
            chain.doFilter(request, response); //Continuamos con el siguiente filtro
            return;
        }

        //Registramos la solicitud.
        System.out.println("Request Method: " + httpRequest.getMethod() + ", Request URI: " + requestURI);

        //Continuamos con el siguiente filtro o el controlador.
        chain.doFilter(request, response);

        //Registramos la respuesta.
        System.out.println("Response Status: " + response.getContentType());
    }

    @Override
    public void destroy() {
        //Se destruye el filtro si fuese necesario.
    }
}
