package com.umc.jaetteoli.domain.web.seller.entity;

import com.umc.jaetteoli.global.config.security.Role;
import lombok.*;
import com.umc.jaetteoli.global.config.BaseEntity;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "merchandisers")
public class Seller extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerIdx;

    @Column(name = "name", nullable = false, length = 75)
    private String name;

    @Column(name = "birthday", nullable = false, length = 45)
    private String birthday;

    @Column(name = "phone", nullable = false, length = 45)
    private String phone;

    @Column(name = "uid", nullable = false, length = 45)
    private String uid;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "first_login", nullable = false)
    @ColumnDefault("1")
    private int firstLogin;

    @Column(name = "menu_register", nullable = false)
    @ColumnDefault("0")
    private int menuRegister;

    @Column(name = "service_check", nullable = false)
    @ColumnDefault("0")
    private int serviceCheck;

    @Column(name = "personal_check", nullable = false)
    @ColumnDefault("0")
    private int personalCheck;

    @Column(name = "sms_check", nullable = false)
    @ColumnDefault("0")
    private int smsCheck;

    @Column(name = "email_check", nullable = false)
    @ColumnDefault("0")
    private int emailCheck;

    @Column(name = "call_check", nullable = false)
    @ColumnDefault("0")
    private int callCheck;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getKey());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return null;
    }
    @Override
    public String getPassword() {
        return null;
    }
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
