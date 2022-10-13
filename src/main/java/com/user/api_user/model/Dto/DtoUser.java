package com.user.api_user.model.Dto;

import com.user.api_user.model.Address;
import com.user.api_user.model.Documents;
import com.user.api_user.model.Users;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class DtoUser implements Serializable {
    public List<Map<String,String>>   address;
    public String names;
    public String lastNames;
    public List<Map<String,Long>> documents;
}
