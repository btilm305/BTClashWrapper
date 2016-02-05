package com.btilm305.clashapi;

/**
 * An interface that represents the different sizes for a single image. Note that images will only have 2 or 3 different
 * sizes.
 */
public interface IconSet {

    /**
     * Returns the URL for the large image
     *
     * @return the URL for the large image, or {@code null} if the image has no large size
     */
    String getLargeURL();

    /**
     * Returns the URL for the medium image
     *
     * @return the URL for the medium image, or {@code null} if the image has no medium size
     */
    String getMediumURL();

    /**
     * Returns the URL for the small image
     *
     * @return the URL for the small image, or {@code null} if the image has no small size
     */
    String getSmallURL();

    /**
     * Returns the URL for the tiny image
     *
     * @return the URL for the tiny image, or {@code null} if the image has no tiny size
     */
    String getTinyURL();

    /**
     * Returns if the image has a large size
     *
     * @return {@code true} if the image has a large size, {@code false} otherwise
     */
    boolean hasLargeURL();

    /**
     * Returns if the image has a medium size
     *
     * @return {@code true} if the image has a medium size, {@code false} otherwise
     */
    boolean hasMediumURL();

    /**
     * Returns if the image has a small size
     *
     * @return {@code true} if the image has a small size, {@code false} otherwise
     */
    boolean hasSmallURL();

    /**
     * Returns if the image has a tiny size
     *
     * @return {@code true} if the image has a tiny size, {@code false} otherwise
     */
    boolean hasTinyURL();
}
