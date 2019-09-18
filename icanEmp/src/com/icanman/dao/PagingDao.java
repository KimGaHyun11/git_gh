package com.icanman.dao;

import java.sql.Connection;

import com.icanman.vo.PagingVo;

public class PagingDao {
	
	//페이징
		public PagingVo paging(Connection conn, int page, int total) throws Exception {
			
			PagingVo pagingVo = new PagingVo();
			if (page == 0) {
				page = 1;
			}
			int pageSize = 5; //한페이지의 게시물 수
			int startNum = (page - 1) * pageSize + 1; //한페이지의 시작번호
			int endNum = page * pageSize; //한페이지의 끝번호
			int recordCount = total;

			if (endNum > recordCount) {
				endNum = recordCount;
			}
			int pageCount = recordCount / pageSize;

			if (recordCount % pageSize != 0) {
				pageCount++;	
			}
			int blockSize = 5;
			int startPage = (page - 1) / blockSize * blockSize + 1;
			int endPage = ((page - 1) / blockSize + blockSize + blockSize);

			if (endPage > pageCount) {
				endPage = pageCount;
			}
			

			pagingVo.setPage(page);
			pagingVo.setPageSize(pageSize);
			pagingVo.setStartNum(startNum);
			pagingVo.setEndNum(endNum);
			pagingVo.setRecordCount(recordCount);
			pagingVo.setPageCount(pageCount);
			pagingVo.setBlockSize(blockSize);
			pagingVo.setStartPage(startPage);
			pagingVo.setEndPage(endPage);
			

			return pagingVo;
		}

}
