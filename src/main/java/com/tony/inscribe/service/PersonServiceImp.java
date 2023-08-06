package com.tony.inscribe.service;

import com.tony.inscribe.model.Person;
import com.tony.inscribe.model.PersonRegDto;
import com.tony.inscribe.model.UserRole;
import com.tony.inscribe.repository.PersonLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.relation.Role;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements UserDetailsService{


    @Autowired
    private PersonLoginRepo personLoginRepo;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person user = personLoginRepo.findByEmail(username);
        System.out.println(user.toString());

        Set<UserRole> roles = new HashSet<>();

        roles.add(new UserRole(1,"USER"));
        roles.add(new UserRole(2,"ADMIN"));

        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), convertAuthorities(roles));
    }

    private Set<GrantedAuthority> convertAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> authorities=new HashSet<>();
        for (UserRole userRole : userRoles) {
            authorities.add(new SimpleGrantedAuthority(userRole.getName()));
        }
        return authorities;
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities() throws MalformedObjectNameException {//Collection<Role> roles){
        //return
        List<Role> s = new LinkedList<>();
        List<ObjectName> rv = new ArrayList<>();
        rv.add(new ObjectName("role"));
        s.add(new Role("USER",rv));
        return s.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }

    public void save(PersonRegDto registrationDto) {
        Person person = Person.builder()
                .name(registrationDto.getName())
                .email(registrationDto.getEmail())
                .password(registrationDto.getPassword()).build();
        personLoginRepo.save(person);
    }
}
