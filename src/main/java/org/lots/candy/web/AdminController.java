package org.lots.candy.web;

import javax.servlet.http.HttpSession;

import org.lots.candy.config.Constant;
import org.lots.candy.domain.TaskMapper;
import org.lots.candy.entity.Action;
import org.lots.candy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private TaskMapper taskMapper;
	
	@RequestMapping("/")
	public String init(Model model, HttpSession session){
		// TO XUYUAN : 请将这段代码写入login 成功那段代码，这里仅做测试用，之后请帮忙删除
		User usertt = new User();
		usertt.setUserId("admin");
		session.setAttribute(Constant.USER_SESSION_NAME, usertt);
		
		// 正文开始
		User user = (User)session.getAttribute(Constant.USER_SESSION_NAME);
		Page<Action> actions = taskMapper.queryActions("", null, "N");
		
		return "admin/index";
	}

}
