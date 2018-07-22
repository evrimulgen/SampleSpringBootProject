package tr.com.dev.haliYikama.server.authentication;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import tr.com.dev.haliYikama.server.persist.models.User;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        boolean aktifPasif = false;
        if (user.getEntityState() == EnumUtil.EntityState.ACTIVE) {
            aktifPasif = true;
        }
        return new JwtUser(user.getOid(), user.getKullaniciAdi(), user.getePosta(),
                user.getSifre(), mapToGrantedAuthorities(), aktifPasif, Calendar.getInstance().getTime());
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities() {
        List<EnumUtil.YETKI_TYPE> authorities = Arrays.asList(EnumUtil.YETKI_TYPE.values());
        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.name()))
                .collect(Collectors.toList());
    }
}
