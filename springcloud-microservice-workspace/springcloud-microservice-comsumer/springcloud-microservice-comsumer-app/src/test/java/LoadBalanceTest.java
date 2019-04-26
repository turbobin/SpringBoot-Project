import com.ccb.springcloud.comsumer.app.OrderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试负载均衡策略
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class LoadBalanceTest {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void test() {
        String itemServiceId = "springcloud-microservice-item";

        for (int i = 0; i < 50; i++) {
            ServiceInstance serviceInstance = loadBalancerClient.choose(itemServiceId);
            System.out.println("第" + i +"次调用:"
                    + serviceInstance.getHost() +":" + serviceInstance.getPort());
        }
    }
}
