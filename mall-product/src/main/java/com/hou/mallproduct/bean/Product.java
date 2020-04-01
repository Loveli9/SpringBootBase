package com.hou.mallproduct.bean;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Product {

    private String pid;

    private String pname;

    private String ptype;

    private BigDecimal pprice;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", pprice=" + pprice + "]";
    }

    public Product(String pid, String pname, String ptype, BigDecimal pprice) {
        this.pid = pid;
        this.pname = pname;
        this.ptype = ptype;
        this.pprice = pprice;
    }

    public Product() {
    }
}
