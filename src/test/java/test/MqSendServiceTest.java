package test;

import com.wyz.springcloud.service.MqSendService;
import com.wyz.springcloud.service.TaskUtil;
import config.ServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/7/27
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
public class MqSendServiceTest {

    @Autowired
    MqSendService mqSendService;

    @Autowired
    TaskUtil taskUtil;

    @Test
    public void testAnsyc() throws Exception{
        taskUtil.asyncDo();
        System.out.println("结束执行"+System.currentTimeMillis());
    }


    @Test
    public void testSend() {
        mqSendService.send("hello,jjw!");
    }

    @Test
    public void testSend1() {
        mqSendService.sendByFanout("fanout @@@@hello,jjw!");
    }


}