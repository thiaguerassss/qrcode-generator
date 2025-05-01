package com.thiago.qrcodegenerator.adapters;

public interface Storage {

    String upload(byte[] fileData, String fileName, String contentType);
}
