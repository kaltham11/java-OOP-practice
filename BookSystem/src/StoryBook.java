public class StoryBook {

    private String mainCharacter;
    private boolean hasIllustrations;
    private int chapters;
    private String moralLesson;
    private String iSBN;


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

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public String getMoralLesson() {
        return moralLesson;
    }

    public void setMoralLesson(String moralLesson) {
        this.moralLesson = moralLesson;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

}
