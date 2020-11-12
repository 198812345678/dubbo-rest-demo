package com.example.will.demo;

import java.util.Map;
import javax.annotation.Resource;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Request;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@DubboService(interfaceClass = UserService.class, protocol = {"dubbo", "rest"})
@Component
@Path("/users")
public class UserServiceImpl implements UserService{

    @GET
    @Path("/registerget/{id}")
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({ContentType.APPLICATION_JSON_UTF_8})
    @Override
    public String registerget(@PathParam("id")Long id) {
//        return "succ";
        System.out.println("method inner do something");
        return id.toString();
        // save the user...
    }

    @POST
    @Path("/register")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public String registerUser(@FormParam("user")User user) {
//        return "succ";
        return user.toString();
        // save the user...
    }

    @POST
    @Path("/test")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({ContentType.APPLICATION_JSON_UTF_8})
    public BaseResponse<Doc2> test(Doc2 doc2) {
        return BaseResponse.buildResp(doc2);
    }

    /**
     * @FormParam 这种形式的对象要有static的valueOf方法，因为框架不知道传过来的是不是json
     * @param user
     * @param doc
     * @return
     */
    @POST
    @Path("/test2")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Override
    public String test2(@FormParam("user")User user, @FormParam("doc")Doc doc) {
        Request request = (Request)RpcContext.getContext().getRequest();
        Map<String, Cookie> cookies = (Map<String, Cookie>)RpcContext.getContext().get("cookies");
        return user.toString() + doc.toString();
    }
}
