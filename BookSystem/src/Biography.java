public class Biography extends HistoryBook {
    private String subjectPerson;
    private String chronologicalScope;
    private String primarySourceUse;

    public String getSubjectPerson() {
        return subjectPerson;
    }

    public void setSubjectPerson(String subjectPerson) {
        this.subjectPerson = subjectPerson;
    }

    public String getChronologicalScope() {
        return chronologicalScope;
    }

    public void setChronologicalScope(String chronologicalScope) {
        this.chronologicalScope = chronologicalScope;
    }

    public String getPrimarySourceUse() {
        return primarySourceUse;
    }

    public void setPrimarySourceUse(String primarySourceUse) {
        this.primarySourceUse = primarySourceUse;
    }
}
