public class FableCollection extends StoryBook{
    private String moralLesson;
    private String culturalOrigin;
    private Boolean anthropomorphicCharacters;

    public String getMoralLesson() {
        return moralLesson;
    }

    public void setMoralLesson(String moralLesson) {
        this.moralLesson = moralLesson;
    }

    public Boolean getAnthropomorphicCharacters() {
        return anthropomorphicCharacters;
    }

    public void setAnthropomorphicCharacters(Boolean anthropomorphicCharacters) {
        this.anthropomorphicCharacters = anthropomorphicCharacters;
    }

    public String getCulturalOrigin() {
        return culturalOrigin;
    }

    public void setCulturalOrigin(String culturalOrigin) {
        this.culturalOrigin = culturalOrigin;
    }
}
