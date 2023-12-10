package ar.edu.unju.edm;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ar.edu.unju.edm.model.Turista;

import java.util.Collection;
import java.util.List;

public class TuristaDetails implements UserDetails {
    private final Turista turista;

    public TuristaDetails(Turista turista) {
        this.turista = turista;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authority = new SimpleGrantedAuthority(turista.getRol());
        return List.of(authority);
    }

    @Override
    public String getPassword() {
        return turista.getPassword();
    }

    @Override
    public String getUsername() {
        return turista.getNombre();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return turista.isEstado();
    }

    public Turista getTurista() {
        return turista;
    }
}
