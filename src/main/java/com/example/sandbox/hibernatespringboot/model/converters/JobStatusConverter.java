package com.example.sandbox.hibernatespringboot.model.converters;

import com.example.sandbox.hibernatespringboot.model.common.JobStatus;

import javax.persistence.Converter;

@Converter
public class JobStatusConverter extends EnumIgnoreCaseConverter<JobStatus> {

    public JobStatusConverter() {
        super(JobStatus.class);
    }

}
