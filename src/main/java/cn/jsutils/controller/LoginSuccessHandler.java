package cn.jsutils.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler, InitializingBean {

  private String defaultTargetUrl;

  private boolean forwardToDestination = false;

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    if (this.forwardToDestination) {
      request.getRequestDispatcher(this.defaultTargetUrl).forward(request, response);
    } else {
      response.sendRedirect(this.defaultTargetUrl); // -> /
      // this.redirectStrategy.sendRedirect(request, response, this.defaultTargetUrl); // -> /lunio
    }
  }

  public void setDefaultTargetUrl(String defaultTargetUrl) {
    this.defaultTargetUrl = defaultTargetUrl;
  }

  public void setForwardToDestination(boolean forwardToDestination) {
    this.forwardToDestination = forwardToDestination;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    if (StringUtils.isEmpty(defaultTargetUrl))
      throw new Exception("You must configure defaultTargetUrl");
  }

}
