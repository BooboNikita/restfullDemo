package com.example.restfulldemo.util.servlet;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import com.alibaba.druid.support.jakarta.StatViewServlet;

/**
 * Druid 监控视图 Servlet
 */
@WebServlet(urlPatterns = { "/druid/*" }, initParams = { @WebInitParam(name = "loginUsername", value = "demo"), @WebInitParam(name = "loginPassword", value = "demo") })
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = 1L;

}