package com.citi.techfest.ikigai.tsc.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "service_item")
@Data
public class ServiceItem {

        @Id
        @Column(name = "service_name")
        private String serviceName;

        @ManyToOne
        @JoinColumn(name = "participant", referencedColumnName = "name")
        private Participant participant;

        @Column(name = "service_provider")
        private String serviceProvider;

        @Column(name = "organization_address")
        private String organizationAddress;

        @Column(name = "organization_name")
        private String organizationName;

        @Column(name = "service_category")
        private String serviceCategory;

        @Column(name = "service_start_date")
        private LocalDate serviceStartDate;

        @Column(name = "service_date")
        private LocalDate serviceDate;

        @Column(name = "last_modified_date")
        private LocalDate lastModifiedDate;

        @Column(name = "service_status")
        private String serviceStatus;

        @Column(name = "service_comments")
        private String serviceComments;

        @Column(name = "service_feedback")
        private String serviceFeedback;

        @Column(name = "assigned_case_worker")
        private String caseWorker;
}
