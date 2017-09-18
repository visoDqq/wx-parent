package com.wx.framework.partA.chapter.web;


import com.wx.framework.partA.annotation.Action;
import com.wx.framework.partA.annotation.Controller;
import com.wx.framework.partA.bean.Data;
import com.wx.framework.partA.bean.Param;
import com.wx.framework.partA.bean.View;
import com.wx.framework.partA.model.Resultbean;

@Controller
public class IndexController {

	@Action("get:/index")
	public View index(Param param){
		View view = new View("index.jsp");
		view.addModel("list", 111);
		return view;
	}
	
	@Action("get:/json")
	public Data index2(Param param){
		Data data = new Data();
		data.setModel(new Resultbean<String>(null));
		return data;
	}
}
