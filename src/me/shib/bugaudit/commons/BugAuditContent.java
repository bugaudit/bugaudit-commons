package me.shib.bugaudit.commons;

public class BugAuditContent {

    private String markdownText;

    public BugAuditContent(String markdownText) {
        this.markdownText = markdownText;
    }

    public String getMarkdownContent() {
        return markdownText;
    }

    public String getHtmlContent() {
        return BugAuditContentUtils.getContentUtils().convertToHTML(markdownText);
    }

    public String getJiraContent() {
        String jiraText = markdownText.replace("**", "*").replace("__", "*");
        jiraText = jiraText.replace("```", "{code}")
                .replace("~~~", "{code}");
        String[] urlSplit = jiraText.split("]\\(");
        StringBuilder urlCleanedText = new StringBuilder().append(urlSplit[0]);
        for (int i = 1; i < urlSplit.length; i++) {
            urlCleanedText.append("|").append(urlSplit[i].replaceFirst("\\)", "]"));
        }
        return urlCleanedText.toString();
    }

    public String getContent(Type type) {
        switch (type) {
            case Markdown:
                return markdownText;
            case HTML:
                return getHtmlContent();
            case Jira:
                return getJiraContent();
            default:
                return markdownText;
        }
    }

    public boolean isMatchingWith(String content, Type type) {
        switch (type) {
            case Markdown:
                return markdownText.contentEquals(content);
            case HTML:
                String cleanedSource = getHtmlContent().replaceAll(">\\s+", ">").replaceAll("\\s+<", "<");
                String cleanedDest = content.replaceAll(">\\s+", ">").replaceAll("\\s+<", "<");
                return cleanedSource.contentEquals(cleanedDest);
            case Jira:
                return getJiraContent().contentEquals(content);
        }
        return false;
    }

    public enum Type {
        Markdown, HTML, Jira
    }

}
