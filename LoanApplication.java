package com.scb.Loan_Origination.Loan_Origination.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan_application")
public class LoanApplication {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String status;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @OneToOne(mappedBy = "loanApplication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("application-personal")
    private PersonalDetails personalDetails;
    
    @OneToOne(mappedBy = "loanApplication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("application-employment")
    private EmploymentDetails employmentDetails;
    
    @OneToOne(mappedBy = "loanApplication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("application-loan")
    private LoanDetails loanDetails;
    
    @OneToOne(mappedBy = "loanApplication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("application-document")
    private DocumentDetails documentDetails;
    
    @OneToOne(mappedBy = "loanApplication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("application-existing")
    private ExistingLoanDetails existingLoanDetails;
    
    @OneToOne(mappedBy = "loanApplication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("application-reference")
    private ReferenceDetails referenceDetails;
    
    public LoanApplication() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        this.updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }
    
    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
        if (personalDetails != null) {
            personalDetails.setLoanApplication(this);
        }
    }
    
    public EmploymentDetails getEmploymentDetails() {
        return employmentDetails;
    }
    
    public void setEmploymentDetails(EmploymentDetails employmentDetails) {
        this.employmentDetails = employmentDetails;
        if (employmentDetails != null) {
            employmentDetails.setLoanApplication(this);
        }
    }
    
    public LoanDetails getLoanDetails() {
        return loanDetails;
    }
    
    public void setLoanDetails(LoanDetails loanDetails) {
        this.loanDetails = loanDetails;
        if (loanDetails != null) {
            loanDetails.setLoanApplication(this);
        }
    }
    
    public DocumentDetails getDocumentDetails() {
        return documentDetails;
    }
    
    public void setDocumentDetails(DocumentDetails documentDetails) {
        this.documentDetails = documentDetails;
        if (documentDetails != null) {
            documentDetails.setLoanApplication(this);
        }
    }
    
    public ExistingLoanDetails getExistingLoanDetails() {
        return existingLoanDetails;
    }
    
    public void setExistingLoanDetails(ExistingLoanDetails existingLoanDetails) {
        this.existingLoanDetails = existingLoanDetails;
        if (existingLoanDetails != null) {
            existingLoanDetails.setLoanApplication(this);
        }
    }
    
    public ReferenceDetails getReferenceDetails() {
        return referenceDetails;
    }
    
    public void setReferenceDetails(ReferenceDetails referenceDetails) {
        this.referenceDetails = referenceDetails;
        if (referenceDetails != null) {
            referenceDetails.setLoanApplication(this);
        }
    }
}
