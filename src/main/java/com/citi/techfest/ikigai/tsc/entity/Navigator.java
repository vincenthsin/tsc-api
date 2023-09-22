package com.citi.techfest.ikigai.tsc.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@DynamoDBTable(tableName = "Participant")
public class Navigator {
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute(attributeName = "Role")
    private String role;

    @DynamoDBRangeKey(attributeName = "Name")
    private String name;

    @DynamoDBAttribute(attributeName = "Gender")
    private String gender;

    @DynamoDBAttribute(attributeName = "ContactNumber")
    private String contactNumber;

    @DynamoDBAttribute(attributeName = "Email")
    private String email;

    @DynamoDBAttribute(attributeName = "DateOfBirth")
    private String dateOfBirth;

    @DynamoDBAttribute(attributeName = "AssignedParticipants")
    private List<String> assignedParticipants;
}