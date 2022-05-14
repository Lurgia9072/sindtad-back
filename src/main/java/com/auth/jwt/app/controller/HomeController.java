package com.auth.jwt.app.controller;

import com.auth.jwt.app.entity.Entidad;
import com.auth.jwt.app.entity.TipoContribuyente;
import com.auth.jwt.app.entity.TipoDocumento;
import com.auth.jwt.app.payload.AutenticacionLogin;
import com.auth.jwt.app.payload.AutenticacionResponse;
import com.auth.jwt.app.security.service.MiUserDetailsService;
import com.auth.jwt.app.security.utils.JwtUtil;
import com.auth.jwt.app.service.IEntidadService;
import com.auth.jwt.app.service.ITipoContribuyente;
import com.auth.jwt.app.service.ITipoDocumento;
import com.auth.jwt.app.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    /* ~ Autowired
    ------------------------------------------------------------------------------- */
    @Autowired
    private ITipoDocumento tipoDocumento;
    @Autowired
    private ITipoContribuyente tipoContribuyente;
    @Autowired
    private IEntidadService entidadService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private MiUserDetailsService miUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


    /* ~ Rutas publicas
    ------------------------------------------------------------------------------- */
    @GetMapping("/public")
    public String homePublic(){
        return "Pagina de inicio al publico";
    } // fin de la peticion

    @PostMapping("/registrarse")
    public ResponseEntity<?> registrarse(@RequestBody Entidad entidad){
        entidad.setNro_documento(passwordEncoder.encode(entidad.getNro_documento()));

        // Asignar tipo de documento
        TipoDocumento tipoDocumento1 = tipoDocumento.buscarTipoDocumentoId(3);
        entidad.agregarTipoDocumentoALista(tipoDocumento1);
        entidad.getEstado();
        entidadService.guardarEntidad(entidad);
        // asignar el tipo de contribuyente

        TipoContribuyente tipoContribuyente1 = tipoContribuyente.buscarTipoContribuyenteId(3);
        entidad.agregartipoContribuyenteALista(tipoContribuyente1);
        entidad.getEstado();
        entidadService.guardarEntidad(entidad);

        return ResponseEntity.ok("Entidad registrado correctamente");
    }

    @PostMapping("/iniciar")
    public ResponseEntity<?> iniciarSesion(@RequestBody AutenticacionLogin autLogin) throws Exception{

        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(autLogin.getNombreComercial(), autLogin.getNroDocumento())
            );

        }catch (BadCredentialsException ex){
            throw new Exception("Error en el username o contraseña " + ex.getMessage());
        }
        final UserDetails userDetails = miUserDetailsService.loadUserByUsername(autLogin.getNombreComercial());
        final String token = jwtUtil.creatToken(userDetails);

        return ResponseEntity.ok(new AutenticacionResponse(token));
    }

    @GetMapping("/home")
    public String userAuthenticated(){
        return "Welcome";
    }

}
