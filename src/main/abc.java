package com.neu.swini.rentCarProject.controller;

import com.neu.swini.rentCarProject.dao.LicenseDAO;
import com.neu.swini.rentCarProject.exception.LicenseException;
import com.neu.swini.rentCarProject.pojo.Customer;
import com.neu.swini.rentCarProject.pojo.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class LicenseController {

    @Autowired
    private LicenseDAO licenseDAO;

    @GetMapping("/uploadLicense")
    public String showUploadLicenseForm(ModelMap model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("license", new License());
        return "addLicense";
    }

    @PostMapping("/uploadLicense")
    public String uploadLicense(HttpSession session, @RequestParam("license") CommonsMultipartFile imageFile, HttpServletRequest request,
                                RedirectAttributes redirectAttributes) throws LicenseException, IOException {

        Customer customer = (Customer) session.getAttribute("custLicense");

        if (customer == null) {
            throw new LicenseException("Not authorized");
        }

        License license = new License();
        license.setCustomerLicense(customer.getLicense());
        license.setCustomerName(customer.getName());
        String fileName = customer.getName() + "license";
        String path = session.getServletContext().getRealPath("/") + "docs/" + fileName;
        license.setLicenseDocument(fileName);

        try{
            fos.write(data);
        } catch (IOException e) {
            throw new LicenseException("Error uploading file.");
        }

        redirectAttributes.addFlashAttribute("success", "Uploaded License");
        return "redirect:/home";
    }
}
