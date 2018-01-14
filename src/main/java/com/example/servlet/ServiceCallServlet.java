package com.example.servlet;

import com.example.model.ServiceCall;
import com.example.model.ServiceCallStatus;
import com.example.service.ServiceCallService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alex on 1/14/2018.
 */
@WebServlet(
        name = "ServiceCallServlet",
        urlPatterns = {"/servicecall"}
)
public class ServiceCallServlet extends HttpServlet {
    ServiceCallService serviceCallService = ServiceCallService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("searchAction");
        if (action != null) {
            switch (action) {
                case "searchById":
                    searchServiceCallById(req, resp);
                    break;
            }
        } else {
            List<ServiceCall> result = serviceCallService.getAllServiceCalls();
            forwardListServiceCall(req, resp, result);
        }
    }

    private void searchServiceCallById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idServiceCall = Integer.valueOf(req.getParameter("idServiceCall"));
        ServiceCall serviceCall = null;
        try {
            serviceCall = serviceCallService.getServiceCallById(idServiceCall);
        } catch (Exception ex) {
            Logger.getLogger(ServiceCallServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("serviceCall", serviceCall);
        req.setAttribute("action", "edit");
        String nextJSP = "/add-serviceCall.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void forwardListServiceCall(HttpServletRequest req, HttpServletResponse resp, List serviceCallList)
            throws ServletException, IOException {
        String nextJSP = "/list-servicecalls.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("serviceCallList", serviceCallList);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addServiceCallAction(req, resp);
                break;
            /*case "edit":
                editServiceCallAction(req, resp);
                break;*/
        }

    }

    private void addServiceCallAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String address = req.getParameter("address");
        long clientID = Long.valueOf(req.getParameter("clientID"));

        ServiceCall serviceCall = null;
        try {
            serviceCall = new ServiceCall(title, description, clientID, ServiceCallStatus.OPEN);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long idServiceCall = serviceCallService.addServiceCall(serviceCall);
        List<ServiceCall> serviceCallList = serviceCallService.getAllServiceCalls();
        req.setAttribute("idServiceCall", idServiceCall);
        String message = "The new serviceCall has been successfully created.";
        req.setAttribute("message", message);
        forwardListServiceCall(req, resp, serviceCallList);
    }

    /*private void editServiceCallAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String address = req.getParameter("address");
        long clientID = Long.valueOf(req.getParameter("clientID"));

        ServiceCall serviceCall = null;
        try {
            serviceCall = new ServiceCall(title, description, clientID, ServiceCallStatus.OPEN);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long idServiceCall = serviceCallService.addServiceCall(serviceCall);
        List<ServiceCall> serviceCallList = serviceCallService.getAllServiceCalls();
        req.setAttribute("idServiceCall", idServiceCall);
        String message = "The new serviceCall has been successfully created.";
        req.setAttribute("message", message);
        forwardListServiceCall(req, resp, serviceCallList);
    }*/
}
