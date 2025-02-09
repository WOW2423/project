package com.enter.print.context.ramdomid.uuid;

import com.enter.print.context.ramdomid.StringRandomizer;
import com.enter.util.utils.TimeUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Liquid
 * @类名： NewUuidRandomizer
 * @描述：
 * @date 2019/4/14
 */
@Component("newUuid")
public class NewUuidRandomizer implements StringRandomizer {

    /**
     * @param
     * @return java.lang.String 时间的字符串
     * @throws null
     * @author Liquid
     * @描述： 获取当前格式化后的的时间的字符串
     * @date 2018/12/30
     */
    @Override
    public String getRandom() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getRandomStringWithBit(int bit) {
        StringBuilder id = new StringBuilder(getRandomUUID());
        while (id.length() < bit) {
            id.append(getRandomUUID());
        }
        return id.substring(0, bit);
    }

    private String getRandomUUID() {
        return UUID.randomUUID().toString() + TimeUtils.getCurrentTimeMills();
    }
}
