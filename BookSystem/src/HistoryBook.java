public class HistoryBook {

    private String historicalPeriod;
    private String civilization;
    private boolean includesMaps;
    private String iSBN;

    public String getHistoricalPeriod() {
        return historicalPeriod;
    }

    public void setHistoricalPeriod(String historicalPeriod) {
        this.historicalPeriod = historicalPeriod;
    }

    public String getCivilization() {
        return civilization;
    }

    public void setCivilization(String civilization) {
        this.civilization = civilization;
    }

    public boolean isIncludesMaps() {
        return includesMaps;
    }

    public void setIncludesMaps(boolean includesMaps) {
        this.includesMaps = includesMaps;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }
}
