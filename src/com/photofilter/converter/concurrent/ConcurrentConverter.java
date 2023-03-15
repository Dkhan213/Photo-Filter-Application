package com.photofilter.converter.concurrent;

import com.photofilter.converter.PhotoConverter;
import com.photofilter.model.Photo;

/**
 * A ConcurrentConverter executes a wrapped PhotoConverter's convert() method asynchronously. When the run method
 * has completed, it will have populated a String field that provides the location of the converted image.
 */
public class ConcurrentConverter implements Runnable {

    private final PhotoConverter converter;
    private final Photo inputImage;
    private final String fileName;
    private String convertedImageLocation;

    public ConcurrentConverter(final PhotoConverter converter, final Photo inputImage, final String fileName) {
        this.converter = converter;
        this.inputImage = inputImage;
        this.fileName = fileName;
    }

    public String getConvertedImageLocation() {
        if (convertedImageLocation == null) {
            throw new IllegalStateException("Conversion computation not complete yet, or did not succeed.");
        }
        return convertedImageLocation;
    }

    @Override
    public void run() {
        // Calls one of the strategies that implements PhotoConverter
        convertedImageLocation = converter.convert(inputImage, fileName);
    }
}
