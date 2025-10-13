public class StoryBook extends Book {

    private String mainCharacter;
    private boolean hasIllustrations;
    private Integer chapters;
    private String moralLesson;


    public String getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(String mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public boolean isHasIllustrations() {
        return hasIllustrations;
    }

    public void setHasIllustrations(boolean hasIllustrations) {
        this.hasIllustrations = hasIllustrations;
    }

    public Integer getChapters() {
        return chapters;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    public String getMoralLesson() {
        return moralLesson;
    }

    public void setMoralLesson(String moralLesson) {
        this.moralLesson = moralLesson;
    }


}
