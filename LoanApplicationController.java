package com.scb.Loan_Origination.Loan_Origination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scb.Loan_Origination.Loan_Origination.model.*;
import com.scb.Loan_Origination.Loan_Origination.service.LoanApplicationService;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createApplication() {
        try {
            LoanApplication application = loanApplicationService.createNewApplication();
            // Return only necessary data to avoid circular references
            Map<String, Object> response = new HashMap<>();
            response.put("id", application.getId());
            response.put("status", application.getStatus());
            response.put("createdAt", application.getCreatedAt());
            response.put("updatedAt", application.getUpdatedAt());
            response.put("message", "Application created successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to create application");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/{id}/personal-details")
    public ResponseEntity<Map<String, Object>> savePersonalDetails(
            @PathVariable Long id,
            @RequestBody PersonalDetails details) {
        try {
            LoanApplication application = loanApplicationService.savePersonalDetails(id, details);
            Map<String, Object> response = new HashMap<>();
            response.put("id", application.getId());
            response.put("status", application.getStatus());
            response.put("message", "Personal details saved successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to save personal details");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/{id}/employment-details")
    public ResponseEntity<Map<String, Object>> saveEmploymentDetails(
            @PathVariable Long id,
            @RequestBody EmploymentDetails details) {
        try {
            LoanApplication application = loanApplicationService.saveEmploymentDetails(id, details);
            Map<String, Object> response = new HashMap<>();
            response.put("id", application.getId());
            response.put("status", application.getStatus());
            response.put("message", "Employment details saved successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to save employment details");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/{id}/loan-details")
    public ResponseEntity<Map<String, Object>> saveLoanDetails(
            @PathVariable Long id,
            @RequestBody LoanDetails details) {
        try {
            LoanApplication application = loanApplicationService.saveLoanDetails(id, details);
            Map<String, Object> response = new HashMap<>();
            response.put("id", application.getId());
            response.put("status", application.getStatus());
            response.put("message", "Loan details saved successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to save loan details");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/{id}/document-details")
    public ResponseEntity<Map<String, Object>> saveDocumentDetails(
            @PathVariable Long id,
            @RequestBody DocumentDetails details) {
        try {
            LoanApplication application = loanApplicationService.saveDocumentDetails(id, details);
            Map<String, Object> response = new HashMap<>();
            response.put("id", application.getId());
            response.put("status", application.getStatus());
            response.put("message", "Document details saved successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to save document details");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/{id}/existing-loan-details")
    public ResponseEntity<Map<String, Object>> saveExistingLoanDetails(
            @PathVariable Long id,
            @RequestBody ExistingLoanDetails details) {
        try {
            LoanApplication application = loanApplicationService.saveExistingLoanDetails(id, details);
            Map<String, Object> response = new HashMap<>();
            response.put("id", application.getId());
            response.put("status", application.getStatus());
            response.put("message", "Existing loan details saved successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to save existing loan details");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/{id}/reference-details")
    public ResponseEntity<Map<String, Object>> saveReferenceDetails(
            @PathVariable Long id,
            @RequestBody ReferenceDetails details) {
        try {
            LoanApplication application = loanApplicationService.saveReferenceDetails(id, details);
            Map<String, Object> response = new HashMap<>();
            response.put("id", application.getId());
            response.put("status", application.getStatus());
            response.put("message", "Reference details saved successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to save reference details");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateApplication(
            @PathVariable Long id,
            @RequestBody Map<String, String> statusUpdate) {
        try {
            String status = statusUpdate.get("status");
            LoanApplication application = loanApplicationService.updateApplicationStatus(id, status);
            Map<String, Object> response = new HashMap<>();
            response.put("id", application.getId());
            response.put("status", application.getStatus());
            response.put("updatedAt", application.getUpdatedAt());
            response.put("message", "Application status updated successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to update application status");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getApplication(@PathVariable Long id) {
        try {
            LoanApplication application = loanApplicationService.getApplicationById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("id", application.getId());
            response.put("status", application.getStatus());
            response.put("createdAt", application.getCreatedAt());
            response.put("updatedAt", application.getUpdatedAt());
            
            // Add summary information without causing circular references
            if (application.getPersonalDetails() != null) {
                Map<String, Object> personalSummary = new HashMap<>();
                personalSummary.put("fullName", application.getPersonalDetails().getFullName());
                personalSummary.put("phoneNumber", application.getPersonalDetails().getPhoneNumber());
                personalSummary.put("panNumber", application.getPersonalDetails().getPanNumber());
                response.put("personalDetails", personalSummary);
            }
            
            if (application.getLoanDetails() != null) {
                Map<String, Object> loanSummary = new HashMap<>();
                loanSummary.put("loanType", application.getLoanDetails().getLoanType());
                loanSummary.put("loanAmount", application.getLoanDetails().getLoanAmount());
                loanSummary.put("loanTenure", application.getLoanDetails().getLoanTenure());
                response.put("loanDetails", loanSummary);
            }
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Application not found");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllApplications() {
        try {
            Iterable<LoanApplication> applications = loanApplicationService.getAllApplications();
            Map<String, Object> response = new HashMap<>();
            
            // Create a simplified list to avoid circular references
            java.util.List<Map<String, Object>> applicationList = new java.util.ArrayList<>();
            
            for (LoanApplication app : applications) {
                Map<String, Object> appSummary = new HashMap<>();
                appSummary.put("id", app.getId());
                appSummary.put("status", app.getStatus());
                appSummary.put("createdAt", app.getCreatedAt());
                appSummary.put("updatedAt", app.getUpdatedAt());
                
                // Add basic personal details if available
                if (app.getPersonalDetails() != null) {
                    appSummary.put("applicantName", app.getPersonalDetails().getFullName());
                    appSummary.put("phoneNumber", app.getPersonalDetails().getPhoneNumber());
                }
                
                // Add basic loan details if available
                if (app.getLoanDetails() != null) {
                    appSummary.put("loanType", app.getLoanDetails().getLoanType());
                    appSummary.put("loanAmount", app.getLoanDetails().getLoanAmount());
                }
                
                applicationList.add(appSummary);
            }
            
            response.put("applications", applicationList);
            response.put("totalCount", applicationList.size());
            response.put("message", "Applications retrieved successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to retrieve applications");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Loan Application Service is running");
        response.put("timestamp", java.time.LocalDateTime.now());
        return ResponseEntity.ok(response);
    }
}
