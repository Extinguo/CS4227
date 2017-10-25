package Interceptor;

/**
 * Created by viola on 2017/10/23.
 */
public class PlayerInfoContext implements I_Context {
    private String playerID, descriptionForLog;
    private int beans;

    public PlayerInfoContext(String playerID, int beans )
    {
        this.playerID = playerID;
        this.beans = beans;
        makeDescriptionForLog();
    }

    @Override
    public String getDescription() {
        return descriptionForLog;
    }

    private void makeDescriptionForLog()
    {
        descriptionForLog = "Player "+ playerID +" have ate "+ beans + " bean(s)";
    }
}
