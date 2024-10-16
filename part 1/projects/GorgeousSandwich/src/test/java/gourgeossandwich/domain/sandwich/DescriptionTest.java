package gourgeossandwich.domain.sandwich;


import gourgeossandwich.config.LanguageDetectorConfig;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;


class DescriptionTest {

    @Test
    public void testCreateDescription() {
        try (

            MockedConstruction<Language> mocked = Mockito.mockConstruction(Language.class,
            (mock, context) -> {
            });

            MockedStatic<LanguageDetectorConfig> ldmock = mockStatic(LanguageDetectorConfig.class);


        ) {
            ldmock.when(() -> LanguageDetectorConfig.detectLang(any())).thenReturn("BANANA");

            String validArg1 = "id1";
            String validArg2 = "id2";
            try {
                new Description(validArg1);
                new Description(validArg2);
            } catch(Exception e) {
                fail("Should not thrown exception");
            }

            String invalidArg = null;

            try{
                new Description(invalidArg);
                fail("Should have thrown exception");
            } catch(Exception e) {
                Assert.isInstanceOf(IllegalArgumentException.class,e);
                Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
            }

            String invalidArg2 = "";

            try{
                new Description(invalidArg2);
                fail("Should have thrown exception");
            } catch(Exception e) {
                Assert.isInstanceOf(IllegalArgumentException.class,e);
                Assert.isTrue(e.getMessage() == "The validated string is empty", "Should have the same message");
            }

        }

    }
}