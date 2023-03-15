package com.photofilter.converter;

import com.photofilter.model.ConversionType;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/**
 * Vends converter strategies.
 */
public final class ConverterStrategyMapper {
    private final Map<ConversionType, PhotoConverter> converterMap = ImmutableMap.of(
        ConversionType.SEPIA, new SepiaConverter(),
        ConversionType.GREYSCALE, new GreyscaleConverter(),
        ConversionType.INVERSION, new InversionConverter()
    );

    @Inject
    public ConverterStrategyMapper() {}

    /**
     * Retrieves the strategy associated with the provided ConversionType.
     * @param conversionType the type of strategy requested
     * @return the associated strategy
     */
    public PhotoConverter getImageConverter(final ConversionType conversionType) {
        return converterMap.get(conversionType);
    }

    /**
     * Retrieves all conversion strategies.
     * @return all conversion strategies
     */
    public Set<Map.Entry<ConversionType, PhotoConverter>> getImageConverters() {
        return converterMap.entrySet();
    }
}
