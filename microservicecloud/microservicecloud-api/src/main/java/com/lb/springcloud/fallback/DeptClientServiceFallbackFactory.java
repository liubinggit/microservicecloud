package com.lb.springcloud.fallback;


import com.lb.springcloud.entities.Dept;
import com.lb.springcloud.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author horay
 * @category Class description
 * @email horay_hyc@qq.com
 * @date 2018/6/12 23:11
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
       return new DeptClientService() {
           @Override
           public boolean add(Dept dept) {
               return false;
           }

           @Override
           public Dept get(Long id) {
               Dept dept = new Dept(id, "dept not found hystrix", "no database found");
               return dept;
           }

           @Override
           public List<Dept> list() {
               return null;
           }
       };
    }
}
