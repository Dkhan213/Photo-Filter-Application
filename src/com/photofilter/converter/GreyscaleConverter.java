package com.photofilter.converter;

import com.photofilter.model.ConversionType;
import com.photofilter.model.Photo;
import com.photofilter.model.Pixel;
import com.photofilter.model.RGB;
import com.photofilter.util.PhotoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts an image to a grey scale version.
 */
public class GreyscaleConverter implements PhotoConverter {

    public String convert(final Photo image, final String imageName) {
        List<Pixel> pixels = new ArrayList<>();

        for (Pixel pixel : image.getPixels()) {
            RGB rgb = pixel.getRGB();
            // take our RGB object (named rgb) and ask toGreyScale to change it's value
            // rgb.toGreyScale(); // replaced by assigning the new RGB object to out rbg member variable
            //      toGreyScale now returns an RGB object rather than change the values in the one it is passed
            rgb = rgb.toGreyScale(); // Have toGreyScale() take the values in our RGB object and return a new RGB object
                                     //     with values set to GreyScale
                                     // like stringObject.toUpperCase()
                                     //      stringObject = stringObject.toUpperCase()
            pixels.add(new Pixel(pixel.getX(), pixel.getY(), rgb));
        }

        Photo convertedImage = new Photo(pixels, image.getHeight(), image.getWidth(), image.getType());

        return PhotoUtil.savePrimePhoto(convertedImage, imageName, ConversionType.GREYSCALE);
    }
}
