public class MilitaryHistoryBook extends HistoryBook  {
    private String conflictFocus;
    private Boolean strategicMapsIncluded;
    private String technologicalAnalysis;

    public String getConflictFocus() {
        return conflictFocus;
    }

    public void setConflictFocus(String conflictFocus) {
        this.conflictFocus = conflictFocus;
    }

    public Boolean getStrategicMapsIncluded() {
        return strategicMapsIncluded;
    }

    public void setStrategicMapsIncluded(Boolean strategicMapsIncluded) {
        this.strategicMapsIncluded = strategicMapsIncluded;
    }

    public String getTechnologicalAnalysis() {
        return technologicalAnalysis;
    }

    public void setTechnologicalAnalysis(String technologicalAnalysis) {
        this.technologicalAnalysis = technologicalAnalysis;
    }
}
