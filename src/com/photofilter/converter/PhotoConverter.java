package com.photofilter.converter;

import com.photofilter.model.Photo;

/**
 * Strategy interface for converting images.
 */
public interface PhotoConverter {

    String convert(Photo image, String imageName);
}
