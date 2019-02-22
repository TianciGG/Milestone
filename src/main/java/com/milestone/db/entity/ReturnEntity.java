package com.milestone.db.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class ReturnEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Object obj;
	private String status;
	private String msg;
	private List list;

	public List getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
