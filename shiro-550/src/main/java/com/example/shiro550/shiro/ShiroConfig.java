package com.example.shiro550.shiro;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.shiro550.shiro.MainRealm;

@Configuration
public class ShiroConfig {
    @Bean
    MainRealm mainRealm() {
        return new MainRealm();
    }

    @Bean
    RememberMeManager cookieRememberMeManager() {
        return (RememberMeManager)new CookieRememberMeManager();
    }

    @Bean
    SecurityManager securityManager(MainRealm mainRealm, RememberMeManager cookieRememberMeManager) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm((Realm)mainRealm);
        manager.setRememberMeManager(cookieRememberMeManager);
        return (SecurityManager)manager;
    }

    @Bean(name = {"shiroFilter"})
    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/hello");
        bean.setUnauthorizedUrl("");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/doLogin", "anon");
        map.put("/test", "anon");
        map.put("/**", "authc");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }
}