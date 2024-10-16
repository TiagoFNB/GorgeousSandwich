package com.gorgeous.SandwichManagement.config;

import com.github.pemistahl.lingua.api.Language;
import com.github.pemistahl.lingua.api.LanguageDetector;
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder;

public final class LanguageDetectorConfig {
    private static final LanguageDetector languageDetector;

    static {
        System.out.println("Loading languageBuilder.");
        languageDetector = LanguageDetectorBuilder.fromAllLanguages().withPreloadedLanguageModels().build();
        System.out.println("Loaded languageBuilder.");
    }

    public static void forceInit() {}

    /**
     * Detects the language of a given string
     * @param sentence
     * @return
     */
    public static String detectLang(String sentence) {
        Language lang = languageDetector.detectLanguageOf(sentence);
        return lang.getIsoCode639_1().name();
    }

}
