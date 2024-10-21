package com.be.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityNotFoundException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

import com.be.dto.customer.RequestMaintenanceDTO;
import com.be.model.Customer;
import com.be.model.Report;
import com.be.repository.CustomerRepository;
import com.be.repository.ReportRepository;

@Service
public class RequestMaintenance {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Value("${filePath}")
    private String uploadFile;

    public void createMaintenanceRequest(Integer customerId, RequestMaintenanceDTO requestMaintenanceDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        Path filePath = uploadFile(requestMaintenanceDTO.getFileLinkReport().getOriginalFilename(),
                requestMaintenanceDTO.getFileLinkReport());
        String fileLink = filePath.toString();

        Report newReport = new Report();
        newReport.setCustomer(customer);
        newReport.setTitle(requestMaintenanceDTO.getNameMaintenance());
        newReport.setInformation(requestMaintenanceDTO.getDescription());
        newReport.setFileLinkReport(fileLink);
        newReport.setCreatedDateTime(LocalDateTime.now());
        newReport.setStatus("open");
        reportRepository.save(newReport);
    }

    public Path uploadFile(String fileName, MultipartFile file) {
        File targetDir = new File(uploadFile);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        Path path = Path.of(uploadFile + fileName);
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        int counter = 1;
        while (Files.exists(path)) {
            String newFileName = baseName + "_" + counter + extension;
            path = targetDir.toPath().resolve(newFileName);
            counter++;
        }

        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return path;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("File upload failed", e);
        }
    }
}
