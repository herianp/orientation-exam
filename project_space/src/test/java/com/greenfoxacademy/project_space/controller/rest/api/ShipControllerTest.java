package com.greenfoxacademy.project_space.controller.rest.api;

import com.greenfoxacademy.project_space.entity.Ship;
import com.greenfoxacademy.project_space.model.ShipDto;
import com.greenfoxacademy.project_space.service.ShipService;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class ShipControllerTest {

    @MockBean
    private ShipService shipService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void warpAtLeast() throws Exception {
        ShipDto ship = new ShipDto();
        ship.setPlanet("Jupiter");
        ship.setId(1L);

        ShipDto ship1 = new ShipDto();
        ship1.setPlanet("Mars");
        ship1.setId(2L);
        when(shipService.warpAtLeast(any())).thenReturn(List.of(ship,ship1));

        mockMvc.perform(get("/ships")
                .param("warpAtLeast", String.valueOf(9)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}