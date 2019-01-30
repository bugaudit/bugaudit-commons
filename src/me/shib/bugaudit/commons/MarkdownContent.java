package me.shib.bugaudit.commons;

public class MarkdownContent {

    private String markdownText;

    public MarkdownContent(String markdownText) {
        this.markdownText = markdownText;
    }

    public String getMarkdownText() {
        return markdownText;
    }

    public String getJiraFormatText() {
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
