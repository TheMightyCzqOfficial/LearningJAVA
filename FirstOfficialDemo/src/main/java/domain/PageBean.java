package domain;

import java.util.List;

/*
分页类
 */
public class PageBean<T> {//通用
    private int totalPage;//总页数
    private int totalCount;//总记录数
    private List<T> list;//展示内容
    private int currentPage;//当前页码
    private int row;//每页显示条数

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", row=" + row +
                '}';
    }
}
