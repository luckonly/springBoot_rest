package ru.netology.springboot_rest.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.springboot_rest.model.User;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
       resolvers.add(new MyHandlerMethodArgumentResolver());
    }

    private class MyHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

        @Override
        public boolean supportsParameter(MethodParameter methodParameter) {
            return methodParameter.hasMethodAnnotation(CustomUserAnnotation.class);
        }

        @Override
        public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
            String name = nativeWebRequest.getParameter("name");
            String password = nativeWebRequest.getParameter("password");
            User user = new User(name, password);

            WebDataBinder dataBinder = webDataBinderFactory.createBinder(nativeWebRequest, user, "user");
            dataBinder.validate();
            if(dataBinder.getBindingResult().hasErrors()) {
                throw new RuntimeException(dataBinder.getBindingResult().getAllErrors().stream().map(e-> e.toString()).collect(Collectors.joining()));
            }

            return user;
        }
    }

}
