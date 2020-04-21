package com.lonxinwu.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.util.Hashtable;

public class QrCodeUtil {

    //private static String QRBLACK =
    public BufferedImage createQrCodeImg(String content, int qrSize) throws Exception{
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, qrSize,qrSize,hints);
        BufferedImage qrImg = new BufferedImage(qrSize, qrSize,BufferedImage.TYPE_INT_RGB);
        return qrImg;
    }
}
