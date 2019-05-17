package com.ssm.bean;

import java.util.List;

public class PageBean<T> {
    private int RecordsNumPerPage = 10;//每页记录数
    private int totalRecordsNum;//总记录数
    private int totalPageNum;//总页数
    private int currentPage;//当前页数
    private int prePage;//上一页
    private int nextPage;//下一页
    private int fromRecordNum;//每页开始的记录数
    private List<T> list;

    public int getRecordsNumPerPage() {
        return RecordsNumPerPage;
    }

    public void setRecordsNumPerPage(int recordsNumPerPage) {
        RecordsNumPerPage = recordsNumPerPage;
    }

    public int getTotalRecordsNum() {
        return totalRecordsNum;
    }

    public void setTotalRecordsNum(int totalRecordsNum) {
        this.totalRecordsNum = totalRecordsNum;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getFromRecordNum() {
        return fromRecordNum;
    }

    public void setFromRecordNum(int fromRecordNum) {
        this.fromRecordNum = fromRecordNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
