package com.gorgeous.SandwichManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.gorgeous.SandwichManagement.config.LanguageDetectorConfig;
import com.gorgeous.SandwichManagement.shared.ValueObject;

import org.apache.commons.lang.Validate;

import javax.persistence.*;

@Embeddable
@Access(AccessType.FIELD)
public final class Description implements ValueObject<Description> {

    @JsonProperty
    @Column(nullable = false)
    private String description;

    @JsonUnwrapped
    @Embedded
    private Language language;

    protected Description() { }

    /**
     * Constructor.
     *
     * @param description Description string.
     */
    public Description(final String description) throws Exception {
        Validate.notNull(description);
        Validate.notEmpty(description);


        String lang = LanguageDetectorConfig.detectLang(description);

        this.description = description;
        this.language = new Language(lang);
    }

    /**
     * @return String representation of this description
     */
    public String descriptionString() {
        return description;
    }

    /**
     * @return String representation of this description
     */
    public String languageString() {
        return language.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Description other = (Description) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }

    @Override
    public boolean sameValueAs(Description other) {
        return other != null && this.description.equals(other.description);
    }

    @Override
    public String toString() {
        return description + ' ' + language.toString();
    }
}
