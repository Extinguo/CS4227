package gameobjects;

import java.awt.*;

public class ColorSetter {
    public static Color PickAcolor(int i)
    {
        Color color=null;
        switch (i)
        {
            case 1: color=Color.pink;break;
            case 2: color=Color.green;break;
            case 3: color=Color.ORANGE;break;
            default:color=Color.yellow;break;
        }
        return color;
    }
}
