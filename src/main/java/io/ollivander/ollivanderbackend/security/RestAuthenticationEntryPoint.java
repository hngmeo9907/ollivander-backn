package io.ollivander.ollivanderbackend.security;

import io.ollivander.ollivanderbackend.common.ErrorInfo;
import io.ollivander.ollivanderbackend.utils.HttpPrintErrorHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(RestAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
//        logger.error("Unauthorized error: {}", authException.getMessage());
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");

        int code = HttpServletResponse.SC_UNAUTHORIZED;

        ErrorInfo error = new ErrorInfo(code, authException.getMessage());

        HttpPrintErrorHelper.printError(response, error, code);
    }
}