/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package javax.application;

import java.util.Locale;

import static java.util.Objects.requireNonNull;

/**
 * @author Andres Almiray
 */
public class NoSuchMessageException extends RuntimeException {
    private static final long serialVersionUID = -3197770339868054069L;

    private final String key;
    private final Locale locale;

    /**
     * Create a new exception.
     *
     * @param key    key that could not be resolved for given locale
     * @param locale locale that was used to search for the code within
     */
    public NoSuchMessageException(String key, Locale locale) {
        this(key, locale, null);
    }

    /**
     * Create a new exception.
     *
     * @param key key that could not be resolved for given locale
     */
    public NoSuchMessageException(String key) {
        this(key, Locale.getDefault());
    }

    /**
     * Create a new exception.
     *
     * @param key   key that could not be resolved for given locale
     * @param cause throwable that caused this exception
     */
    public NoSuchMessageException(String key, Throwable cause) {
        this(key, Locale.getDefault(), cause);
    }

    /**
     * Create a new exception.
     *
     * @param key    key that could not be resolved for given locale
     * @param locale locale that was used to search for the code within
     * @param cause  throwable that caused this exception
     */
    public NoSuchMessageException(String key, Locale locale, Throwable cause) {
        super("No message found under key '" + requireNonNull(key, "key") + "' for locale '" + requireNonNull(locale, "locale") + "'.", cause);
        this.key = key;
        this.locale = locale;
    }

    /**
     * Get the key without a valid value
     *
     * @return The key
     */
    public String getKey() {
        return key;
    }

    /**
     * Get the locale without a valid value
     *
     * @return The locale
     */
    public Locale getLocale() {
        return locale;
    }
}