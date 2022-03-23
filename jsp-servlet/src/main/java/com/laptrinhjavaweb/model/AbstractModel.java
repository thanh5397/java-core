package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

public class AbstractModel {
		private long id;
		private Timestamp createddate;
		private Timestamp modifieddate;
		private String createdby;
		private String modifiedby;
		private long[] ids;
	  
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Timestamp getCreateddate() {
			return createddate;
		}
		public void setCreateddate(Timestamp createddate) {
			this.createddate = createddate;
		}
		public Timestamp getModifieddate() {
			return modifieddate;
		}
		public void setModifieddate(Timestamp modifieddate) {
			this.modifieddate = modifieddate;
		}
		public String getCreatedby() {
			return createdby;
		}
		public void setCreatedby(String createdby) {
			this.createdby = createdby;
		}
		public String getModifiedby() {
			return modifiedby;
		}
		public void setModifiedby(String modifiedby) {
			this.modifiedby = modifiedby;
		}
		public long[] getIds() {
			return ids;
		}
		public void setIds(long[] ids) {
			this.ids = ids;
		} 
		
}
