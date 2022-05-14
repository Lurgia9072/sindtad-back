package com.auth.jwt.app.filter;

import com.auth.jwt.app.security.service.MiUserDetailsService;
import com.auth.jwt.app.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Clase que interceptara las peticiones para asegurarse de validar el token del usuario hacia el servidor
 */
@Component
public class AuthFiltroToken extends OncePerRequestFilter {

    @Autowired
    private MiUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String headerAuth = request.getHeader("Authorization");

        String token = null;
        String nombreComercial = null;

        if(headerAuth != null && headerAuth.startsWith("Bearer ")){
            token = headerAuth.substring(7);
            nombreComercial = jwtUtil.extraerUsername(token);
        }

        if (nombreComercial != null && SecurityContextHolder.getContext().getAuthentication() == null){
            // obtenemos el nombre del usuario de nuestra BD y poblamos el UserDetails
            UserDetails userDetails = userDetailsService.loadUserByUsername(nombreComercial);

            // Validamos el token si aun esta vigente y si concuerda con el usuario de la BD
            if (jwtUtil.validarToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken userPassAuthToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // Generamos los detalles de la autenticacion por token
                userPassAuthToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                // y establecemos el tipo de seguridad
                SecurityContextHolder.getContext().setAuthentication(userPassAuthToken);
            } // fin de la validacion del token con los datos de la BD
        }

        filterChain.doFilter(request, response);
    } // fin del metodo de filtradp


} // fin de la clase
