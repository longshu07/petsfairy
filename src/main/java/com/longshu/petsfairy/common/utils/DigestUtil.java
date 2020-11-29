package com.longshu.petsfairy.common.utils;

import com.longshu.petsfairy.Error.CommonErrorCode;
import com.longshu.petsfairy.Error.ErrorCodeException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by codedrinker on 2018/11/25.
 */

public class DigestUtil {
    public static void checkDigest(String rawData, String sessionKey, String signature) {
        // 调用 apache 的公共包进行 SHA1 加密处理
        System.out.println("rawData: " + rawData + "\n" + "sessionKey" + sessionKey);
//        DigestUtils.sha1((rawData + sessionKey).getBytes());
//        String sha1 = DigestUtils.sha1(rawData + sessionKey);
        String sha1 = DigestUtils.sha1Hex(rawData + sessionKey);
//        String sha1 = DigestUtils.sha1Hex((rawData + sessionKey).getBytes());
        boolean equals = sha1.equals(signature);
        if (!equals) {
            throw new ErrorCodeException(CommonErrorCode.SIGNATURE_ERROR);
        }
    }
}
