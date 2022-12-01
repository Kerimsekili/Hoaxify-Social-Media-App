package com.hoaxify.ws.shared;

import com.hoaxify.ws.user.UniqueUsernameValidator;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@AuthenticationPrincipal
public @interface CurrentUser {
}
