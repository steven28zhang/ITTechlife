/**
 * 
 */
package com.sxwz.pubindex.google.map.place;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public class GoolgePlaceAutoComplateAddress extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -4549567346679383467L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/googleplaceautocompleteaddress.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/googleplaceautocompleteaddress.html");
    }

}
