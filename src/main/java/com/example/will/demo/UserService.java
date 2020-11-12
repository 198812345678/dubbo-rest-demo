package com.example.will.demo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;

public interface UserService {
    String registerget(Long id);

    String registerUser(User user);

    BaseResponse<Doc2> test(Doc2 doc2);

    String test2(User user, Doc doc);


}
