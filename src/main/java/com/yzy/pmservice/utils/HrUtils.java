package com.yzy.pmservice.utils;

import com.yzy.pmservice.pojo.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtils {
    public static Hr getCurrentHr(){
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
