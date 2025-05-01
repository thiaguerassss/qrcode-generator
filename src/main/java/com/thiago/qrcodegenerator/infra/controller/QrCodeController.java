package com.thiago.qrcodegenerator.infra.controller;

import com.thiago.qrcodegenerator.dto.QrCodeRequest;
import com.thiago.qrcodegenerator.dto.QrCodeResponse;
import com.thiago.qrcodegenerator.service.QrCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcodegenerator")
public class QrCodeController {

    private final QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<QrCodeResponse> generateQrCode(@RequestBody QrCodeRequest request){
        try{
            QrCodeResponse response = this.qrCodeService.generateQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
