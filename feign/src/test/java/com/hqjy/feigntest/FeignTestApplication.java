package com.hqjy.feigntest;

import com.hqjy.feign.ApiService;
import com.hqjy.feign.FeignApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = FeignApplication.class)
@RunWith(SpringRunner.class)
public class FeignTestApplication {
    @Autowired
    private ApiService apiService;

    @Test
    public void test(){
        try {
            System.out.println(apiService.index());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
