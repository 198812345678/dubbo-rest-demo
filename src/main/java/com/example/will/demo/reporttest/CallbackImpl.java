package com.example.will.demo.reporttest;

import com.example.will.demo.UserService;
import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;
import org.springframework.stereotype.Component;

@DubboService(interfaceClass = Callback.class, protocol = {"rest"})
@Component
@Path("/report")
public class CallbackImpl implements Callback {

  @POST
  @Path("/callback")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({ContentType.APPLICATION_JSON_UTF_8})
  @Override
  public Response reportCallback(CallbackRequest request) {
    Response response = new Response();
    response.setCode(200);

    System.out.println(new Gson().toJson(request));
    return response;
  }
}
