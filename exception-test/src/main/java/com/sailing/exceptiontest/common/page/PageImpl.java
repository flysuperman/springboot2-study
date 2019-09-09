package com.sailing.exceptiontest.common.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * {@code Page}的基本实现
 *
 * @param <T>
 *            分页对象中内容的类型.
 */
public class PageImpl<T> implements MyPage<T>, Serializable {

    private static final long serialVersionUID = 867755909294344406L;

    private List<T> rows = new ArrayList<T>();
    private final Pageable pageable;
    private long total;

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    /**
     * {@code PageImpl}构造
     *
     * @param content
     *            该页的内容，不允许为 {@literal null}.
     * @param pageable
     *            分页参数信息, 允许为 {@literal null}.
     * @param total
     *            该对象的总量
     */
    public PageImpl(List<T> content, Pageable pageable, long total) {

        if (null == content) {
            throw new IllegalArgumentException("Content must not be null!");
        }

        this.rows.addAll(content);
        this.total = total;
        this.pageable = pageable;
    }

    /**
     * 通过已知的{@code content}集合，创建一个新的 {@link PageImpl}. T
     *
     * @param content
     *            不允许为 {@literal null}.
     */
    public PageImpl(List<T> content) {
        this(content, null, null == content ? 0 : content.size());
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#getNumber()
     */
    public int getNumber() {
        return pageable == null ? 0 : pageable.getPageNumber();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#getSize()
     */
    public int getSize() {
        return pageable == null ? 0 : pageable.getPageSize();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#getTotalPages()
     */
    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total
                / (double) getSize());
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#getNumberOfElements()
     */
    public int getNumberOfElements() {
        return rows.size();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#getTotalElements()
     */
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#hasPreviousPage()
     */
    public boolean hasPreviousPage() {
        return getNumber() > 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#isFirstPage()
     */
    public boolean isFirstPage() {
        return !hasPreviousPage();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#hasNextPage()
     */
    public boolean hasNextPage() {
        return getNumber() + 1 < getTotalPages();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#isLastPage()
     */
    public boolean isLastPage() {
        return !hasNextPage();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#iterator()
     */
    public Iterator<T> iterator() {
        return rows.iterator();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#getContent()
     */
    public List<T> getRows() {
        return Collections.unmodifiableList(rows);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Page#hasContent()
     */
    public boolean hasContent() {
        return !rows.isEmpty();
    }



    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        String contentType = "UNKNOWN";

        if (rows.size() > 0) {
            contentType = rows.get(0).getClass().getName();
        }

        return String.format("Page %s of %d containing %s instances",
                getNumber(), getTotalPages(), contentType);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PageImpl<?>)) {
            return false;
        }

        PageImpl<?> that = (PageImpl<?>) obj;

        boolean totalEqual = this.total == that.total;
        boolean contentEqual = this.rows.equals(that.rows);
        boolean pageableEqual = this.pageable == null ? that.pageable == null
                : this.pageable.equals(that.pageable);

        return totalEqual && contentEqual && pageableEqual;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;

        result = 31 * result + (int) (total ^ total >>> 32);
        result = 31 * result + (pageable == null ? 0 : pageable.hashCode());
        result = 31 * result + rows.hashCode();

        return result;
    }
}

