package com.sailing.exceptiontest.common.page;

/**
 * 分页参数接口
 *
 */
public interface Pageable {

    /**
     * 待返回的页数
     *
     * @return 待返回的页数
     */
    int getPageNumber();

    /**
     * 待返回的每页容量
     *
     * @return 每页容量
     */
    int getPageSize();

    /**
     * 偏移量
     *
     * @return 偏移量
     */
    int getOffset();
}
