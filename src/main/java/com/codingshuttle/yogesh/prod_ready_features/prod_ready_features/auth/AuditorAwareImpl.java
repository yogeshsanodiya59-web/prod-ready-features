package com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class  AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor(){

//    get security context
//    get the authetication
//        get the princeiple
//        get the username

        return Optional.of("Yogesh Sanodiya");

    }
}
