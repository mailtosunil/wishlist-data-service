package com.wishlist;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.wishlist.controller.ProductController;
import com.wishlist.controller.WishlistItemController;
import com.wishlist.model.Product;
import com.wishlist.service.ItemService;
import com.wishlist.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value= {ProductController.class, WishlistItemController.class})
public class WishlistDataServiceApplicationTests {

	@Autowired
	private ProductController productController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	@MockBean
	private ItemService itemService;
	
	List<Product> mockProducts = new ArrayList<>();
	
	@Before
	public void setup() {
		Product product1 = new Product(1001,"Sony Heaphone", "Headphone", "with Extra Bass", 1500d);
		Product product2 = new Product(1002,"Xiomi TV", "Television", "42 iches HD Ready", 14999d);
		mockProducts.add(product1);
		mockProducts.add(product2);
	}
	
	@Test
	public void testProducts() throws Exception{
		when(productService.getProducts()).thenReturn(mockProducts);
		ResultActions results = mockMvc.perform(get("/products").accept(MediaType.APPLICATION_JSON));
		
		results.andExpect(status().isOk())
		.andExpect(jsonPath("/products").value(mockProducts));
	}
	/*
	List<Item> items = new ArrayList<>();
	List<Product> products = new ArrayList<>();
	@Autowired
	MockMvc mockMvc;
	@MockBean
	ProductService productService;
	@MockBean
	ItemService itemService;
	@Before
	public void setup() {
		Item mockItem1 = new Item(101, "Shoes", 1000d, "http://dummy/helloShoes.jpg", "Puma Shoes");
		Item mockItem2 = new Item(102, "Mobile", 19000d, "http://dummy/demooMobile.jpg", "Nokia 7.1");
		items.add(mockItem1);
		items.add(mockItem2);
		Product product1 =new Product(1001, "Sony Headphone", "Headphone", "In ear type with extra bass", 1500d);
		Product product2 =new Product(1002, "Xiomi Tv", "Television", "Xiomo 42 inches Full HD", 15000d);
		products.add(product1);
		products.add(product2);
	}
	@Test
	public void testFetchWishlistItems() throws Exception {
		Mockito.when(itemService.fetchWishlistItems()).thenReturn(items);
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/data/items").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		System.out.println(mvcResult.getResponse());
		Mockito.verify(itemService).fetchWishlistItems();
	}
	@Test
	public void testProducts() throws Exception {
		Mockito.when(productService.getProducts()).thenReturn(products);
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/wishlist/products").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		System.out.println(mvcResult.getResponse());
		Mockito.verify(productService).getProducts();
	}

	@Test
	public void testDeleteItem() throws Exception {
		Integer itemId = 102;
		Item mockItem1 = new Item(102, "Shoes", 1000d, "http://dummy/helloShoes.jpg", "Puma Shoes");
		Mockito.when(itemService.deleteItemFromWishlist(itemId)).thenReturn(mockItem1);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.delete("/data/item/" + itemId).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		System.out.println(mvcResult.getResponse());
		Mockito.verify(itemService).deleteItemFromWishlist(itemId);
	}

	@Test
	public void testAddItem() throws Exception {
		Mockito.when(itemService.saveItemToWishlist(Mockito.any(String.class))).thenReturn(mockItem1);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/data/add/item").content(inputJson)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());

		String outputJson = mvcResult.getResponse().getContentAsString();
		assertThat(outputJson).isEqualTo(inputJson);
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
*/}

