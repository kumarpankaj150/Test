package com.sparks.ra.response;

import java.util.HashMap;
import java.util.Map;
import com.sparks.ra.response.ResponseKey;

public class Response {

	private Map<ResponseKey,Object> data = new HashMap<ResponseKey, Object>();

	public Map<ResponseKey, Object> getData() {
		return data;
	}

	public void setData(Map<ResponseKey, Object> data) {
		this.data = data;
	}
	
	public void addResponseData(ResponseKey key, Object value) {
		
		if( key != null){
			this.data.put(key, value);
		}
		
	}
	
	@Override
	public String toString(){
		final StringBuilder buf = new StringBuilder("Response[data=");
		for(ResponseKey key: data.keySet()){
			buf.append("("+key+":"+data.get(key).toString()+"),");
		}
		int last = buf.lastIndexOf(",");
		if(last > 0){
			buf.deleteCharAt(last);
		}
		buf.append("]");
		return buf.toString();
	}
}
