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
        return CommonMarkConverter.getConverter().convertToHTML(markdownText);
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

}
