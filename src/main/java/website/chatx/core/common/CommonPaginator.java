package website.chatx.core.common;

import lombok.Getter;

@Getter
public class CommonPaginator {

    private int pageNo = 0;
    private int pageSize = 10;
    private long totalItems = 0;
    private int totalPages = 0;

    private int offset = 0;
    private int limit = 10;

    private void calculate() {

        this.limit = this.pageSize;

        if (totalItems == 0) {
            return;
        }

        this.totalPages = (int) Math.floor((double) this.totalItems / (double) this.pageSize);
        this.offset = (this.pageNo - 1) * this.pageSize;
    }

    public CommonPaginator(int pageNo, int pageSize, int totalItems) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.calculate();
    }
}
