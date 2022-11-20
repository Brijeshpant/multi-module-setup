package com.brij.apis;

import com.brij.dtos.ErrorResponse;
import com.brij.dtos.ProductRequestDTO;
import com.brij.dtos.ProductResponseDTO;
import com.brij.exceptions.ProductException;
import com.brij.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.ByteStreams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    void shouldGetProductDetails() throws Exception {
//        api: GET /api/products/id/1 ==> 200 : ProductResponseDTO
        ProductResponseDTO expected = getProdutDetailsResponseDTO(1, "Iphone12", "Electronics", 60000);

        when(productService.getProduct(1L)).thenReturn(expected);
//        mockMvc.perform(get("/api/products/id/1")).andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.name").value("Iphone12"))
//                .andExpect(jsonPath("$.category").value("Electronics"))
//                .andExpect(jsonPath("$.price").value(60000));
        MvcResult mvcResult = mockMvc.perform(get("/api/products/id/1")).andDo(print()).andExpect(status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ProductResponseDTO productResponseDTO = new ObjectMapper().readValue(contentAsString, ProductResponseDTO.class);
        assertThat(productResponseDTO).isEqualTo(expected);


    }

    @Test
    void shouldFailToGetProductDetailsForGivenId() throws Exception {
//        api: GET /api/products/id/1 ==> 400 : ErrorResponse
        ErrorResponse expected = getErrorResponse("1001", "Product Details not found");
        when(productService.getProduct(1L)).thenThrow(new ProductException("1001", "Product Details not found"));

        MvcResult mvcResult = mockMvc.perform(get("/api/products/id/1")).andDo(print()).andExpect(status().isBadRequest()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ErrorResponse errorResponse = new ObjectMapper().readValue(contentAsString, ErrorResponse.class);
        assertThat(errorResponse).isEqualTo(expected);

    }


    @Test
    void shouldCreateProduct() throws Exception {
//        api: POST /api/products ==> 200 ProductResponseJson
        ProductResponseDTO expected = getProdutDetailsResponseDTO(10, "Iphone10", "Electronics", 58000);
        when(productService.createProduct(any(ProductRequestDTO.class))).thenReturn(expected);

        MvcResult mvcResult = mockMvc.perform(post("/api/products").content("{\n" +
                        "  \"name\": \"Iphone12\",\n" +
                        "  \"category\": \"Electronics\",\n" +
                        "  \"price\": \"60000\"\n" +
                        "}").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ProductResponseDTO productResponseDTO = new ObjectMapper().readValue(contentAsString, ProductResponseDTO.class);
        assertThat(productResponseDTO).isEqualTo(expected);

    }


    @Test
    void shouldFailToCreateProductForDuplicateProduct() throws Exception {
        //     POST   api: /api/products ==> 400 ErrorResponse
        ErrorResponse expected = getErrorResponse("1000", "Product can not be duplicated");
        when(productService.createProduct(any(ProductRequestDTO.class))).thenThrow(new ProductException("1000", "Product can not be duplicated"));
        MvcResult mvcResult = mockMvc.perform(post("/api/products").content("{\n" +
                        "  \"name\": \"Iphone12\",\n" +
                        "  \"category\": \"Electronics\",\n" +
                        "  \"price\": \"60000\"\n" +
                        "}").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ProductResponseDTO productResponseDTO = new ObjectMapper().readValue(contentAsString, ProductResponseDTO.class);
        assertThat(productResponseDTO).isEqualTo(expected);
    }

    @Test
    void shouldFailToCreateProductForInvalidInput() throws Exception {
        //  POST      api: /api/products ==> 400 ErrorResponse

        ErrorResponse expected = getErrorResponse("NotBlank", "Name can not be blank");
        MvcResult mvcResult = mockMvc.perform(post("/api/products").content(
                ByteStreams.toByteArray(this.getClass().getResourceAsStream("/json/requests/createIncorrectRequest.json"))
        ).contentType(MediaType.APPLICATION_JSON)).andReturn();
        ErrorResponse errorResponse = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), ErrorResponse.class);
        assertThat(errorResponse).isEqualTo(expected);
    }

    private ProductResponseDTO getProdutDetailsResponseDTO(int id, String name, String category, int price) {
        ProductResponseDTO expected = new ProductResponseDTO();
        expected.setId(id);
        expected.setName(name);
        expected.setCategory(category);
        expected.setPrice(price);
        return expected;
    }

    private ErrorResponse getErrorResponse(String code, String message) {
        ErrorResponse expected = new ErrorResponse();
        expected.setCode(code);
        expected.setMessage(message);
        return expected;
    }
}
