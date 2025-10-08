import java.util.List;
import java.util.Map;

public class StoryBook {

    private String mainCharacter;
    private List<String> secondaryCharacters;
    private boolean hasIllustrations;
    private int chapters;
    private String moralLesson;
    private Map<String, String> characterTypes;


    public String getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(String mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public List<String> getSecondaryCharacters() {
        return secondaryCharacters;
    }

    public void setSecondaryCharacters(List<String> secondaryCharacters) {
        this.secondaryCharacters = secondaryCharacters;
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

    public Map<String, String> getCharacterTypes() {
        return characterTypes;
    }

    public void setCharacterTypes(Map<String, String> characterTypes) {
        this.characterTypes = characterTypes;
    }
}
