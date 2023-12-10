package ar.edu.unju.edm;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@Component
public class Autenticacion implements AuthenticationSuccessHandler {

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        var auths = authentication.getAuthorities();
        for (var x : auths) {
            if (x.getAuthority().equals("ADMIN")) {
                redirectStrategy.sendRedirect(request, response, "/admin");
                return;
            } else if (x.getAuthority().equals("USUARIO")) {
                redirectStrategy.sendRedirect(request, response, "/");
                return;
            }
        }
    }

}
