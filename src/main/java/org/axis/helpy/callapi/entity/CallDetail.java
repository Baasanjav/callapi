package org.axis.helpy.callapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.lang.reflect.Field;
import java.util.Date;

@Data
@Entity
@Table(name = "VW_OPERATOR_LOG", schema = "MOST_CALL")
public class CallDetail {

    private String call_id;
    @Id
    private Long log_id;
    private Integer call_type;
    private String call_type_name;
    private String register;
    private String phone;
    private String ringing_time;
    private String call_duration;
    private String service_duration;
    private String audio_file;
    private String  call_day;
    private Date call_date;
    private Integer STATUS;
    private Integer extension;
    private Long employee_id;
    private String last_name;
    private String first_name;
    private String full_name;
    private String branch_name;
    private String position_name;
    private String trunk;
    private Integer phonebook_type;
    private Integer operator_rate;
    private String op_rate_desc;
    private Integer branch_type;
    private String domain;
    private Long branch_id;
    private String date_time;
    private String phonebook_type_name;
    private String customer_rate;
    private Integer callend_type;
    private Date rate_date;
    private Integer auto_sms_flg;
    private String connection_type;
    private Date op_rate_date;
    private String trunk_filter;
    private Integer op_queue;
    private Long org_id;
    private String org_name;
    private String note;


    public boolean checkNull(){
        try{
            for (Field f : getClass().getDeclaredFields())
                if (f.get(this) != null)
                    return false;
        }catch (Exception ex){ }
        return true;
    }

}
