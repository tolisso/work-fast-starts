package ru.diasoft.micro.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class HelloServiceTest {

  @Test
  public void funcTest() {
    HelloService helloService = new HelloServiceImpl();
    ResponseEntity<String> invokeRes = helloService.hello("Misha");
    Assert.assertEquals(200, invokeRes.getStatusCodeValue());
    Assert.assertEquals("Hello Misha", invokeRes.getBody() );
  }

}
