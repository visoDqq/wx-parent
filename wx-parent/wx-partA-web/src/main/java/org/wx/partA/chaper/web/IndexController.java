package org.wx.partA.chaper.web;


import com.wx.framework.partA.annotation.Action;
import com.wx.framework.partA.annotation.Controller;
import com.wx.framework.partA.annotation.Inject;
import com.wx.framework.partA.bean.Param;
import com.wx.framework.partA.bean.View;
import com.wx.framework.partA.model.Resultbean;
import com.wx.framework.partA.model.UserInfo;
import org.wx.partA.chaper.api.UserService;
import org.wx.partA.chaper.service.UserServiceImpl;

import java.util.List;

@Controller
public class IndexController {

	@Inject
	public UserServiceImpl userService;

	@Action("get:/index")
	public View index(Param param){
		View view = new View("index.jsp");
		view.addModel("list", 111);
		return view;
	}
	
	@Action("get:/json")
	public Resultbean<List> index2(Param param){
		List<UserInfo> userInfos = userService.getUserList();
//		Data data = new Data();
//		data.setModel(new Resultbean<String>(null));
//		List list = null;
//		list.add("1");
		return new Resultbean<List>(userInfos);
	}

	@Override
	public String toString() {
		return "IndexController{" +
				"userService=" + userService +
				'}';
	}
}
