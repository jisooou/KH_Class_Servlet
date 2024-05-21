package com.kh.journey.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.member.vo.MemberVo;

// 임시 로그인 - MemberLoginController, MemberVo, login.jsp 임시 테스트용. 

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 임시 사용자 인증 로직 - 아이디:testuser / 비번:testpass
        if ("testuser".equals(username) && "testpass".equals(password)) {
            MemberVo loginMemberVo = new MemberVo();
            loginMemberVo.setNo("1");
            loginMemberVo.setId(username);
            loginMemberVo.setName("Test User");

            HttpSession session = req.getSession();
            session.setAttribute("loginMemberVo", loginMemberVo);

            resp.sendRedirect("/journey/wish/list");
        } else {
            req.setAttribute("errMsg", "아이디 또는 비밀번호가 올바르지 않습니다.");
            req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
        }
    }
}