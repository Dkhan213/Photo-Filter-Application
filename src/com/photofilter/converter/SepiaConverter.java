package com.photofilter.converter;

import com.photofilter.model.ConversionType;
import com.photofilter.model.Photo;
import com.photofilter.model.Pixel;
import com.photofilter.model.RGB;
import com.photofilter.util.PhotoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts an image to a sepia version.
 */
public class SepiaConverter implements PhotoConverter {

    public String convert(final Photo image, final String imageName) {
        List<Pixel> pixels = new ArrayList<>();

        for (Pixel pixel : image.getPixels()) {
            RGB rgb = pixel.getRGB();
            rgb = rgb.toSepia();
            pixels.add(new Pixel(pixel.getX(), pixel.getY(), rgb));
        }

        Photo convertedImage = new Photo(pixels, image.getHeight(), image.getWidth(), image.getType());

        return PhotoUtil.savePrimePhoto(convertedImage, imageName, ConversionType.SEPIA);
    }
}
