package com.photofilter;

import com.photofilter.activity.ConvertPhotoActivity;
import com.photofilter.dependency.DaggerServiceComponent;
import com.photofilter.dependency.ServiceComponent;
import com.photofilter.model.ConversionType;

import com.google.common.collect.ImmutableList;

/**
 * A class provided for interacting with the PrimePhotoConverterService
 */
public class PhotoConverterManualTester {

    private static final ServiceComponent DAGGER = DaggerServiceComponent.create();

    /**
     * If you're having issues running the main method, check the "Before starting" steps in the README.
     */
    public static void main(String[] args) {
        // Call the runtest() method with a picture and a list of conversions to be performed
        // ImmutableList is a List that is thread safe for use in concurrent execution environment
        runTest("src/resources/dalmatian.jpg", ImmutableList.of(ConversionType.INVERSION,
            ConversionType.GREYSCALE, ConversionType.SEPIA));

        // PARTICIPANTS: uncomment the below line to run a test that converts an image to a single filter type.
//         runTest("src/resources/dalmatian.jpg", ImmutableList.of(ConversionType.SEPIA));
    }

    //runtest() will start a thread for each conversion type requested in the list it is passed
    //      using the activity.handleRequest() method
    private static void runTest(String filePath, ImmutableList<ConversionType> conversions) {
        ConvertPhotoActivity activity = DAGGER.provideConvertPhotoActivity();
        activity.handleRequest(filePath, conversions);
    }
}
