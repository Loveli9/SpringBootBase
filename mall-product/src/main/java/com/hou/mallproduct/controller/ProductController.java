package com.hou.mallproduct.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import com.hou.mallproduct.bean.Product;
import com.hou.mallproduct.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductMapper mapper;

    @PostMapping("/add")
    public Object add(Product product) {
        Integer add = mapper.add(product);
        return null;
    }

    @DeleteMapping("/delete/{pid}")
    public Integer delete(@PathParam("pid") String pid) {
        return mapper.deleteById(pid);
    }

    @PutMapping("/update")
    public Integer update(Product product) {
        return mapper.update(product);
    }

    @GetMapping("/findById")
    public Product findById(String id) {
        return mapper.selectById(id);
    }

    @GetMapping("/findAll")
    public List<Product> findAll() {
        return mapper.selectByPage();
    }

}
