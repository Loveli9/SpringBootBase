package com.hou.mybatis.domain.VO;

import java.util.List;

/**
 * 分页返回数据封装Bean
 */
public class PageBean<T> {   //指定数据泛型

    private Integer currentPage;  //当前页
    private Integer pageSize;   //每页显示条数
    private Integer totalNum;   //总条数
    private Integer totalPage;  //总页数
    private Integer startIndex;   //开始数据的索引
    private Boolean isMore;   //是否有下一页
    private List<T> items;  //分页数据

    public PageBean() {
    }
    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        //java两个整数除法运算会向下取整,所以需要多算一页条数,再减一
        this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        //或者直接使用Math.ceil(this.totalNum/this.pageSize); 向上取整,需要强转
        this.startIndex = (this.currentPage-1)*this.pageSize; //从上一页的最后一条数据开始索引,即limit的开始参数
        this.isMore = this.currentPage>=this.totalPage?false:true;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Boolean getMore() {
        return isMore;
    }

    public void setMore(Boolean more) {
        isMore = more;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
