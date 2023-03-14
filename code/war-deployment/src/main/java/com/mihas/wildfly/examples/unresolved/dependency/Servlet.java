package com.mihas.wildfly.examples.unresolved.dependency;

import com.mihas.wildfly.examples.unresolved.dependency.special.TestUtil;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Servlet extends HttpServlet {

    @Inject
    private TestUtil testUtil;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        System.out.println(testUtil.sayHello());
    }

}
