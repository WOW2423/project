package com.enter.print.pojo.entity.other;

import lombok.Data;

import java.io.Serializable;

@Data
public class BtnData implements Serializable {

    private static final long serialVersionUID = 1773372096981501408L;

    private String key;

    private String name;

    private String replace_name;


}
