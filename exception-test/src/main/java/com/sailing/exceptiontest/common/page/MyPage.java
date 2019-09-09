package com.sailing.exceptiontest.common.page;

import java.util.Iterator;
import java.util.List;

/**
 * page分页对象
 *
 * @param <T>
 */
public interface MyPage<T> extends Iterable<T> {

    /**
     * 返回当前页码. 必须为非负数且小于{@code Page#getTotalPages()}
     *
     * @return 返回当前页码
     */
    int getNumber();

    /**
     * 返回每页容量.
     *
     * @return 每页容量
     */
    int getSize();

    /**
     * 返回总页数
     *
     * @return 返回总页数
     */
    int getTotalPages();

    /**
     * 返回当前页元素的总数
     *
     * @return 当前页元素个数
     */
    int getNumberOfElements();

    /**
     * 返回元素总数
     *
     * @return 返回元素总数
     */
    long getTotal();

    /**
     * 判断是否有上一页
     *
     * @return 是否有上一页
     */
    boolean hasPreviousPage();

    /**
     * 是否为第一页
     *
     * @return
     */
    boolean isFirstPage();

    /**
     * 是否有下一页
     *
     * @return 时候有下一页
     */
    boolean hasNextPage();

    /**
     * 判断当前页是否为最后一页
     *
     * @return
     */
    boolean isLastPage();

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Iterable#iterator()
     */
    Iterator<T> iterator();

    /**
     * 将page中的内容以{@code List}返回
     *
     * @return
     */
    List<T> getRows();

    /**
     * 判断当前页中是否有内容
     *
     * @return
     */
    boolean hasContent();

}

