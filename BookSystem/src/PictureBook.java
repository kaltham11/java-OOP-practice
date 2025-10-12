public class PictureBook extends StoryBook{
    private String illustratorStyle;
    private String targetAgeRange;
    private Integer wordCountPerPage;

    public String getIllustratorStyle() {
        return illustratorStyle;
    }

    public void setIllustratorStyle(String illustratorStyle) {
        this.illustratorStyle = illustratorStyle;
    }

    public String getTargetAgeRange() {
        return targetAgeRange;
    }

    public void setTargetAgeRange(String targetAgeRange) {
        this.targetAgeRange = targetAgeRange;
    }

    public Integer getWordCountPerPage() {
        return wordCountPerPage;
    }

    public void setWordCountPerPage(Integer wordCountPerPage) {
        this.wordCountPerPage = wordCountPerPage;
    }
}