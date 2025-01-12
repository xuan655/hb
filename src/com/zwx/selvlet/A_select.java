package com.zwx.selvlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;
import com.zwx.been.textbeen;
import com.zwx.dbutil.Db_text;

/**
 * Servlet implementation class A_select
 */
@WebServlet("/A_select")
public class A_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String jg_name=request.getParameter("jg_name");
		String gk=request.getParameter("gk");
		String sz_address=request.getParameter("sz_address");
		String legal=request.getParameter("legal");
		String lname=request.getParameter("lname");
		String institution=request.getParameter("institution");
		String technology=request.getParameter("technology");
		String keyword=request.getParameter("keyword");
		String plan_invest=request.getParameter("plan_invest");
		String mode=request.getParameter("mode");
		String type=request.getParameter("type");
		String classification=request.getParameter("classification");
		String field=request.getParameter("field");
		String need_industry=request.getParameter("need_industry");
		String search=request.getParameter("search");
		
		System.out.println("选择"+search);
		String bm=request.getParameter("bm");
		String state=request.getParameter("state");
		textbeen test=new textbeen();
		test.setName(jg_name);
		test.setGk(gk);
		test.setSz_address(sz_address);
		test.setLegal(legal);
		test.setLname(lname);
		test.setInstitution(institution);
		test.setTechnology(technology);
		test.setKeyword(keyword);
		test.setPlan_invest(plan_invest);
		test.setMode(mode);
		test.setType(type);
		test.setClassification(classification);
		test.setField(field);
		test.setNeed_industry(need_industry);
		test.setBm_id(bm);
		test.setState_id(state);
        ArrayList<textbeen> list =new ArrayList<>();
        //JSONArray jsonArray=new JSONArray();
		if (search.equals("0")) {
			//精确查询
		list=Db_text.A_moreseaarch_0(test);
		}
		else if (search.equals("1")) {
			//模糊查询
		list=Db_text.A_moreseaarch_1(test);
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("manage/text_search.jsp").forward(request, response);
	}

}
