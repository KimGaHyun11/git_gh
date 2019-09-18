package com.icanman.vo;

public class PagingVo {

	//페이징
		private int page;
		private int startNum;
		private int endNum;
		private int recordCount;
		private int pageCount;
		private int pageSize;
		private int blockSize;
		private int startPage;
		private int endPage;
		private int endP;
		
		
		
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getStartNum() {
			return startNum;
		}
		public void setStartNum(int startNum) {
			this.startNum = startNum;
		}
		public int getEndNum() {
			return endNum;
		}
		public void setEndNum(int endNum) {
			this.endNum = endNum;
		}
		public int getRecordCount() {
			return recordCount;
		}
		public void setRecordCount(int recordCount) {
			this.recordCount = recordCount;
		}
		public int getPageCount() {
			return pageCount;
		}
		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getBlockSize() {
			return blockSize;
		}
		public void setBlockSize(int blockSize) {
			this.blockSize = blockSize;
		}
		public int getStartPage() {
			return startPage;
		}
		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}
		public int getEndPage() {
			return endPage;
		}
		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}
		public int getEndP() {
			return endP;
		}
		public void setEndP(int endP) {
			this.endP = endP;
		}
		@Override
		public String toString() {
			return "PagingVo [page=" + page + ", startNum=" + startNum + ", endNum=" + endNum + ", recordCount="
					+ recordCount + ", pageCount=" + pageCount + ", pageSize=" + pageSize + ", blockSize=" + blockSize
					+ ", startPage=" + startPage + ", endPage=" + endPage + ", endP=" + endP + "]";
		}
		
		
		
		
}
