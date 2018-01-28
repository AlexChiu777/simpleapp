package com.example.servlet;

import com.example.model.Employee;
import com.example.model.EmployeeType;
import com.example.model.ServiceCall;
import com.example.model.ServiceCallStatus;
import com.example.service.EmployeeService;
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
                case "searchByEmployeeId":
                    redirectSearchById(req, resp);
                    break;
            }
        } else {
            List<ServiceCall> result = serviceCallService.getAllServiceCalls();
            forwardListServiceCall(req, resp, result);
        }
    }

    private void redirectSearchById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idEmployee = Integer.valueOf(req.getParameter("idEmployee"));

        Employee employee = null;
        try {
            employee = EmployeeService.getInstance().getEmployee(idEmployee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<ServiceCall> result = null;
        if (employee != null) {
            if (employee.getType().equals(EmployeeType.CONTRACTOR)) {
                result = serviceCallService.getServiceCallsForContractor(idEmployee);
            } else if (employee.getType().equals(EmployeeType.CLIENT)) {
                result = serviceCallService.getServiceCallsForClient(idEmployee);
            }
        }
        forwardListServiceCall(req, resp, result);
    }

    private void searchServiceCallById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter("idServiceCall") != null){
            long idServiceCall = Integer.valueOf(req.getParameter("idServiceCall"));

            ServiceCall serviceCall = null;
            try {
                serviceCall = serviceCallService.getServiceCallById(idServiceCall);
            } catch (Exception ex) {
                Logger.getLogger(ServiceCallServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            req.setAttribute("serviceCall", serviceCall);
            req.setAttribute("action", "edit");
            req.setAttribute("serviceCallStatus", serviceCall.getStatus());
        } else {
            req.setAttribute("serviceCallStatus", ServiceCallStatus.OPEN);
        }
        String nextJSP = "/add-servicecall.jsp";
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
            case "edit":
                editServiceCallAction(req, resp);
                break;
        }

    }

    private void addServiceCallAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        long idEmployee = Long.valueOf(req.getParameter("idEmployee"));

        ServiceCall serviceCall = null;
        try {
            serviceCall = new ServiceCall(title, description, idEmployee, ServiceCallStatus.OPEN);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long idServiceCall = serviceCallService.addServiceCall(serviceCall);
        req.setAttribute("idServiceCall", idServiceCall);
        String message = "The new serviceCall has been successfully created.";
        req.setAttribute("message", message);
        redirectSearchById(req, resp);
    }

    private void editServiceCallAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        long idServiceCall = Long.parseLong(req.getParameter("idServiceCall"));
        long idEmployee = Long.parseLong(req.getParameter("idEmployee"));

        ServiceCall serviceCall = null;
        try {
            serviceCall = ServiceCallService.getInstance().getServiceCallById(idServiceCall);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //update is done by contractor if it id isn't the same as original client
        if (idEmployee != serviceCall.getClient().getId()) {
            serviceCall.setAssignedTo(idEmployee);
        } else {
            serviceCall.setTitle(title);
            serviceCall.setDescription(description);
        }

        serviceCall.setStatus(ServiceCallStatus.valueOf(status));

        serviceCallService.updateServiceCall(serviceCall);

        req.setAttribute("idServiceCall", idServiceCall);
        String message = "The new serviceCall has been successfully created.";
        req.setAttribute("message", message);


        redirectSearchById(req, resp);
    }
}
