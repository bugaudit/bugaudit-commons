package me.shib.bugaudit.commons;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

class BugAuditContentUtils {

    private static final BugAuditContentUtils contentUtils = new BugAuditContentUtils();
    private Parser parser;
    private HtmlRenderer renderer;

    private BugAuditContentUtils() {
        this.parser = Parser.builder().build();
        this.renderer = HtmlRenderer.builder().build();
    }

    static BugAuditContentUtils getContentUtils() {
        return contentUtils;
    }

    String convertToHTML(String commonmarkText) {
        Node document = parser.parse(commonmarkText);
        return renderer.render(document);
    }

}
