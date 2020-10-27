package com.group.webstorebase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.group.webstorebase.entity.MyUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private MyUserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	MyUser user = this.service.repository.findByUsername(username);
        UserDetails userDetails = null;
        List<GrantedAuthority> grantList = null;
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }        

        if (user.getRoleListNames() != null) {
            grantList = new ArrayList<GrantedAuthority>();
            for (String role : user.getRoleListNames()) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }

            userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    grantList);
        }
        return userDetails;
    }
}
