package interceptor;

/**
 * Created by viola on 2017/10/20.
 */
public class PlayerInfoContext implements I_Context {
    private String playerName;
    private String descriptionForLog;
    private int beans;

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
