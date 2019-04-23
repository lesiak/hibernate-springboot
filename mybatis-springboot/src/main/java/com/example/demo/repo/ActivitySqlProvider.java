package com.example.demo.repo;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ActivitySqlProvider {
    public String getActivitiesByUserAndType(final Map<String, Object> params) {

        String COLUMNS = "ACTIVITYID, USERID, TYPE";
        String TABLE_NAME = "ACTIVITY";

        boolean hasType = params.containsKey("type");

        final String sql = new SQL() {{
            SELECT(COLUMNS);
            FROM(TABLE_NAME);
            WHERE("USERID = #{userId}");

            if (hasType) {
                WHERE("TYPE = #{type}");
            }

        }}.toString();

        System.out.println(sql);
        return sql;
    }
}
