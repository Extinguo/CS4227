package interceptor;


public class PlayerInfoContext implements I_Context {
    private String playerName;
    private String descriptionForLog;
    private int beans;
    /**
     *
     * Allow a concrete interceptor access the player information : player name and how many beans the player had eaten
     * @param playerName the name of player
     * @param beans  how many beans the player had eaten
     */
    public PlayerInfoContext(String playerName, int beans)
    {
        this.playerName = playerName;
        this.beans = beans;
        makeDescriptionForLog();
    }

    @Override
    public String getDescription() {
        return descriptionForLog;
    }

    private void makeDescriptionForLog()
    {
        descriptionForLog = "Player "+ playerName +" have ate "+ beans + " bean(s)";
    }
}
