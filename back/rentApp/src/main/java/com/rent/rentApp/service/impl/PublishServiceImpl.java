package com.rent.rentApp.service.impl;
import com.rent.rentApp.mapper.PublishMapper;
import com.rent.rentApp.model.Product;
import com.rent.rentApp.service.PublishService;
import com.rent.rentApp.util.MsgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceImpl implements PublishService {
    @Autowired
    private PublishMapper publishMapper;

    @Override
    public MsgResponse publish(Product product) {
        int result = publishMapper.publish(product);
        System.out.println(result);
        if (result == 1){
            MsgResponse success = MsgResponse.success("发布成功", result);
            return success;
        }else {
            return MsgResponse.err("发布失败");
        }
    }
}
