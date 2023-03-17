package springFrameworkSpringBoot.S7MockMVC.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import springFrameworkSpringBoot.S7MockMVC.Model.BeerMockMVC;
import springFrameworkSpringBoot.S7MockMVC.services.BeerServiceMockMVC;
import springFrameworkSpringBoot.S7MockMVC.services.BeerServiceMockMVCImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//@SpringBootTest
@WebMvcTest(BeerControllerMockMVC.class)
class BeerControllerMockMVCTest {

    /*@Autowired
    BeerControllerMockMVC beerControllerMockMVC;*/
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    BeerServiceMockMVC beerServiceMockMVC;

    @Captor
    ArgumentCaptor<UUID> uuidArgumentCaptor;

    @Captor
    ArgumentCaptor<BeerMockMVC> beerArgumentCaptor;
    BeerServiceMockMVCImpl beerServiceMockMVCImpl;
    @BeforeEach
    void setUp() {
        beerServiceMockMVCImpl = new BeerServiceMockMVCImpl();
    }

    @Test
    void testPatchBeer() throws Exception {
        BeerMockMVC beer = beerServiceMockMVCImpl.listBeers().get(0);

        Map<String, Object> beerMap = new HashMap<>();
        beerMap.put("beerName", "New Name");

        mockMvc.perform(patch("/api/v1/MockMVC/beer/" + beer.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(beerMap)))
                .andExpect(status().isNoContent());

        verify(beerServiceMockMVC).patchBeerById(uuidArgumentCaptor.capture(), beerArgumentCaptor.capture());

        assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
        assertThat(beerMap.get("beerName")).isEqualTo(beerArgumentCaptor.getValue().getBeerName());
    }

    @Test
    void testDeleteBeer() throws Exception {
        BeerMockMVC beer = beerServiceMockMVCImpl.listBeers().get(0);

        mockMvc.perform(delete("/api/v1/MockMVC/beer/" + beer.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(beerServiceMockMVC).deleteById(uuidArgumentCaptor.capture());

        assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    }

    @Test
    void testUpdateBeer() throws Exception {
        BeerMockMVC beer = beerServiceMockMVCImpl.listBeers().get(0);

        mockMvc.perform(put("/api/v1/MockMVC/beer/" + beer.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(beer)))
                .andExpect(status().isNoContent());

        verify(beerServiceMockMVC).updateBeerById(any(UUID.class), any(BeerMockMVC.class));
    }

    @Test
    void testCreateNewBeer() throws Exception {
        BeerMockMVC beer = beerServiceMockMVCImpl.listBeers().get(0);
        beer.setVersion(null);
        beer.setId(null);

        given(beerServiceMockMVC.saveNewBeer(any(BeerMockMVC.class))).willReturn(beerServiceMockMVCImpl.listBeers().get(1));

        mockMvc.perform(post("/api/v1/MockMVC/beer/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(beer)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }

    @Test
    void testListBeers() throws Exception {

        given(beerServiceMockMVC.listBeers()).willReturn(beerServiceMockMVCImpl.listBeers());
        mockMvc.perform(get("/api/v1/MockMVC/beer/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(3)));
    }

    @Test
    void getBeerById() throws Exception {
        BeerMockMVC testBeer = beerServiceMockMVCImpl.listBeers().get(0);

        given(beerServiceMockMVC.getBeerById(testBeer.getId())).willReturn(testBeer);

        mockMvc.perform(get("/api/v1/MockMVC/beer/" + testBeer.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(testBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName", is(testBeer.getBeerName())));
    }

/*    @Test
    void listBeersMockMVC() throws Exception {
        mockMvc.perform(get("/api/v1/MockMVC/beer/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getBeerByIdMockMVC() throws Exception {
        BeerMockMVC beerMockMVC= beerServiceMockMVCImpl.listBeers().get(0);
        given(beerServiceMockMVC.getBeerById(any(UUID.class))).willReturn(beerMockMVC);

        //System.out.println(beerControllerMockMVC.getBeerByIdMockMVC(UUID.randomUUID()));
        mockMvc.perform(get("/api/v1/MockMVC/beer/" +beerMockMVC.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }*/
}