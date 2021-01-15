package com.study.springboot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// tomcat-embed-core 에 정의가 되어있다.
/*
스프링 부트는 서버가 아니다.
  톰캣 객체 생성
    포트 설정
    톰캣에 컨텍스트 추가
    서블릿 만들기
    톰캣에 서블릿 추가
    컨텍스트에 서블릿 맵핑
    톰캣 실행 및 대기
    
 이 모든 과정을 보다 상세히 또 유연하고 설정하고 실행해주는게 바로 스프링 부트의 자동 설정.
    ServletWebServerFactoryAutoConfiguration (서블릿 웹 서버 생성)
      TomcatServletWebServerFactoryCustomizer (서버 커스터마이징)
    DispatcherServletAutoConfiguration
      서블릿 만들고 등록
 * */
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws LifecycleException {

		//스프링 부트를 사용하지 않고 컨테이너 띄우기
		// ServletWebServerFactoryAutoConfiguration 에서 자동으로 container 를 설정하게 되어있다.
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);

		Context context = tomcat.addContext("/", "/");

		HttpServlet servlet = new HttpServlet() {
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
				PrintWriter write = resp.getWriter();
				write.println("<html><head><title>");
				write.println("hey tomcat");
				write.println("</title></head>");
				write.println("<body><h2> hello tomcat");
				write.println("</h2></body>");
				write.println("</html>");
			}

		};
		String servletName = "helloServlet";
		tomcat.addServlet("/", servletName, servlet);
		context.addServletMappingDecoded("/hello", servletName);
		
		tomcat.start();
		tomcat.getServer().await();
	}
}
