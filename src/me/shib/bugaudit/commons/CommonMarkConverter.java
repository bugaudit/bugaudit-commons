package me.shib.bugaudit.commons;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

class CommonMarkConverter {

    private static final CommonMarkConverter converter = new CommonMarkConverter();
    private Parser parser;
    private HtmlRenderer renderer;

    private CommonMarkConverter() {
        this.parser = Parser.builder().build();
        this.renderer = HtmlRenderer.builder().build();
    }

    static CommonMarkConverter getConverter() {
        return converter;
    }

    String convertToHTML(String commonmarkText) {
        Node document = parser.parse(commonmarkText);
        return renderer.render(document);
    }

}
