package com.rent.rentApp.service;

import com.rent.rentApp.model.Product;
import com.rent.rentApp.util.MsgResponse;

public interface PublishService {
    public MsgResponse publish(Product product);
}
