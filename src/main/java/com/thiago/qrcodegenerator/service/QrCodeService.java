package com.thiago.qrcodegenerator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.thiago.qrcodegenerator.adapters.Storage;
import com.thiago.qrcodegenerator.dto.QrCodeResponse;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeService {

    private final Storage storage;

    public QrCodeService(Storage storage){
        this.storage = storage;
    }

    public QrCodeResponse generateQrCode(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream png = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", png);
        byte[] pngQrCodeData = png.toByteArray();

        String url = storage.upload(pngQrCodeData, UUID.randomUUID().toString(),"image/png");

        return new QrCodeResponse(url);
    }
}
