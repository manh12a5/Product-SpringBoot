package com.codegym.demo.service.appuser;

import com.codegym.demo.model.AppUser;
import com.codegym.demo.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements IAppUserService, UserDetailsService {

    @Autowired
    private IAppUserRepository appUserRepository;

    @Override
    public AppUser findAppUserByName(String name) {
        return appUserRepository.findAppUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.findAppUserByName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(appUser.getRole());
        return new User(appUser.getName(), appUser.getPassword(), authorities);
    }

    @Override
    public AppUser getCurrentUser() {
        AppUser appUser;
        String name;
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (object instanceof UserDetails) {
            name = ((UserDetails) object).getUsername();
        } else {
            name = object.toString();
        }
        appUser = this.findAppUserByName(name);
        return appUser;
    }

    @Override
    public List<AppUser> findAll() {
        return null;
    }

    @Override
    public Page<AppUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public AppUser findById(Long id) {
        return null;
    }

    @Override
    public AppUser save(AppUser appUser) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

}
