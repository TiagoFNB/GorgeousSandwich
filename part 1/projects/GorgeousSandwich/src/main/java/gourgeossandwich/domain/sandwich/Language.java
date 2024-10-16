package gourgeossandwich.domain.sandwich;

import com.fasterxml.jackson.annotation.JsonProperty;
import gourgeossandwich.config.PropertiesConfig;
import org.apache.commons.lang.Validate;
import gourgeossandwich.domain.shared.ValueObject;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public final class Language implements ValueObject<Language> {

    @JsonProperty
    @Column(nullable = false)
    private String language;

    protected Language(){}

    /**
     * Constructor.
     *
     * @param language Language string.
     */
    public Language(final String language) throws Exception {
        Validate.notNull(language);
        Validate.notEmpty(language);

        String languages = PropertiesConfig.properties.getProperty("allowedLanguages");
        if(!languages.contains(language)) throw new Exception("Invalid language. " + language);
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language other = (Language) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return language.hashCode();
    }

    @Override
    public boolean sameValueAs(Language other) {
        return other != null && this.language.equals(other.language);
    }

    @Override
    public String toString() {
        return language;
    }
}
