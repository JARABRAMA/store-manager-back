package com.jarabrama.store_manager.model.dtos;

public class Meta {
  private final int totalElements;
  private final int totalPages;
  private final int page;
  private final int pageSize;
  private final boolean hasNext;
  private final boolean hasPrevious;

  private Meta(Builder builder) {
    this.totalElements = builder.totalElements;
    this.totalPages = builder.totalPages;
    this.page = builder.page;
    this.pageSize = builder.pageSize;
    this.hasNext = builder.hasNext;
    this.hasPrevious = builder.hasPrevious;
  }

  public static Builder builder() {
    return new Builder();
  }

  public int getTotalElements() {
    return totalElements;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public int getPage() {
    return page;
  }

  public int getPageSize() {
    return pageSize;
  }

  public boolean isHasNext() {
    return hasNext;
  }

  public boolean isHasPrevious() {
    return hasPrevious;
  }

  public static class Builder {
    private int totalElements;
    private int totalPages;
    private int page;
    private int pageSize;
    private boolean hasNext;
    private boolean hasPrevious;

    public Builder totalElements(int totalElements) {
      this.totalElements = totalElements;
      return this;
    }

    public Builder totalPages(int totalPages) {
      this.totalPages = totalPages;
      return this;
    }

    public Builder page(int page) {
      this.page = page;
      return this;
    }

    public Builder pageSize(int pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public Builder hasNext(boolean hasNext) {
      this.hasNext = hasNext;
      return this;
    }

    public Builder hasPrevious(boolean hasPrevious) {
      this.hasPrevious = hasPrevious;
      return this;
    }

    public Meta build() {
      return new Meta(this);
    }
  }
}
