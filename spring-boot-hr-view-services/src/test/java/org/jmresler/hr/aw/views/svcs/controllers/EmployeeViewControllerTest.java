package org.jmresler.hr.aw.views.svcs.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeViewControllerTest {


    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testVEmployee_getEmployeeView() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        var mvcResult =
                mockMvc.perform(MockMvcRequestBuilders
                                .get(EmployeeViewController.PATH + "/get-employee/" + 1)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(MediaType.APPLICATION_JSON_VALUE)
                                .requestAttr("id-claim", "id-claim"))
                        .andReturn();


    }

    @Test
    public void testVEmployee_getEmployeeViewsByPage() {

    }


}
