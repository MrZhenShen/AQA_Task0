package testFramework.duolingoUI.util;

import com.google.cloud.translate.*;

public class Translator {
    private final static Translate translate = TranslateOptions.getDefaultInstance().getService();

    public static String translate(String text) {
        return translate
                .translate(text)
                .getTranslatedText().replace("&#39;", "'");
    }

    public static String translate(String text, String toLang) {
        return translate
                .translate(text,
                        Translate.TranslateOption.targetLanguage(toLang))
                .getTranslatedText().replace("&#39;", "'");
    }

    public static String translate(String text, String fromLang, String toLang) {
        return translate
                .translate(text,
                        Translate.TranslateOption.sourceLanguage(fromLang),
                        Translate.TranslateOption.targetLanguage(toLang))
                .getTranslatedText().replace("&#39;", "'");
    }
}
