package com.neu.swini.rentCarProject.controller;

import com.neu.swini.rentCarProject.dao.LicenseDAO;
import com.neu.swini.rentCarProject.pojo.Customer;
import com.neu.swini.rentCarProject.pojo.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class LicenseController {

    @Autowired
    License license;

    @Autowired
    LicenseDAO licenseDAO;

    @GetMapping("/uploadLicense.htm")
    public String uploadLicenseGet(ModelMap model, HttpSession session, HttpServletRequest request) {

        model.addAttribute("license", license);
        return "addLicense";
    }

    @PostMapping("/uploadLicense.htm")
    public String uploadLicensePost(HttpSession session , @RequestParam("licenseDoc") CommonsMultipartFile imagefile, HttpServletRequest request) throws  Exception{

        request.getSession();

        String licenseDoc = request.getParameter("licenseDoc");
        Customer customer = (Customer) session.getAttribute("customer");

        if(licenseDoc != null){
            License license = new License();
            license.setCustomer(customer);
            license.setCustomerLicense(customer.getLicense());
            license.setCustomerName(customer.getName());
            String fileName =  customer.getName() + "_license" +System.currentTimeMillis()  + ".pdf";
            byte[] data = imagefile.getBytes();
            String path = session.getServletContext().getRealPath("/")+ "docs/"+fileName;
            license.setLicenseDocument(fileName);

            try{
                FileOutputStream fos = new FileOutputStream(path);
                fos.write(data);
                fos.close();
                System.out.println("File Uploaded successfully");
            }catch (IOException e) {
                e.printStackTrace();
                System.out.println("File Upload error");
            }
            try{
                licenseDAO.create(license);
            }catch (Exception e){
                System.out.println("Exception: " +e.getMessage());
            }
        }

        if(customer.getCategory().equals("customer")){
            return "customerPage";
        }
        else if(customer.getCategory().equals("carOwner")){
            return "carOwnerPage";
        }
        else
        return "login-form";
    }
}
