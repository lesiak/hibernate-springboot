package com.example.demo.repo;

import com.example.demo.model.Activities;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface ActivityMapper {
    @SelectProvider(type = ActivitySqlProvider.class, method = "getActivitiesByUserAndType")
    List<Activities> getActivities(@Param("userId") long userId, @Param("type") String type);
}
