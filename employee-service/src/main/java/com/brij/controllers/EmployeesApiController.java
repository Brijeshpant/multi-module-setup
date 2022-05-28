package com.brij.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-28T22:33:33.870+05:30[Asia/Kolkata]")

@Controller
@RequestMapping("${openapi.employee.base-path:}")
public class EmployeesApiController implements EmployeesApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EmployeesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
