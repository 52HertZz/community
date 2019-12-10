package com.hnisc.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh141
 * 前端分页显示
 */
@Data
public class PageDTO {
    private List<PostDTO> postDTOS;//问题信息
    private boolean showPrevious;//展示到达上一页按钮
    private boolean showFirstPage;//展示到达第一页按钮
    private boolean showNext;//展示到达下一页按钮
    private boolean showEndPage;//展示到达最后一页按钮
    private Integer page;//当前页码
    private List<Integer> pages = new ArrayList<>();//展示的页码
    private Integer totalPage;//总页数

    public void setPage(Integer totalPage, Integer page) {

        this.totalPage = totalPage;

        this.page = page;

        pages.add(page);

        //页面显示的页码为当前页的左右3个
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            } else if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示到达到达上一页按钮
        if (page == 1) {
            setShowPrevious(false);
        } else {
            setShowPrevious(true);
        }

        //是否展示到达下一页按钮
        if (page == totalPage) {
            setShowNext(false);
        } else {
            setShowNext(true);
        }

        //是否展示到达第一页按钮
        if (pages.contains(1)) {
            setShowFirstPage(false);
        } else {
            setShowFirstPage(true);
        }

        //是否展示到达最后一页按钮
        if (pages.contains(totalPage)) {
            setShowEndPage(false);
        } else {
            setShowEndPage(true);
        }
    }
}
