package com.wishlist;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wishlist.controller.ProductController;
import com.wishlist.controller.WishlistItemController;
import com.wishlist.model.Item;
import com.wishlist.model.Product;
import com.wishlist.service.ItemService;
import com.wishlist.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { ProductController.class, WishlistItemController.class })
public class WishlistDataServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@MockBean
	private ItemService itemService;

	List<Product> mockProducts = new ArrayList<>();
	List<Item> mockItems = new ArrayList<>();

	@Before
	public void setup() {
		Product product1 = new Product(1001, "Sony Heaphone", "Headphone", "with Extra Bass", 1500d);
		Product product2 = new Product(1002, "Xiomi TV", "Television", "42 iches HD Ready", 14999d);
		mockProducts.add(product1);
		mockProducts.add(product2);
		
		Item mockItem1 = new Item(101, "Shoes", 1000d, "http://dummy/helloShoes.jpg", "Puma Shoes");
		Item mockItem2 = new Item(102, "Mobile", 19000d, "http://dummy/demooMobile.jpg", "Nokia 7.1");
		mockItems.add(mockItem1);
		mockItems.add(mockItem2);
	}

	@Test
	public void testProducts() throws Exception {
		Mockito.when(productService.getProducts()).thenReturn(mockProducts);
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/products").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());
		Mockito.verify(productService).getProducts();
	}
	
	@Test
	public void testProducts_null() throws Exception {
		mockProducts = null;
		Mockito.when(productService.getProducts()).thenReturn(mockProducts);
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/products").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println("Response of testProducts_null: "+mvcResult);
		assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void testProducts_empty() throws Exception {
		mockProducts = new ArrayList<>();
		Mockito.when(productService.getProducts()).thenReturn(mockProducts);
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/products").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println("Response of testProducts_null: "+mvcResult);
		assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void testFetchWishlistItems() throws Exception {
		Mockito.when(itemService.fetchWishlistItems()).thenReturn(mockItems);
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/data/items").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());
		Mockito.verify(itemService).fetchWishlistItems();
	}
	
	@Test
	public void testFetchWishlistItems_null() throws Exception {
		mockItems = null;
		Mockito.when(itemService.fetchWishlistItems()).thenReturn(mockItems);
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/data/items").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println("Response of testProducts_null: "+mvcResult);
		assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void testFetchWishlistItems_empty() throws Exception {
		mockItems = new ArrayList<>();
		Mockito.when(itemService.fetchWishlistItems()).thenReturn(mockItems);
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/data/items").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println("Response of testProducts_null: "+mvcResult);
		assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void testSaveItem() throws Exception{
		String prodId = "102";
		Item mockItem1 = new Item(102, "Shoes", 1000d, "http://dummy/helloShoes.jpg", "Puma Shoes");
		Mockito.when(itemService.saveItemToWishlist(Mockito.any(String.class))).thenReturn(mockItem1);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/data/add/item").content(prodId)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());

		String outputJson = mvcResult.getResponse().getContentAsString();
		Map<String, Object> resultAsObject = asJavaObject(outputJson);
		assertEquals(102, resultAsObject.get("id"));
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void testSaveItem_null() throws Exception {
		String prodId = "102";
		Item mockItem1 = null;
		Mockito.when(itemService.saveItemToWishlist(Mockito.any(String.class))).thenReturn(mockItem1);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/data/add/item").content(prodId)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		String outputJson = mvcResult.getResponse().getContentAsString();
		System.out.println("------> "+outputJson);
		assertEquals(HttpStatus.NOT_MODIFIED.value(), mvcResult.getResponse().getStatus());
	}
	
	
	@Test
	public void testDeleteItem() throws Exception{
		Integer prodId = 102;
		Item mockItem1 = new Item(102, "Shoes", 1000d, "http://dummy/helloShoes.jpg", "Puma Shoes");
		Mockito.when(itemService.deleteItemFromWishlist(Mockito.any(Integer.class))).thenReturn(mockItem1);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/data/delete/item").content(String.valueOf(prodId))
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());

		String outputJson = mvcResult.getResponse().getContentAsString();
		Map<String, Object> resultAsObject = asJavaObject(outputJson);
		assertEquals(102, resultAsObject.get("id"));
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void testDeleteItem_null() throws Exception {
		String prodId = "102";
		Item mockItem1 = null;
		Mockito.when(itemService.deleteItemFromWishlist(Mockito.any(Integer.class))).thenReturn(mockItem1);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/data/delete/item").content(prodId)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		String outputJson = mvcResult.getResponse().getContentAsString();
		System.out.println("------> "+outputJson);
		assertEquals(HttpStatus.NOT_MODIFIED.value(), mvcResult.getResponse().getStatus());
	}
	
	@Ignore
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Ignore
	public static Map<String, Object> asJavaObject(final String jsonString) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			@SuppressWarnings("unchecked")
			final Map<String, Object> objectContent = mapper.readValue(jsonString, Map.class);
			return objectContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
