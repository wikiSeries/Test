package Controller;

import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import Application.Configuration.WebConfig;
import Application.Model.Image;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class HomeControllerTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
	    DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
	    this.mockMvc = builder.build();
	}
	
	@Test
	public void testMyMvcController() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		
		List<Image> images = new ArrayList<Image>();
		for(int i = 1; i < 3; i++) {
			images.add(new Image("../../img/" + i + ".jpg", "imagen " + i, "esta es la imagen " + i));
		}
		
		ResultMatcher model = MockMvcResultMatchers.model().attribute("images", any(List.class));
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
		this.mockMvc.perform(builder).andExpect(ok).andExpect(model);
	}
}
