package Security;

import Model.Funcionario;
import Repo.FuncionarioRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class FuncionarioSecurityDetails implements UserDetailsService {
    private FuncionarioRepo repo;

    public FuncionarioSecurityDetails(FuncionarioRepo repo) {
        this.repo = repo;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Funcionario f = repo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Usuario n encontrado"));
        return new User(f.getEmail(), f.getSenha(), Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
}
