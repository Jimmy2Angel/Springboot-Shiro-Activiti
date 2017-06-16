import indi.baojie.demo.Application;
import org.activiti.engine.RuntimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Lollipop on 2017/6/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProcessEngineTest {

    @Autowired
    RuntimeService runtimeService;

    @Test
    public void testActiviti(){
        long count = runtimeService.createProcessInstanceQuery().count();
        System.out.println(count);
    }

}
