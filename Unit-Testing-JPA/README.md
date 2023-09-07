
## Spring Testing Framework

[ResultActions](): là một phần của Spring MVC Test framework trong Spring Framework, được sử dụng để kiểm tra và xác nhận kết quả của các yêu cầu HTTP trong quá trình kiểm thử (unit testing hoặc integration testing) của ứng dụng web.

- [andExpect](): Được sử dụng để xác nhận các điều kiện về kết quả trả về, chẳng hạn như kiểm tra mã trạng thái HTTP, kiểm tra view đã được render, kiểm tra model attribute, v.v.

- [andDo](): Cho phép bạn thực hiện các hành động bổ sung sau khi yêu cầu đã được xử lý. Thường được sử dụng để ghi log hoặc in ra nội dung trả về để kiểm tra.

- [andReturn](): Trả về kết quả của yêu cầu HTTP dưới dạng MvcResult, cho phép bạn truy cập đầy đủ thông tin về yêu cầu và trả lời để thực hiện các kiểm tra tùy chỉnh.

```java
@WebMvcTest(YourController.class)
public class YourControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testYourController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/your-endpoint"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("your-view"))
            .andExpect(MockMvcResultMatchers.model().attributeExists("yourAttribute"))
            .andDo(MockMvcResultHandlers.print());
    }
}
```
