package org.axis.helpy.callapi.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.lang.reflect.Field;
import java.util.Date;

@Data
@Entity
@Table(name = "VIEW_KNOWLEDGE", schema = "MOST_CALL")
public class KnowledgeBase {

    private String ringing_time;
    private String call_duration;
    private String service_duration;
    private Integer phonebook_type;
    private String phonebook_type_name;
    private String connection_type;
    private String react_name;
    private String cif;
    private String register;
    private Integer type;
    private String type_name;
    private String trunk;
    private Integer call_type;
    private String call_type_name;
    private Integer extension;
    private Date call_date;
    private String day;
    private String str_date;
    private String full_name;
    private String served;
    private String last_name;
    private String first_name;
    private Long value_id;
    private Long field_id;
    @Id
    private String call_id;
    private String phone;
    private Long employee_id;
    private Long branch_id;
    private Long org_id;
    private String domain;
    private String register_type;
    private String branch_name;
    private Long branch_type;
    private String field_value;
    private Integer operator_rate;
    private String op_rate_desc;
    private Date op_rate_date;
    private String callend_type;
    private Integer customer_rate;
    private Date rate_date;
    private Integer auto_sms_flg;
    private String op_rated_full_name;
    @Transient
    private Date call_date_sdate;
    @Transient
    private Date call_date_edate;
    private Long ringing_time_number;
    private Long call_duration_number;
    private Long service_duration_number;


    public boolean checkNull(){
        try{
            for (Field f : getClass().getDeclaredFields())
                if (f.get(this) != null)
                    return false;
        }catch (Exception ex){ }
        return true;
    }

}
