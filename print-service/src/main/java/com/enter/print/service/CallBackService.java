package com.enter.print.service;

import com.enter.util.exception.AesException;
import com.enter.util.exception.CheckedException;

public interface CallBackService {
    void processRequestToAddMerchant(String msg) throws AesException, CheckedException;
}
